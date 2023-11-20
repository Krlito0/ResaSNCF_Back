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

import com.resasncf.ResaSncf.Dto.MaintenanceTypeDTO;
import com.resasncf.ResaSncf.Models.MaintenanceType;
import com.resasncf.ResaSncf.UseCase.Service.MaintenanceTypeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/maintenance_type")
@CrossOrigin(origins = "http://localhost:4200")
public class MaintenanceTypeController {

    private final MaintenanceTypeService service;

    @PostMapping("/create")
    public ResponseEntity<MaintenanceType> create(@RequestBody MaintenanceType maintenanceType) {
        return new ResponseEntity<>(service.create(maintenanceType), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Set<MaintenanceTypeDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MaintenanceTypeDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<MaintenanceType> update(@RequestBody MaintenanceType maintenanceType,@PathVariable long id){
        return new ResponseEntity<>(service.update(id, maintenanceType), HttpStatus.OK) ;
    }
}
