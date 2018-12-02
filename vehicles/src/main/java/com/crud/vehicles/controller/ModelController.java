package com.crud.vehicles.controller;

import com.crud.vehicles.entity.ModelEntity;
import com.crud.vehicles.repositoty.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/model")
public class ModelController {

    @Autowired
    private ModelRepository repository;

    @CrossOrigin(origins = "", allowedHeaders = "")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    private ModelEntity save(@RequestBody ModelEntity entity) {
        return repository.save(entity);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    private List<ModelEntity> list() {
        return repository.findAll();
    }
}
