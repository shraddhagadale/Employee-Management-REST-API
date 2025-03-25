package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository; 

    // CREATE 
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    // READ
    public List<Employee> getEmployees() {
        return empRepository.findAll(Sort.by(Sort.Direction.ASC, "empId"));
    }
    
    public Employee getEmployeeById(String empId) {
        return empRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this empId : " + empId));
    }

    // DELETE
    public String deleteEmployee(String empId) {
        if (empRepository.existsById(empId)) {
            empRepository.deleteById(empId);
            return "Employee with ID " + empId + " has been deleted successfully.";
        } else {
            throw new ResourceNotFoundException("Employee not found for this id : " + empId);
        }
    }


    // UPDATE (Handles both Full and Partial Update)
    public Employee updateEmployee(String empId, Employee employeeDetails, Map<String, Object> updates) {
        Employee emp = empRepository.findById(empId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
        
     // Check if updates contain empId (Not allowed to change empId)
        if (updates != null && updates.containsKey("empId")) {
            throw new IllegalArgumentException("empId cannot be changed!");
            
        }
        
     // Check if employeeDetails contains empId (Not allowed to change empId)
        if (employeeDetails != null && employeeDetails.getEmpId() != null && !employeeDetails.getEmpId().equals(empId)) {
            throw new IllegalArgumentException("empId cannot be changed!");
        }

        
        // Full Update Scenario
        if (employeeDetails.getFirstName() != null) emp.setFirstName(employeeDetails.getFirstName());
        if (employeeDetails.getLastName() != null) emp.setLastName(employeeDetails.getLastName());
        if (employeeDetails.getEmailId() != null) emp.setEmailId(employeeDetails.getEmailId());

     // Partial Update Scenario
        if (updates != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "firstName":
                        emp.setFirstName((String) value);
                        break;
                    case "lastName":
                        emp.setLastName((String) value);
                        break;
                    case "emailId":
                        emp.setEmailId((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field: " + key);
                }
            });
        }
        return empRepository.save(emp);
    }


}
