package com.example.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    // Create Employee
    @PostMapping("/create-employee")
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    // Get All Employees
    @GetMapping("/get-employee")
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    // Get Employee by empId
    @GetMapping("/get-employee-id/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "empId") String empId) {
        Employee employee = empService.getEmployeeById(empId); 
        return ResponseEntity.ok().body(employee); 
    }

    // Update Employee (Handles both Full & Partial Update)
    @PutMapping("/update-employee/{empId}")
    public Employee updateEmployee(
            @PathVariable(value = "empId") String empId,
            @RequestBody(required = false) Employee employeeDetails,
            @RequestParam(required = false) Map<String, Object> updates) {

        return empService.updateEmployee(empId, employeeDetails, updates);
    }

    // Delete Employee
    @DeleteMapping("/delete-employee/{empId}")
    public ResponseEntity<String> deleteEmployees(@PathVariable(value = "empId") String id) {
        String responseMessage = empService.deleteEmployee(id);
        return ResponseEntity.ok(responseMessage);
    }
    


}
