package com.crud.vehicles.controller;

import com.crud.vehicles.entity.AutomakerEntity;
import com.crud.vehicles.repositoty.AutomakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/automaker")
public class AutomakerController {

    @Autowired
    private AutomakerRepository repository;

    @CrossOrigin(origins = "", allowedHeaders = "")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public AutomakerEntity save(@RequestBody AutomakerEntity entity) {
        return repository.save(entity);
    }
    
    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    public List<AutomakerEntity> list() {
        return repository.findAll();
    }
}
