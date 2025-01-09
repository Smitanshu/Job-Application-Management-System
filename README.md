# **Job Application Management System**
## **Overview**
The Job Application Management System is a robust application built using **Spring Boot**, providing RESTful APIs for managing `Company`, `Review`, and `Job` entities. This project demonstrates a modern approach to building scalable, containerized applications with advanced Spring Boot concepts.

---

## **Features**
1. **CRUD Operations**:
   - Comprehensive APIs to Create, Read, Update, and Delete `Company`, `Review`, and `Job` entities.
   - Thoroughly tested using **Postman**.

2. **Database Management**:
   - Initial testing with **H2 in-memory database** for rapid development.
   - Transitioned to **PostgreSQL** for persistent, production-grade database management.

3. **Containerization**:
   - Utilized **Docker Compose** to manage containers for the Spring Boot application and PostgreSQL database.

4. **Spring Boot Advanced Concepts**:
   - Implemented Dependency Injection, JPA, and Spring Data.
   - Leveraged configuration-driven development for flexibility and maintainability.

---

## **Technologies Used**
- **Spring Boot**: For RESTful API development and dependency injection.
- **H2 Database**: Quick and efficient database for initial development and testing.
- **PostgreSQL**: Robust and scalable database for production.
- **Docker Compose**: Simplified container orchestration for both the application and database.
- **Postman**: Comprehensive API testing and validation tool.

---

## **Setup Instructions**

### **Prerequisites**
1. **Java 17 or higher**: Required for running the Spring Boot application.
2. **Docker**: Ensure Docker and Docker Compose are installed.
3. **Postman** (optional): For API testing.

### **Steps to Run the Application**
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd job-application-management
   ```

2. **Build the Application**:
   ```bash
   ./mvnw clean package
   ```

3. **Run with Docker Compose**:
   ```bash
   docker-compose up --build
   ```
   This will start the Spring Boot application and the PostgreSQL database in separate containers.

4. **Access the APIs**:
   - Base URL: `http://localhost:8080`
   - Swagger or Postman collection can be used for testing.

---

## **Usage**
- **Company**: Add, view, update, or delete company details.
- **Review**: Manage user reviews for companies and jobs.
- **Job**: Add job postings with detailed information.

---

## **Testing**
- APIs have been tested using **Postman** to validate functionality and data consistency.

---

## **Future Enhancements**
1. Implementing authentication and authorization using **Spring Security**.
2. Adding a front-end interface using React .
3. Expanding functionality to include advanced search and filtering options.
4. Integration with third-party services for notifications.
5. Converting project into indic=vidual microservice such as Company, Review, Job.

---
## **Contributors**
- SmitanshU Ukey (Project Developer)
- If Anything changes free feel to contribute.
