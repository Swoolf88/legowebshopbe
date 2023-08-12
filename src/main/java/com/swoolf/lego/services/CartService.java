package com.swoolf.lego.services;

import com.swoolf.lego.model.Cart;

import java.io.IOException;
import java.util.List;

public interface CartService {

    List<Cart> getAllCart();
    Cart getCartById(Long id);

    Cart updateCart(Long id, String image,
                    String description, String condition, String each,
                    String quantity, String subtotal) throws IOException;

}
