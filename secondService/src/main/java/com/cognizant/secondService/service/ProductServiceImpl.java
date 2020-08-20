package com.cognizant.secondService.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.secondService.dao.ProductRepository;
import com.cognizant.secondService.models.CSVDataModel;
import com.google.common.collect.Iterators;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepository productRepository;

    @Override
    @HystrixCommand(fallbackMethod = "fallback_saveAll", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
    public List<CSVDataModel> saveAll(String fileName) {
        CSVDataModel[] csvDataModels = restTemplate.getForObject("http://first-service/fileReader/fileName/" + fileName,
                CSVDataModel[].class);
        System.out.println("\n\n Completed API call\n\n");
        Iterable<CSVDataModel> productList = () -> Iterators.forArray(csvDataModels);
        return productRepository.saveAll(productList);
    }

    public List<CSVDataModel> fallback_saveAll(String fileName) {
        return null;
    }

    @Override
    public String deleteById(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            return "Something went wrong can't delete";
        }
        return "Product deleted";
    }

    @Override
    public Optional<CSVDataModel> getById(Integer id) {
        Optional<CSVDataModel> csvDataModel = productRepository.findById(id);
        return csvDataModel;
    }

    @Override
    public List<CSVDataModel> getAll() {
        List<CSVDataModel> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public String deleteAll() {
        try {
            productRepository.deleteAll();
        } catch (Exception e) {
            return "Something went wrong can't delete";
        }
        return "All product deleted";
    }

}