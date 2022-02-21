package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Role;
import com.sofka.JPA.Services.RoleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role") //URL de role
public class RoleController {
        
    @Autowired
    RoleServices rServices = new RoleServices(); //Instancia singlenton

}
