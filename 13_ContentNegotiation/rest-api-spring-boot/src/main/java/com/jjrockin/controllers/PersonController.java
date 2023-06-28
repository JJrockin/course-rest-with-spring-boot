package com.jjrockin.controllers;

import com.jjrockin.data.vo.v1.PersonVO;
import com.jjrockin.services.PersonServices;
import com.jjrockin.utils.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {
    @Autowired
    private PersonServices services;

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public List<PersonVO> findAll(){
        return services.findAll();
    }
    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable(value = "id") Long id){
        return services.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO person){
        return ResponseEntity.status(HttpStatus.CREATED).body(services.create(person));
    }
    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO person){
        return services.update(person);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

}
