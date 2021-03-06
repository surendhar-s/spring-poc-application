package com.cognizant.secondService.controller;

import java.util.List;
import java.util.Optional;

import com.cognizant.secondService.models.CSVDataModel;
import com.cognizant.secondService.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dbConnector")
public class SaveFileToDB {

    @Autowired
    ProductService productSevice;

    @GetMapping("/")
    public String index() {
        return "Greeting from second-service";
    }

    @PostMapping("/saveData/{file_name}")
    public @ResponseBody List<CSVDataModel> saveData(@PathVariable("file_name") String fileName) {
        return productSevice.saveAll(fileName);
    }

    @GetMapping("/getAll")
    public List<CSVDataModel> getAllProducts() {
        return productSevice.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<CSVDataModel> getById(@PathVariable("id")String id) {
        return productSevice.getById(Integer.parseInt(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")String id){
        return productSevice.deleteById(Integer.parseInt(id));
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        return productSevice.deleteAll();
    }

}