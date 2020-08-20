package com.cognizant.firstService.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.firstService.models.CSVDataModel;
import com.cognizant.firstService.service.FileProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fileReader")
public class CSVFileReader {

    @Autowired
    FileProcessor fileProcessor;

    @GetMapping("/")
    public String index() {
        return "Greeting from first-service";
    }

    @GetMapping(path = "/fileName/{file_path}")
    public CSVDataModel[] readFile(@PathVariable("file_path") String fileName) {
        return fileProcessor.readFile(fileName);
    }

}