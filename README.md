# Task Management System

A **Task Management System** built using **Spring Boot** that allows users to manage tasks efficiently with features like task creation, updates, deletion, and filtering by status, priority, and project.

---

## Features

- **CRUD Operations** for tasks, projects, and users
- **Filtering by Status, Priority, and Project**
- **Assigning Tasks to Users**
- **User Management with Role-Based Access**
- **Exception Handling with Custom Errors**
- **Spring Data JPA for Database Operations**
- **RESTful API with JSON Responses**
- **Optional Handling for Null Values**

---

## Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **H2/PostgreSQL/MySQL (Configurable Database)**
- **Maven**

---

## Project Structure
```
com.code.spring.taskmanagement/
│── src/main/java/com/code/spring/taskmanagement/
│   ├── controller/         # REST Controllers
│   ├── entity/             # JPA Entities
│   ├── repository/         # Spring Data JPA Repositories
│   ├── service/            # Business Logic & Service Layer
│   ├── exception/          # Custom Exception Handling
│   ├── TaskManagementApplication.java  # Main Application Entry
│── src/main/resources/
│   ├── application.properties  # Database & App Configurations
│── pom.xml (Dependencies & Build Configuration)
```

---

## Setup & Installation

### **Prerequisites**
- Java 21
- Maven 3+
- H2 database

### **Steps to Run the Project**
1. **Clone the repository**
   ```sh
   git clone https://github.com/Amaninreal/task-management.git
   cd task-management
   ```
2. **Configure Database** in `src/main/resources/application.properties`
   ```properties
   spring.datasource.url=jdbc:h2:file:./data/bookdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.jpa.hibernate.ddl-auto=update
   ```
3. **Build the project**
   ```sh
   mvn clean install
   ```
4. **Run the application**
   ```sh
   mvn spring-boot:run
   ```
5. **Access the API** at `http://localhost:8080`

---

## API Endpoints

### **Task Management APIs**

| Method  | Endpoint                         | Description                  |
|---------|----------------------------------|------------------------------|
| **POST**  | `/tasks`                        | Create a new task            |
| **GET**   | `/tasks`                        | Get all tasks                |
| **GET**   | `/tasks/{id}`                   | Get task by ID               |
| **PUT**   | `/tasks/{id}`                   | Update task                  |
| **DELETE**| `/tasks/{id}`                   | Delete task                  |
| **PATCH** | `/tasks/{id}/status?status=X`   | Update task status           |
| **GET**   | `/tasks/status/{status}`        | Get tasks by status          |
| **GET**   | `/tasks/priority/{priority}`    | Get tasks by priority        |
| **GET**   | `/tasks/project/{projectId}`    | Get tasks by project         |

### **Project Management APIs**

| Method  | Endpoint                         | Description                  |
|---------|----------------------------------|------------------------------|
| **POST**  | `/projects`                     | Create a new project         |
| **GET**   | `/projects`                     | Get all projects             |
| **GET**   | `/projects/{id}`                | Get project by ID            |
| **PUT**   | `/projects/{id}`                | Update project               |
| **DELETE**| `/projects/{id}`                | Delete project               |
| **GET**   | `/projects/user/{userId}`       | Get projects by user ID      |
| **GET**   | `/projects/status/{status}`     | Get projects by status       |
| **GET**   | `/projects/priority/{priority}` | Get projects by priority     |

### **User Management APIs**

| Method  | Endpoint                         | Description                  |
|---------|----------------------------------|------------------------------|
| **POST**  | `/users`                        | Create a new user            |
| **GET**   | `/users`                        | Get all users                |
| **GET**   | `/users/{id}`                   | Get user by ID               |
| **PUT**   | `/users/{id}`                   | Update user                  |
| **DELETE**| `/users/{id}`                   | Delete user                  |
| **GET**   | `/users/role/{role}`            | Get users by role            |
| **PATCH** | `/users/{id}/activate?status=X` | Activate or deactivate user  |

---

## 🛠 Example JSON Requests

### **Create Task**
```json
{
    "title": "Design UI",
    "status": "In Progress",
    "priority": "High",
    "deadline": "2025-04-01",
    "assignedTo": {
        "userId": 2,
        "username": "jane_smith",
        "email": "jane.smith@example.com",
        "role": "USER",
        "active": true
    }
}
```

### **Update Task Status**
```json
{
    "status": "Completed"
}
```

### **Activate/Deactivate User**
```json
PATCH /users/5/activate?status=true
```

### **Response Example**
```json
{
    "taskId": 1,
    "title": "Design UI",
    "status": "Completed",
    "priority": "High",
    "deadline": "2025-04-01",
    "assignedTo": {
        "userId": 2,
        "username": "jane_smith",
        "email": "jane.smith@example.com",
        "role": "USER",
        "active": true
    }
}
```