package com.sofka.JPA.Services;

import com.sofka.JPA.Model.Project;
import com.sofka.JPA.Repository.IProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices {

    @Autowired
    IProjectRepository projectRepository;

    // 1) Obtener todos los Proyectos
    public ArrayList<Project> getAllProject() {
        return (ArrayList<Project>) projectRepository.findAll();
    }

    // 2) Obtener por ID el proyecto
    public Optional<Project> getProjectByID(Long id) {
        return this.projectRepository.findById(id);
    }

    // 3) Crear Proyecto
    public Project createProject(Project NewProject) {
        return projectRepository.save(NewProject);
    }

    // 4) Eliminar proyecto
    public void deleteById(long id) {
        // En cualquier caso de fallos se encarga el controlador de notificar
        this.projectRepository.deleteById(id);
    }

    // 5) Actualizar proyecto
    public ResponseEntity<Project> updateProject(Long id, Project proData) {
        Optional<Project> oldProject = this.projectRepository.findById(id);

        if (oldProject.isPresent()) { // Si esta el viejo projecto (a actualizarlo)

            // Llenamos los datos del Nuevo Projecto
            Project newProject = oldProject.get();
            newProject.setId(proData.getId());
            newProject.setName(proData.getName());

            return new ResponseEntity<>(projectRepository.save(newProject), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
