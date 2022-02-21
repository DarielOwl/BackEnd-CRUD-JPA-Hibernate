package com.sofka.JPA.Services;

import com.sofka.JPA.Model.Role;
import com.sofka.JPA.Repository.IRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServices {
    
    @Autowired
    IRoleRepository roleRepository;
}
