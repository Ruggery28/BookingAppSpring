# 🚀 Spring Boot 3 User Management System

A robust, full-stack CRUD application built with **Spring Boot 3**, featuring server-side validation, a layered architecture, and dynamic search capabilities.

---

## 🌟 Features

* **Full CRUD Operations**: Create, view, edit, and delete user profiles.
* **Dynamic Search**: Filter the user list in real-time by name using SQL `LIKE` queries.
* **Smart "Upsert" Form**: A reusable Thymeleaf form that handles both new registrations and user updates.
* **Form Validation**: Server-side data integrity using Jakarta Validation.
* **Persistent Storage**: MySQL integration with Spring Data JPA.

---

## 🛠️ Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java 17** | Core programming language |
| **Spring Boot** | Application framework |
| **Spring Data JPA** | Database abstraction and ORM |
| **MySQL** | Relational database |
| **Thymeleaf** | Server-side template engine |

---

## 🏗️ Architecture

This project follows a professional **Layered MVC** architecture:



1.  **Controller Layer**: Manages HTTP requests and routes.
2.  **Service Layer**: Bridge between API and Database containing search logic.
3.  **Repository Layer**: Handles database interactions via `JpaRepository`.
4.  **Model Layer**: Defines the data entities and validation constraints.

---

## 📁 Project Structure

```text
src/main/java/com/example/demo/
├── controller/     # View and Action controllers
├── model/          # User Entity with Validation
├── repository/     # JPA Repository interfaces
├── service/        # Business logic & filtering
└── DemoApplication # Main entry point
