package com.swoolf.lego.services;

import com.swoolf.lego.model.Lego;
import java.util.List;

public interface LegoService {
    Lego createLego(Lego lego);

    List<Lego> getAllLegos();

    boolean deleteLego(Long id);

    Lego getLegoById(Long id);

    Lego saveLegoToDB(String image, String description, String condition,
                      String each, String quantity, String subtotal);

    Lego updateLego(Long id, String image, String description, String condition,
                    String each, String quantity, String subtotal);
}
