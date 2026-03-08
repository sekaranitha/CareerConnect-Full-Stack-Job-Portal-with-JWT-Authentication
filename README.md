CareerConnect – Secure Job & Application Management Backend
Project Overview

CareerConnect is a secure backend application for managing job postings, user registrations, and applications. It uses Spring Boot for the REST API, MySQL for database management, and JWT (JSON Web Tokens) for authentication. This system allows companies to post jobs, and candidates to securely apply for them.

It is designed as a backend-only project with RESTful APIs, ideal for integration with any frontend framework such as React, Angular, or Vue.js.

Features

User Authentication & Authorization

Users can log in and receive a JWT token.

Token-based authentication ensures secure access to protected endpoints.

Roles: ADMIN and USER for permission control.

Job Management

Admin users can add, view, and delete job postings.

Users can view all available jobs.

Job Application Management

Users can apply to jobs.

Admins can view all applications.

Users can view their own applications.

Security

JWT-based authentication for secure API access.

Passwords stored in the database using encryption (e.g., BCrypt).

Database

MySQL database for persistent storage.

Tables: users, jobs, applications.

Tech Stack
Layer	Technology
Backend Framework	Spring Boot
Authentication	JWT (JSON Web Tokens)
Database	MySQL
ORM	Spring Data JPA / Hibernate
Build Tool	Maven
Java Version	17+
Database Schema
CREATE DATABASE talentforge;
USE talentforge;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

INSERT INTO users (name, email, password, role)
VALUES
('Admin User', 'admin@gmail.com', 'admin123', 'ADMIN'),
('Normal User', 'user@gmail.com', 'user123', 'USER');

CREATE TABLE jobs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    company VARCHAR(100) NOT NULL,
    location VARCHAR(100),
    description TEXT
);

CREATE TABLE applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    jobId INT NOT NULL,
    status VARCHAR(20) DEFAULT 'APPLIED',
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (jobId) REFERENCES jobs(id)
);
API Endpoints
Authentication

POST /api/auth/login – User login, returns JWT token

POST /api/auth/register – Register new user (optional)

Jobs

GET /api/jobs – Get all jobs

POST /api/jobs – Add a new job (Admin only)

DELETE /api/jobs/{id} – Delete a job (Admin only)

Applications

POST /api/applications – Apply to a job

GET /api/applications/user/{userId} – View user applications

Setup & Installation

Clone Repository

git clone <your-repo-url>
cd TalentForge

Setup MySQL

Create database using the schema above.

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/talentforge
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Run Spring Boot

mvn clean install
mvn spring-boot:run

Testing APIs

Use Postman or any API client.

Login with:

Email: admin@gmail.com

Password: admin123

Use the returned JWT token in Authorization: Bearer <token> header to access protected endpoints.

Project Structure
TalentForge/
│
├─ src/main/java/com/talentforge/
│   ├─ controller/       # REST Controllers
│   ├─ model/            # Entity Classes (User, Job, JobApplication)
│   ├─ repository/       # Spring Data Repositories
│   ├─ service/          # Business Logic
│   ├─ security/         # JWT, SecurityConfig
│   └─ TalentForgeApplication.java
│
├─ src/main/resources/
│   └─ application.properties
│
└─ pom.xml
Future Enhancements

Add role-based access control for fine-grained permissions.

Integrate frontend (React/Angular) for a complete system.

Add email notifications on job applications.

Implement pagination and search for jobs.

License

MIT License – Free to use and modify.
