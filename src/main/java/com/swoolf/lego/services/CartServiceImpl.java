package com.swoolf.lego.services;

import com.sun.tools.doclint.Entity;
import com.swoolf.lego.entity.CartEntity;
import com.swoolf.lego.entity.EmployeeEntity;
import com.swoolf.lego.model.Cart;
import com.swoolf.lego.model.Employee;
import com.swoolf.lego.repository.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartById(Long id) {
        CartEntity cartEntity =
                cartRepository.findById(id).get();
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartEntity, cart);
        return cart;
    }

    @Override
    public List<Cart> getAllCart() {
        List<CartEntity> cartEntities
                = cartRepository.findAll();
        List<Cart> carts = cartEntities
                .stream()
                .map(emp -> new Cart(emp.getId()
                        , emp.getImage(), emp.getDescription(), emp.getCondition(), emp.getEach(),
                        emp.getQuantity(), emp.getSubtotal()))
                .collect(Collectors.toList());
        return carts;
    }

    @Override
    public Cart updateCart(Long id, String image,
                           String description, String condition, String each,
                           String quantity, String subtotal) throws IOException {
        CartEntity cartEntity
                = cartRepository.findById(id).get();
        Cart cart = new Cart();
        cart.setId(id);
        cart.setDescription(description);
        cart.setCondition(condition);
        cart.setImage(image);
        cart.setEach(each);
        cart.setQuantity(quantity);
        cart.setSubtotal(subtotal);
        BeanUtils.copyProperties(cart, cartEntity);
        cartRepository.save(cartEntity);
        return cart;
    }

}
