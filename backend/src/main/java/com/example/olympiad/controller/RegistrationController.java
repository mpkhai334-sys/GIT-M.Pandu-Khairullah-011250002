package com.example.olympiad.controller;

import java.util.List;

import com.example.olympiad.model.Registration;
import com.example.olympiad.repository.RegistrationRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistrationController {

    private final RegistrationRepository repo;

    public RegistrationController(RegistrationRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public ResponseEntity<Registration> register(@Valid @RequestBody Registration r) {
        Registration saved = repo.save(r);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/registrations")
    public List<Registration> list() {
        return repo.findAll();
    }
}
