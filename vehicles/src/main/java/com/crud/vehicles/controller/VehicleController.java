package com.crud.vehicles.controller;

import com.crud.vehicles.common.SearchInput;
import com.crud.vehicles.entity.VehicleEntity;
import com.crud.vehicles.repositoty.VehicleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleController {

    @Autowired
    private VehicleRepository repository;

    @CrossOrigin(origins = "", allowedHeaders = "")
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    private VehicleEntity save(@RequestBody VehicleEntity entity) {
        return repository.save(entity);
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping
    private List<VehicleEntity> list() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "", allowedHeaders = "")
    @GetMapping(path = "/search")
    private List<VehicleEntity> search(@RequestBody SearchInput request) {
        Stream<VehicleEntity> list = repository.findAll().stream();

        if (StringUtils.isNotBlank(request.name))
            list = list.filter(f -> f.getName().contains(request.name));

        if (request.vehicleType != null)
            list = list.filter(f -> f.getType().equals(request.vehicleType));

        if (StringUtils.isNotBlank(request.automakerName))
            list = list.filter(f -> f.getAutomaker().getName().contains(request.automakerName));

        if (StringUtils.isNotBlank(request.modelName))
            list = list.filter(f -> f.getModel().getName().contains(request.modelName));

        if (StringUtils.isNotBlank(request.color))
            list = list.filter(f -> f.getColor().contains(request.color));

        if (request.kilometer != null) {
            if (request.searchType != null) {
                switch (request.searchType) {
                    case KILOMETER_LESS_THAN:
                        list = list.filter(f -> f.getKilometer() < request.kilometer);
                        break;
                    case KILOMETER_GREATER_THAN:
                        list = list.filter(f -> f.getKilometer() > request.kilometer);
                        break;
                    default:
                        list = list.filter(f -> f.getKilometer().equals(request.kilometer));
                }
            } else {
                list = list.filter(f -> f.getKilometer().equals(request.kilometer));
            }
        }

        if (request.motor != null) {
            if (request.searchType != null) {
                switch (request.searchType) {
                    case MOTOR_LESS_THAN:
                        list = list.filter(f -> f.getMotor() < request.motor);
                        break;
                    case MOTOR_GREATER_THAN:
                        list = list.filter(f -> f.getMotor() > request.motor);
                        break;
                     default:
                         list = list.filter(f -> f.getMotor().equals(request.motor));
                }
            } else {
                list = list.filter(f -> f.getMotor().equals(request.motor));
            }
        }

        if (request.value != null) {
            if (request.searchType != null) {
                switch (request.searchType) {
                    case VALUE_LESS_THAN:
                        list = list.filter(f -> f.getValue() < request.value);
                        break;
                    case VALUE_GREATER_THAN:
                        list = list.filter(f -> f.getValue() > request.value);
                        break;
                    default:
                        list = list.filter(f -> f.getValue().equals(request.value));
                }
            } else {
                list = list.filter(f -> f.getValue().equals(request.value));
            }
        }

        return list.collect(Collectors.toList());
    }
}
