package com.cognizant.secondService.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.secondService.models.CSVDataModel;

@Repository
public interface ProductRepository extends JpaRepository<CSVDataModel, Integer> {
    
}