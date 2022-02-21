package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Role;
import com.sofka.JPA.Services.RoleServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role") // URL de role
public class RoleController {

    @Autowired
    RoleServices rServices = new RoleServices(); // Instancia singlenton

    // 1) Obtener todos los Roles de Empleados
    @GetMapping()
    public ArrayList<Role> getAllRoles() {
        return this.rServices.getAllRoles();
    }

    // 2) Obtener por ID el Role
    @GetMapping("/role/search/{id}")
    public Optional<Role> getRoleByID(@PathVariable("id") Long id) {
        return this.rServices.getRoleByID(id);
    }

    // 3) Crear Role
    @PostMapping()
    public Role createRole(@RequestBody Role newRole) {
        return this.rServices.createRole(newRole);
    }

    // 4) Eliminar Role
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") long id) {
        try {
            rServices.deleteById(id); // Elimina por su id
            return new ResponseEntity<>("Empledo fue BORRADO!!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    // 5) Actualizar Empleado
    @PutMapping("/role/update/{id}")
    public ResponseEntity<Role> updateEmployee(@PathVariable("id") Long id, @RequestBody Role rolData) {
        return this.rServices.updateRole(id, rolData);
    }

}
