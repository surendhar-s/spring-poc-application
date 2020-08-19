package com.cognizant.secondService.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.secondService.models.CSVDataModel;

@Service
public interface ProductRepository extends JpaRepository<CSVDataModel, Integer> {
    
}