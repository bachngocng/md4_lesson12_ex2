package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private IPhoneService phoneService;

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView =  new ModelAndView("/list");
        Iterable<Smartphone> smartphones = phoneService.findAll();
        modelAndView.addObject("smartphones",smartphones);
        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return  new ResponseEntity<>(phoneService.save(smartphone), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone  (@PathVariable Long id){
        Optional<Smartphone> smartphoneOptional = phoneService.findById(id);
        if(!smartphoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(),HttpStatus.OK);
    }
}
