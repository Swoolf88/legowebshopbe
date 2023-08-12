package com.swoolf.lego.controller;

import com.swoolf.lego.model.Cart;
import com.swoolf.lego.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CartController {

    @Autowired
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //get cart
    @GetMapping("/cart")
    public List<Cart> getAllCarts(){
        return  cartService.getAllCart();
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Cart cart = null;
        cart = cartService.getCartById(id);
        return ResponseEntity.ok(cart);
    }

    @PutMapping(value = {"/cart/{id}"}, consumes = {MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Cart> updateEmployee(@PathVariable Long id,
                                               @RequestParam("image") String image,
                                               @RequestParam("description") String description,
                                               @RequestParam("condition") String condition,
                                               @RequestParam("each") String each,
                                               @RequestParam("quantity") String quantity,
                                               @RequestParam("subtotal") String subtotal) throws IOException {
        Cart cart = new Cart();
        cart = cartService.updateCart(id, image, description, condition, each, quantity, subtotal);
        return ResponseEntity.ok(cart);
    }

}
