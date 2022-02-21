package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Employee;
import com.sofka.JPA.Services.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeed") //URL de empleado
public class EmployeeController {
    
    @Autowired
    EmployeeServices eServices = new EmployeeServices(); //Instancia singlenton


}
