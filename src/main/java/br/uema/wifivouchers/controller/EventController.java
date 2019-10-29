/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uema.wifivouchers.controller;

import br.uema.wifivouchers.model.Event;
import br.uema.wifivouchers.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lccf
 */
@RestController
@RequestMapping({"/events"})
public class EventController {
    
    private EventRepository repository;

    public EventController(EventRepository repository) {
        this.repository = repository;
    }
    
    // métodos do CRUD aqui
    @GetMapping
    public Page<Event> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Event create(@RequestBody Event event) {
        return repository.save(event);
    }
    
}
