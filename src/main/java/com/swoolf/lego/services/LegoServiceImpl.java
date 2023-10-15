package com.swoolf.lego.services;

import com.swoolf.lego.entity.LegoEntity;
import com.swoolf.lego.model.Lego;
import com.swoolf.lego.repository.LegoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LegoServiceImpl implements LegoService {

    private LegoRepository legoRepository;

    public LegoServiceImpl(LegoRepository legoRepository){
        this.legoRepository = legoRepository;
    }

    @Override
    public Lego createLego(Lego lego) {
        LegoEntity legoEntity = new LegoEntity();
        BeanUtils.copyProperties(lego, legoEntity);
        legoRepository.save(legoEntity);
        return lego;
    }

    @Override
    public List<Lego> getAllLegos() {
        List<LegoEntity> legoEntities
                = legoRepository.findAll();
        List<Lego> legos = legoEntities
                .stream()
                .map(emp -> new Lego(emp.getId()
//                        , emp.getImage(), emp.getDescription(), emp.getCondition(), emp.getEach(),
//                        emp.getQuantity(), emp.getSubtotal()))
                        ,emp.getImage(), emp.getFirstName(), emp.getLastName(),emp.getEmailId()))
                .collect(Collectors.toList());
        return legos;
    }

    @Override
    public boolean deleteLego(Long id) {
        LegoEntity lego = legoRepository.findById(id).get();
        legoRepository.delete(lego);
        return true;
    }

    @Override
    public Lego getLegoById(Long id) {
        LegoEntity legoEntity =
                legoRepository.findById(id).get();
        Lego lego = new Lego();
        BeanUtils.copyProperties(legoEntity, lego);
        return lego;
    }

    @Override
    public Lego updateLego(Long id, MultipartFile image,
//                           String description, String condition, String each,
//                           String quantity, String subtotal) {
                           String firstName, String lastName, String emailId) throws IOException {
        LegoEntity legoEntity
                = legoRepository.findById(id).get();
        Lego lego = new Lego();
        lego.setId(id);
        lego.setImage(image.getBytes());
        lego.setFirstName(firstName);
        lego.setLastName(lastName);
        lego.setEmailId(emailId);
//        lego.setDescription(description);
//        lego.setCondition(condition);
//        lego.setImage(image);
//        lego.setEach(each);
//        lego.setQuantity(quantity);
//        lego.setSubtotal(subtotal);
        BeanUtils.copyProperties(lego, legoEntity);
        legoRepository.save(legoEntity);
        return lego;
    }

    @Override
    public Lego saveLegoToDB(MultipartFile image,
//                             String description, String condition, String each,
//                             String quantity, String subtotal) {
//        Lego lego = new Lego();
//        LegoEntity legoEntity = new LegoEntity();
//        BeanUtils.copyProperties(lego, legoEntity);
//        lego.setDescription(description);
//        lego.setCondition(condition);
//        lego.setImage(image);
//        lego.setEach(each);
//        lego.setQuantity(quantity);
//        lego.setSubtotal(subtotal);
//        legoEntity.setDescription(description);
//        legoEntity.setCondition(condition);
//        legoEntity.setImage(image);
//        legoEntity.setEach(each);
//        legoEntity.setQuantity(quantity);
//        legoEntity.setSubtotal(subtotal);
                             String firstName, String lastName, String emailId) throws IOException {
        Lego lego = new Lego();
        LegoEntity legoEntity = new LegoEntity();
        BeanUtils.copyProperties(lego, legoEntity);
        lego.setFirstName(firstName);
        lego.setLastName(lastName);
        lego.setEmailId(emailId);
        lego.setImage(image.getBytes());
        legoEntity.setFirstName(firstName);
        legoEntity.setLastName(lastName);
        legoEntity.setEmailId(emailId);
        legoEntity.setImage(image.getBytes());
        legoRepository.save(legoEntity);
        return lego;
    }
}
