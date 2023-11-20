package com.resasncf.ResaSncf.Rest;

import java.util.Set;

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

import com.resasncf.ResaSncf.Dto.FuelCardDTO;
import com.resasncf.ResaSncf.Dto.FuelCardDTOWCar;
import com.resasncf.ResaSncf.Models.FuelCard;
import com.resasncf.ResaSncf.UseCase.Service.FuelCardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fuelcard")
@CrossOrigin(origins = "http://localhost:4200")
public class FuelCardController {

    private final FuelCardService service;

    @PostMapping("/create")
    public ResponseEntity<FuelCard> create(@RequestBody FuelCard fuelCard) {
        return new ResponseEntity<>(service.create(fuelCard), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Set<FuelCardDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FuelCardDTOWCar> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<FuelCard> update(@RequestBody FuelCard fuelCard,@PathVariable long id){
        return new ResponseEntity<>(service.update(id, fuelCard), HttpStatus.OK) ;
    }
}
