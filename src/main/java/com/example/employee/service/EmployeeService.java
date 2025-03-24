package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.exception.ResourceNotFoundException;
import java.util.List;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.Employee;
import org.springframework.http.ResponseEntity;




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
            return empRepository.findAll();
        }
        
        public Employee getEmployeeById(Long employeeId) {
            return empRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        }

        // DELETE
        public void deleteEmployee(Long empId) {
            empRepository.deleteById(empId);
        }
        
     // UPDATE
        public Employee updateEmployee(Long empId, Employee employeeDetails) {
                Employee emp = empRepository.findById(empId).get();
                emp.setFirstName(employeeDetails.getFirstName());
                emp.setLastName(employeeDetails.getLastName());
                emp.setEmailId(employeeDetails.getEmailId());
                
                return empRepository.save(emp);                                
        }
        
        // PARTIAL UPDATE 
        
        public Employee updateEmployeePartially(Long id, Map<String, Object> updates) {
            Employee employee = empRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

            updates.forEach((key, value) -> {
                switch (key) {
                    case "firstName":
                        employee.setFirstName((String) value);
                        break;
                    case "lastName":
                        employee.setLastName((String) value);
                        break;
                    case "emailId":
                        employee.setEmailId((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field: " + key);
                }
            });

            return empRepository.save(employee);
        }

}