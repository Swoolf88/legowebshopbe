package com.swoolf.lego.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class LegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String image;
    private String description;
    private String condition;
    private String each;
    private String quantity;
    private String subtotal;
}
