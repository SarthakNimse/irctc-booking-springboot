# 🚆 IRCTC Booking System - Spring Boot Application

This is a backend service for an IRCTC-like railway ticket booking system, built using Spring Boot, MySQL, and REST APIs. It handles user registration, train management, and booking operations in a modular, scalable, and RESTful architecture.

---

## 📌 Features

- 👤 **User Management**  
  - Register new users  
  - List all users  
  - Validate unique email

- 🚆 **Train Management** *(Coming Soon)*  
  - Add new trains  
  - List available trains  

- 🎟️ **Ticket Booking** *(Coming Soon)*  
  - Book tickets for trains  
  - View booking history  

- ✅ **Spring Boot Best Practices**  
  - Layered Architecture: Controller → Service → Repository  
  - Exception Handling  
  - Dependency Injection  
  - RESTful APIs with JSON

---

## 🛠️ Tech Stack

| Layer           | Technology           |
|----------------|----------------------|
| Backend         | Java 17, Spring Boot |
| Database        | MySQL                |
| Build Tool      | Maven                |
| API Testing     | Postman              |
| ORM             | Spring Data JPA, Hibernate |
| IDE             | IntelliJ IDEA        |

---

## 📁 Project Structure

com.irctc.booking
│
├── controller # REST controllers
├── service # Business logic
├── repository # Spring Data JPA interfaces
├── entity # JPA Entities (User, Train, Booking)
└── IRCTCBookingApplication.java

