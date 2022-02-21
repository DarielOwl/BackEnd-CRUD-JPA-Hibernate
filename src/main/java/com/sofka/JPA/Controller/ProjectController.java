package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Project;
import com.sofka.JPA.Services.ProjectServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project") // URL de role
public class ProjectController {

    @Autowired
    ProjectServices pServices = new ProjectServices(); // Instancia singlenton

    // 1) Obtener todos los Proyectos
    @GetMapping()
    public ArrayList<Project> getAllProject() {
        return this.pServices.getAllProject();
    }

    // 2) Obtener por ID el Proyecto
    @GetMapping("/project/search/{id}")
    public Optional<Project> getProjectByID(@PathVariable("id") Long id) {
        return this.pServices.getProjectByID(id);
    }

    // 3) Crear Proyecto
    @PostMapping()
    public Project createProject(@RequestBody Project NewProject) {
        return this.pServices.createProject(NewProject);
    }

    // 4) Eliminar Proyecto
    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") long id) {
        try {
            pServices.deleteById(id); // Elimina por su id
            return new ResponseEntity<>("Proyecto fue BORRADO!!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    // 5) Actualizar Proyecto
    @PutMapping("/project/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project proData) {
        return this.pServices.updateProject(id, proData);
    }
}
