package com.sofka.JPA.Controller;

import com.sofka.JPA.Model.Employee;
import com.sofka.JPA.Services.EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employeed") // URL de empleado
public class EmployeeController {

    @Autowired
    EmployeeServices eServices = new EmployeeServices(); // Instancia singlenton

    // 1) Obtener todos los Empleados
    @GetMapping("/employeed/all")
    public ArrayList<Employee> getAllEmployee() {
        return this.eServices.getAllEmployee();
    }

    // 2) Obtener por ID el empleado
    @GetMapping("/employeed/search/{id}")
    public Optional<Employee> getEmployeeByID(@PathVariable("id") Long id) {
        return this.eServices.getEmployeeByID(id);
    }

    // 3) Crear Empleado
    @PostMapping("/employeed/create")
    public Employee createEmployee(@RequestBody Employee newEmploye) {
        return this.eServices.createEmployee(newEmploye);
    }

    // 4) Eliminar Empleado
    @DeleteMapping("/employeed/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        try {
            eServices.deleteById(id); //Elimina por su id
            return new ResponseEntity<>("Empledo fue BORRADO!!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    //5) Actualizar Empleado
    @PutMapping("/employeed/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee empData) {
        return this.eServices.updateEmployee(id, empData);
    }




}
