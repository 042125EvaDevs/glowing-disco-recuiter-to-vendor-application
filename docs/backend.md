# 📄 Backend Documentation

This document provides comprehensive technical and code documentation for the backend component of this fullstack application, implemented using **Spring Boot** and deployed on **AWS**.

---

## 🛠️ 1. Technical Documentation

### 🔧 System Architecture

The backend is built using a **microservices** architecture pattern. It communicates with the React frontend over RESTful APIs and interacts with an AWS-hosted PostgreSQL database.

#### Components:

- **Controller Layer**: Exposes REST endpoints.
- **Service Layer**: Business logic and validation.
- **Repository Layer**: Interfaces with the PostgreSQL database via Spring Data JPA.
- **Security Layer**: Spring Security with JWT authentication.
- **External Integrations**: AWS RDS, S3, and CloudWatch.

```txt
[ React Frontend ]
        |
        v
[ REST Controller ]
        |
        v
[ Service Layer ]
        |
        v
[ Repository (JPA) ] --> [ PostgreSQL @ AWS RDS ]
```

## 📁 Folder Structure
```bash
backend/
├── src/
│   └── main/
│       ├── java/com/example/backend/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── mapper/
│       │   ├── model/
│       │   ├── config/
│       │   └── security/
│       └── resources/
│           ├── application.yml
│           └── static/
├── pom.xml
```

## 🛠️ API Endpoints

Base URL: [`https://<your-domain>/api`](https://localhost:8080/api)

| Method | Endpoint | Description | Auth Required |
| ------ | -------- | ----------- | ------------- |
| GET    | /api/users        | List all users        | ✅ Yes
| POST   | /api/auth/login   | Authenticate user     | ❌ No
| GET    | /api/health       | Health check          | ❌ No
| POST   | /api/files/upload | Upload file to AWS S3 | ✅ Yes


API docs generated via Swagger:

📎 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)


## ⚙️ Deployment Details
- **Cloud Provider**: AWS
- **Compute**: EC2 (or Elastic Beanstalk)
- **Database**: PostgreSQL on RDS
- **Storage**: File uploads stored on S3
- **Monitoring**: AWS CloudWatch Logs for application logs


## 🧾 2. Code Documentation

### ✅ Best Practices
- **Inline Comments**: Used for complex logic or business rules.
- **JavaDoc**: Public classes and methods are documented with JavaDoc.
- **Annotations**: Proper use of @RestController, @Service, @Repository, etc.
- **Configuration**: Clearly named properties in application.yml.

### 🔤 Sample JavaDoc

```java
/**
 * Handles user-related operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    /**
     * Get a list of all users.
     * @return List of users.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
```

## 📝 Setup Guide

### Prerequisites
- Java 17+
- Maven 3.8+
- PostgreSQL database (local or AWS RDS)
- AWS credentials for S3 integration

### Running Locally

```bash
# Set DB credentials in application.yml
./mvnw clean install
./mvnw spring-boot:run
```

## 🔄 Change Log

Track updates and changes in [`CHANGELOG.md`](../backend/CHANGELOG.md). Example format:
```markdown
## [1.0.1] - 2025-04-20
### Added
- JWT-based authentication
- File upload to AWS S3

### Fixed
- Swagger UI not loading in prod
```

## 📎 Related Links
- [Spring Boot Documentation]()
- [Swagger OpenAPI Docs]()
- [AWS RDS Docs]()
- [AWS S3 Docs]()
- [Project Planning Phase](https://watery-whale-92f.notion.site/Project-Planning-Phase-1c0408cc99df80f7a171f090a901ebbd)