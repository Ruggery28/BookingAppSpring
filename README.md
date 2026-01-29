🚀 Spring Boot 3 User Management SystemA robust, full-stack CRUD (Create, Read, Update, Delete) application built with Spring Boot 3, featuring server-side validation, a layered architecture, and dynamic search capabilities.
🌟 FeaturesFull CRUD Operations: Create, view, edit, and delete user profiles.Dynamic Search: Filter the user list in real-time by name using SQL LIKE queries.Smart "Upsert" Form: A reusable Thymeleaf form that handles both new registrations and user updates.Form Validation: Server-side data integrity using Hibernate Validator (Jakarta Validation).Persistent Storage: MySQL integration with Spring Data JPA for reliable data management.Clean UI: Responsive layout styled with custom CSS and Thymeleaf fragments.🛠️ Tech StackTechnologyPurposeJava 17Core programming languageSpring Boot 4.0.1Application frameworkSpring Data JPADatabase abstraction and ORMMySQLRelational databaseThymeleafServer-side template engineMavenDependency management
🏗️ ArchitectureThis project follows a professional Layered MVC architecture to ensure a clean separation of concerns:Controller Layer: Manages HTTP requests and routes them to the correct view or service.Service Layer: Contains business logic and acts as a bridge between the API and the Database.Repository Layer: Handles all database interactions using JpaRepository.Model Layer: Defines the data entities and validation constraints.📁 Project StructurePlaintextsrc/main/java/com/example/demo/

├── controller/     # View and Action controllers
├── model/          # User Entity with Validation
├── repository/     # JPA Repository interfaces
├── service/        # Business logic & filtering
└── DemoApplication # Main entry point
src/main/resources/
├── static/css/     # Custom CSS styling
└── templates/      # Thymeleaf HTML views

⚙️ Getting Started1. Database SetupEnsure you have a MySQL instance running. Create a database named booking_db:SQLCREATE DATABASE booking_db;
2. Configure application.propertiesUpdate src/main/resources/application.properties with your credentials:Propertiesspring.datasource.url=jdbc:mysql://localhost:3306/booking_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

3. Run the ApplicationOpen your terminal in the project root and run:Bash./mvnw spring-boot:run
Access the app at: http://localhost:8080/users-list📝 Lessons LearnedImplementing Data Binding with th:field to sync HTML forms with Java objects.Handling Ambiguous Mappings and resolving URL conflicts in Spring Controllers.Managing Database Persistence settings (ddl-auto) to protect data during development.Building Custom Queries in JPA using method naming conventions.
