# Employee-Management-REST-API

A **Spring Boot REST API** for managing employee records, including **CRUD operations** (Create, Read, Update, Delete) using **Spring Boot, MySQL, JPA, and Hibernate**.

## 🚀 Features
- 📌 **Create** a new employee.
- 🔍 **Retrieve** all employees.
- 📝 **Update** employee details.
- ❌ **Delete** an employee.
- 🛠️ Built with **Spring Boot**, **Spring Data JPA**, **MySQL**, and **Hibernate**.

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

### ✅ **Step 1: Clone the Repository**
```sh
git clone https://github.com/shraddhagadale/Employee-Management-REST-API.git
cd Employee-Management-REST-API
```

### ✅ **Step 2: Configure the Database**
Update your **`src/main/resources/application.properties`** file with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee-schema
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

### ✅ **Step 3: Run MySQL**
Ensure MySQL is running. You can start it from the terminal:
```sh
mysql -u root -p
```
Create the database manually if it doesn't exist:
```sql
CREATE DATABASE employee_schema;
```

### ✅ **Step 4: Run the Application**
Run the project using **Maven**:
```sh
mvn spring-boot:run
```
The application should now be running on:  
👉 **http://localhost:8080**

---

## 🔥 API Endpoints

### 📌 **1. Create an Employee**
**`POST /api/employees`**  
📩 **Request Body (JSON):**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "department": "Engineering"
}
```

### 📌 **2. Get All Employees**
**`GET /api/employees`**

### 📌 **3. Get Employee by ID**
**`GET /api/employees/{id}`**

### 📌 **4. Update Employee**
**`PUT /api/employees/{id}`**  
📩 **Request Body (JSON):**
```json
{
  "name": "John Updated",
  "email": "john.new@example.com",
  "department": "HR"
}
```

### 📌 **5. Delete Employee**
**`DELETE /api/employees/{id}`**

---

## 🛠️ Testing with Postman
1. Open **Postman**.
2. Use the API endpoints above.
3. Set **Content-Type** to `application/json` for `POST` and `PUT` requests.
4. Use **http://localhost:8080/api/employees** as the base URL.

---

## 📝 License
This project is **open-source** and free to use.

🚀 **Happy Coding!** 😊

