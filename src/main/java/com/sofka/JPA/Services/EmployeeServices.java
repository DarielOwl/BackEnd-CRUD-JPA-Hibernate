package com.sofka.JPA.Services;

import com.sofka.JPA.Model.Employee;
import com.sofka.JPA.Repository.IEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    IEmployeeRepository employeeRepository; // Generamos singlenton

    // 1) Obtener todos los Empleados
    public ArrayList<Employee> getAllEmployee() {
        return (ArrayList<Employee>) employeeRepository.findAll();
    }

    // 2) Obtener por ID el empleado
    public Optional<Employee> getEmployeeByID(Long id) {
        return this.employeeRepository.findById(id);
    }
    
    // 3) Crear Empleado
    public Employee createEmployee(Employee newEmploye) {
        return employeeRepository.save(newEmploye);
    }

    // 4) Eliminar Empleado
    public void deleteById(long id) {
        //En cualquier caso de fallos se encarga el controlador de notificar
        this.employeeRepository.deleteById(id); 
    }

    //5) Actualizar Empleado
    public ResponseEntity<Employee> updateEmployee(Long id, Employee empData) {
        Optional<Employee> oldEmployee = this.employeeRepository.findById(id);

        if(oldEmployee.isPresent()){ //Si esta el viejo empleado (a actualizarlo)

            //Llenamos los datos del Nuevo Empleado
            Employee newEmployee = oldEmployee.get();
            newEmployee.setFirstName(empData.getFirstName());
            newEmployee.setLastName(empData.getLastName());
            newEmployee.setEmployeeid(empData.getEmployeeid());
            newEmployee.setRole(empData.getRole());
            newEmployee.setProjects(empData.getProjects());

            return new ResponseEntity<>(employeeRepository.save(newEmployee), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
