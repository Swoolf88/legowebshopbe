package com.swoolf.lego.services;

import com.swoolf.lego.model.Lego;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LegoService {
    Lego createLego(Lego lego);

    List<Lego> getAllLegos();

    boolean deleteLego(Long id);

    Lego getLegoById(Long id);

//    Lego saveLegoToDB(String image, String description, String condition,
//                      String each, String quantity, String subtotal);
Lego saveLegoToDB(MultipartFile image, String firstName, String lastName,
                  String emailId) throws IOException;
//    Lego updateLego(Long id, String image, String description, String condition,
//                    String each, String quantity, String subtotal);
Lego updateLego(Long id, MultipartFile image, String firstName, String lastName,
                    String emailId) throws IOException;
}
