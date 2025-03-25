# Employee-Management-REST-API

A **Spring Boot REST API** for managing employee records, including **CRUD operations** (Create, Read, Update, Delete) using **Spring Boot, MySQL, JPA, and Hibernate**.

## 🚀 Features
- **Create** a new employee with custom `empId` (Numbers + Characters).
- **Retrieve** all employees sorted by `empId` in ascending order.
- **Retrieve** an employee by their `empId`.
- **Update** employee details (Full & Partial update using a single endpoint).
- **Delete** an employee with a success message.
- **Improved Error Handling** (Invalid field errors, Non-existent employee errors).
- **Enhanced URL Structure** for clarity and consistency.

---

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Postman** (for API testing)

---

## 👥 Installation & Setup

### **Step 1: Clone the Repository**
```sh
git clone https://github.com/shraddhagadale/Employee-Management-REST-API.git
cd Employee-Management-REST-API
```

### **Step 2: Configure the Database**
Update your **`src/main/resources/application.properties`** file with your MySQL credentials:
```
spring.datasource.username=your-username
spring.datasource.password=your-password
```

### **Step 3: Run MySQL**
Ensure MySQL is running. You can start it from the terminal:
```sh
mysql -u root -p
```
Create the database manually if it doesn't exist:
```sql
CREATE DATABASE employee_schema;
```

### **Step 4: Run the Application**
Run the project using **Maven**:
```sh
mvn clean install
mvn spring-boot:run
```
The application should now be running on:  
 http://localhost:8080

---

##  API Endpoints

### **1. Create an Employee**
**`POST /api/employee/create-employee`**  
📩 **Request Body (JSON):**
```json
{
  "empId": "EMP001",
  "firstName": "John",
  "lastName": "Doe",
  "emailId": "john.doe@example.com"
}

```

### **2. Get All Employees**
**`GET /api/employee/get-employee`**
- Returns all employees sorted by empId in ascending order.

### **3. Get Employee by empId**
**`GET /api/employee/get-employee-id/{empId}`** 

### **4. Update Employee**
**`PUT /api/employee/update-employee/{empId}`**  
📩 **Request Body (JSON):**
```json
{
  "firstName": "Joe",
  "emailId": "joe.d@example.com"
}

```

### **5. Delete Employee**
**`DELETE /api/employee/delete-employee/{empId}`**

---

## 🛠️ Testing with Postman
1. Open **Postman**.
2. Use the API endpoints above.
3. Set **Content-Type** to `application/json` for `POST` and `PUT` requests.
4. Use **http://localhost:8080/api/employees** as the base URL.


