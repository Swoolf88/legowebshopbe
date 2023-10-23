package com.swoolf.lego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lego {
    private long id;
    private String image;
    private String firstName;
    private String lastName;
    private String emailId;
//    private String description;
//    private String condition;
//    private String each;
//    private String quantity;
//    private String subtotal;
}
