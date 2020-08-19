package com.cognizant.firstService.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.firstService.models.CSVDataModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fileReader")
public class CSVFileReader {

    @GetMapping("/")
    public String index() {
        return "Greeting from first-service";
    }

    @GetMapping(path = "/fileName/{file_path}")
    public CSVDataModel[] readFile(@PathVariable("file_path") String fileName) {
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
                CSVDataModel csvDataModel = new CSVDataModel(productName, productQuantity, productPrice, productIsAvailable);
                productList.add(csvDataModel);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CSVDataModel[] csvDataModel = new CSVDataModel[productList.size()];
        productList.toArray(csvDataModel);
        System.out.println("Data\n\n\n\n\n");
        // for(int i=0;i<csvDataModel.length;i++){
        //     System.out.println(csvDataModel[i].toString());
        // }
        return csvDataModel;
    }

}