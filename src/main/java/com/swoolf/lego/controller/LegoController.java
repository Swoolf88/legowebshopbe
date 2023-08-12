package com.swoolf.lego.controller;

import com.swoolf.lego.model.Lego;
import com.swoolf.lego.services.LegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LegoController {

    @Autowired
    private LegoService legoService;

    public LegoController(LegoService legoService) {
        this.legoService = legoService;
    }

    @PostMapping("/legos")
    public Lego createLego(@RequestBody Lego lego){
        return legoService.createLego(lego);
    }

    @PostMapping("/addLego")
    public Lego saveLego(@RequestParam("image") String image,
                         @RequestParam("description") String description,
                         @RequestParam("condition") String condition,
                         @RequestParam("each") String each,
                         @RequestParam("quantity") String quantity,
                         @RequestParam("subtotal") String subtotal) throws IOException {
        return legoService.saveLegoToDB(image, description, condition, each, quantity, subtotal);
    }
    @GetMapping("/legos")
    public List<Lego> getAllLegos(){
        return  legoService.getAllLegos();
    }

    @DeleteMapping("/legos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteLego(@PathVariable Long id) {
        boolean deleted = false;
        deleted = legoService.deleteLego(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/legos/{id}")
    public ResponseEntity<Lego> getLegoById(@PathVariable Long id) {
        Lego lego = null;
        lego = legoService.getLegoById(id);
        return ResponseEntity.ok(lego);
    }

    @PutMapping(value = {"/legos/{id}"}, consumes = {MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Lego> updateLego(@PathVariable Long id,
                                           @RequestParam("image") String image,
                                           @RequestParam("description") String description,
                                           @RequestParam("condition") String condition,
                                           @RequestParam("each") String each,
                                           @RequestParam("quantity") String quantity,
                                           @RequestParam("subtotal") String subtotal) throws IOException {
        Lego lego = new Lego();
         lego = legoService.updateLego(id, image, description, condition, each, quantity, subtotal);
         return ResponseEntity.ok(lego);
    }


}
