package com.cognizant.firstService.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.cognizant.firstService.models.CSVDataModel;

import org.springframework.stereotype.Service;

@Service
public class FileProcessorImpl implements FileProcessor {

    @Override
    public CSVDataModel[] readFile(String fileName) {
        String csvFileString = "D:/".concat(fileName).concat(".csv");
        String lineString = "";
        String splitByString = ",";
        ArrayList<CSVDataModel> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileString))) {
            while ((lineString = br.readLine()) != null) {
                String[] data = lineString.split(splitByString);
                String productName = data[0];
                int productQuantity = Integer.parseInt(data[1]);
                double productPrice = Double.parseDouble(data[2]);
                boolean productIsAvailable = Boolean.parseBoolean(data[3]);
                CSVDataModel csvDataModel = new CSVDataModel(productName, productQuantity, productPrice,productIsAvailable);
                productList.add(csvDataModel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVDataModel[] csvDataModel = new CSVDataModel[productList.size()];
        productList.toArray(csvDataModel);
        return csvDataModel;
    }
    
}