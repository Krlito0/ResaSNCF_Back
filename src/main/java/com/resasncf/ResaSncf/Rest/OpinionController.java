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

import com.resasncf.ResaSncf.Dto.OpinionDTO;
import com.resasncf.ResaSncf.Models.Opinion;
import com.resasncf.ResaSncf.UseCase.Service.OpinionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/opinion")
@CrossOrigin(origins = "http://localhost:4200")
public class OpinionController {
    private final OpinionService service;
 
    @PostMapping("/create")
    public ResponseEntity<Opinion> create(@RequestBody Opinion opinion) {
        return new ResponseEntity<>(service.create(opinion), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Set<OpinionDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OpinionDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<Opinion> update(@RequestBody Opinion opinion,@PathVariable long id){
        return new ResponseEntity<>(service.update(id, opinion), HttpStatus.OK) ;
    }
}
