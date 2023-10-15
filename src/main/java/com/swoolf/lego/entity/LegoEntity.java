package com.swoolf.lego.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class LegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private byte[] image;
    private String firstName;
    private String lastName;
    private String emailId;
//    private String description;
//    private String condition;
//    private String each;
//    private String quantity;
//    private String subtotal;
}
