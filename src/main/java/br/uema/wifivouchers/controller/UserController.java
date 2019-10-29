/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uema.wifivouchers.controller;

import br.uema.wifivouchers.model.User;
import br.uema.wifivouchers.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lccf
 */
@RestController
@RequestMapping({"/users"})
public class UserController {
    
    private UserRepository repository;
    
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // métodos do CRUD aqui
    @GetMapping
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public User create(@RequestBody User user) {
        return repository.save(user);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
            @RequestBody User user) {
        return repository.findById(id)
                .map(record -> {
                    record.setName(user.getName());
                    record.setUsername(user.getUsername());
                    record.setDt_birth(user.getDt_birth());
                    record.setEmail(user.getEmail());
                    record.setRole(user.getRole());
                    User updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
