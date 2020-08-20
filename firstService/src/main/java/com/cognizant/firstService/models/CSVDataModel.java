package com.cognizant.firstService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CSVDataModel {

    private String productName;
    private Integer productQuantity;
    private Double productPrice;
    private Boolean productIsAvailable;

}