package com.swoolf.lego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private long id;
    private String image;
    private String description;
    private String condition;
    private String each;
    private String quantity;
    private String subtotal;
}
