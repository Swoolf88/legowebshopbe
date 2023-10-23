package com.swoolf.lego.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "legos")
public class LegoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, length = 64)
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
