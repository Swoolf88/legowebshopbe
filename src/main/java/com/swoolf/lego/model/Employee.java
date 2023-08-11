package com.swoolf.lego.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String image;
}
