package com.resasncf.ResaSncf.Rest;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resasncf.ResaSncf.Dto.CarDTO;
import com.resasncf.ResaSncf.Dto.CarDTOminimalist;
import com.resasncf.ResaSncf.Models.Car;
import com.resasncf.ResaSncf.UseCase.Service.CarService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
    
    private final CarService service;


    @PostMapping("/create")
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return new ResponseEntity<>(service.create(car),HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CarDTOminimalist>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<Car> update(@RequestBody Car car,@PathVariable long id){
        return new ResponseEntity<>(service.update(id, car),HttpStatus.OK) ;
    }
}
