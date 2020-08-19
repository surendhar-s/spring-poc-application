package com.cognizant.secondService.controller;

import java.util.Arrays;
import java.util.List;

import com.cognizant.secondService.models.CSVDataModel;
import com.cognizant.secondService.repository.ProductRepository;
import com.google.common.collect.Iterators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/saveData")
public class SaveFileToDB {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "Greeting from second-service";
    }

    @PostMapping("/saveData/{file_name}")
    public @ResponseBody String saveData(@PathVariable("file_name") String fileName) {
        System.out.println("Hello\n\n\n\n\n");
        CSVDataModel[] csvDataModels = restTemplate.getForObject("http://first-service/fileReader/fileName/" + fileName,
                CSVDataModel[].class);
        for (int i = 0; i < csvDataModels.length; i++) {
            productRepository.save(new CSVDataModel(
                csvDataModels[i].getProductName(),
                csvDataModels[i].getProductQuantity(),
                csvDataModels[i].getProductPrice(),
                csvDataModels[i].getProductIsAvailable()
            ));
        }
        return "File Saved in DB";
    }

}