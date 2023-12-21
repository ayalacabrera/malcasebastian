package com.malcasebastian.sisgestion.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.malcasebastian.sisgestion.entity.Infraccion;
import com.malcasebastian.sisgestion.service.InfraccionService;

@RestController
@RequestMapping("/api/infracciones")
public class InfraccionApi {
    // Cambiado el nombre del controlador a InfraccionApi

    @Autowired
    private InfraccionService service;

    @GetMapping()
    public ResponseEntity<List<Infraccion>> getAll() {
        List<Infraccion> infracciones = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(infracciones);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Infraccion> getById(@PathVariable("id") Long id) {
        Infraccion infraccion = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(infraccion);
    }

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion infraccionDb = service.create(infraccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(infraccionDb);
    }

    @PutMapping
    public ResponseEntity<Infraccion> update(@RequestBody Infraccion infraccion) {
        Infraccion infraccionDb = service.update(infraccion);
        return ResponseEntity.status(HttpStatus.OK).body(infraccionDb);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
