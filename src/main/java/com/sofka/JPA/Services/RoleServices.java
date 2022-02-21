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

    // 1) Obtener todos los Roles de Empleados
    public ArrayList<Role> getAllRoles() {
        return (ArrayList<Role>) roleRepository.findAll();
    }

    // 2) Obtener por ID el empleado
    public Optional<Role> getRoleByID(Long id) {
        return this.roleRepository.findById(id);
    }

    // 3) Crear Role
    public Role createRole(Role newRole) {
        return roleRepository.save(newRole);
    }

    // 4) Eliminar Role
    public void deleteById(long id) {
        // En cualquier caso de fallos se encarga el controlador de notificar
        this.roleRepository.deleteById(id);
    }

    public ResponseEntity<Role> updateRole(Long id, Role rolData) {
        Optional<Role> oldRol = this.roleRepository.findById(id);

        if(oldRol.isPresent()){ //Si esta el viejo rol (a actualizarlo)

            //Llenamos los datos del Nuevo Rol
            Role newRol = oldRol.get();
            newRol.setId(rolData.getId());
            newRol.setName(rolData.getName());

            return new ResponseEntity<>(roleRepository.save(newRol), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
