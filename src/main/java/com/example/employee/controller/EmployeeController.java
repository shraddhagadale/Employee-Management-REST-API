package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import java.util.Map;


import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
        @Autowired
        EmployeeService empService;
        
        @RequestMapping(value="/employees", method=RequestMethod.POST)
        public Employee createEmployee(@RequestBody Employee emp) {
            return empService.createEmployee(emp);
        }
        @RequestMapping(value="/employees", method=RequestMethod.GET)
        public List<Employee> readEmployees() {
            return empService.getEmployees();
        }
        
     // Get an Employee by ID
        @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
        public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
            Employee employee = empService.getEmployeeById(employeeId); 
            return ResponseEntity.ok().body(employee); 
        }


        @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
        public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
            return empService.updateEmployee(id, empDetails);
        }

        @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
        public void deleteEmployees(@PathVariable(value = "empId") Long id) {
            empService.deleteEmployee(id);
        }
        
        @PatchMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployeePartially(
                @PathVariable(value = "id") Long id,
                @RequestBody Map<String, Object> updates) {
            Employee updatedEmployee = empService.updateEmployeePartially(id, updates);
            return ResponseEntity.ok(updatedEmployee);
        }

}