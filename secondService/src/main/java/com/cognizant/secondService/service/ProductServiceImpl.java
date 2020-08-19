package com.cognizant.secondService.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.secondService.dao.ProductRepository;
import com.cognizant.secondService.models.CSVDataModel;
import com.google.common.collect.Iterators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<CSVDataModel> saveAll(CSVDataModel[] csvDataModels) {
        Iterable<CSVDataModel> productList = () -> Iterators.forArray(csvDataModels);
        return productRepository.saveAll(productList);
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