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

import com.resasncf.ResaSncf.Dto.OperationDTO;
import com.resasncf.ResaSncf.Models.Operation;
import com.resasncf.ResaSncf.UseCase.Service.OperationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/operation")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {
    private final OperationService service;

    
    @PostMapping("/create")
    public ResponseEntity<Operation> create(@RequestBody Operation operation) {
        return new ResponseEntity<>(service.create(operation), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Set<OperationDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OperationDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<Operation> update(@RequestBody Operation operation,@PathVariable long id){
        return new ResponseEntity<>(service.update(id, operation), HttpStatus.OK) ;
    }
}
