package com.cognizant.secondService.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.secondService.models.CSVDataModel;

public interface ProductService {
    public List<CSVDataModel> saveAll(String fileName);

    public String deleteById(Integer id);

    public Optional<CSVDataModel> getById(Integer id);

    public List<CSVDataModel> getAll();

    public String deleteAll();
}