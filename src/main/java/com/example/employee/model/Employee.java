package com.example.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee{
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="emp_id")
            private Long id;
        
        @Column(name="first_name")
        private String firstName;
        
        @Column(name="last_name")
        private String lastName;
        
        @Column(name="email_id")
        private String emailId;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
}