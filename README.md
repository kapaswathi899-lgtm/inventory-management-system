Inventory Management System

A backend Inventory Management System built using Spring Boot, Hibernate, and PostgreSQL, designed to manage products and stock efficiently.
This project demonstrates clean backend architecture, REST API development, database integration, exception handling, and CRUD operations using Spring Data JPA.

🚀 Features

🔹 Product Management

Add new products

Update existing products

Delete products

Get product by ID

Get all products


🔹 Inventory & Stock Management

Track stock levels

Prevent negative stock updates

Auto-validation for request data

Smooth handling of inventory changes


🔹 REST API

Clean, RESTful API endpoints

JSON input/output

Easy to integrate with frontend or mobile apps


🔹 Robust Architecture

Controller → Service → Repository (clean layered design)

DTOs for clean request/response

Centralized exception handling

Reusable service methods

🛠 Technologies Used

Technology	Purpose

Java	Core backend logic
Spring Boot	REST API development
Hibernate / JPA	ORM for mapping Java objects to database tables
PostgreSQL	Database for storing product & stock details
Spring Data JPA	Simplified database operations
Maven	Build and dependency management



---

📚 Skills Demonstrated

Building scalable REST APIs

Implementing CRUD operations

Working with Hibernate for ORM

Writing entity classes, repositories, and services

Connecting Spring Boot to PostgreSQL

Managing database tables and relationships

Error handling using custom exceptions

Validating inputs using Spring validation

Layered backend architecture

📁 Project Structure

src/
 ├── main/
 │   ├── java/
 │   │   └── com.example.inventory
 │   │       ├── controller/
 │   │       ├── service/
 │   │       ├── repository/
 │   │       └── model/
 │   └── resources/
 │       ├── application.properties
 │       └── static/
 └── test/
 
⚙ How to Run

1️⃣ Clone the repository

git clone https://github.com/kapaswathi899-lgtm/inventory-management-system.git

2️⃣ Navigate into the project

cd inventory-management-system

3️⃣ Configure PostgreSQL

Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/inventorydb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4️⃣ Run the application

Using Maven:

mvn spring-boot:run

Or in STS/Eclipse: → Right-click project → Run As → Spring Boot App

🔗 API Endpoints (Examples)

Method	Endpoint	Description

GET	/products	Get all products
GET	/products/{id}	Get product by ID
POST	/products	Add new product
PUT	/products/{id}	Update product
DELETE	/products/{id}	Delete product

🧪 Testing Tools

Postman

cURL

Browser (for GET requests)

📝 Future Enhancements

JWT authentication

Role-based access (Admin/User)

Supplier module

Stock movement history

Frontend (React/Angular)

👩‍💻 Author

Swathi Kapa
🔗 GitHub: https://github.com/kapaswathi899-lgtm
