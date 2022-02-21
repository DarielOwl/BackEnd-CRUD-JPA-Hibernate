package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Project;
import com.sofka.JPA.Services.ProjectServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project") //URL de role
public class ProjectController {

    @Autowired
    ProjectServices pServices = new ProjectServices(); //Instancia singlenton

}
