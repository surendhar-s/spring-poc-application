package com.cognizant.firstService.service;

import com.cognizant.firstService.models.CSVDataModel;

public interface FileProcessor {
    public CSVDataModel[] readFile(String fileName);
}