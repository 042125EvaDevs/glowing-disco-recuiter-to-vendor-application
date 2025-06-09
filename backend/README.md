# 🔧 Backend (Spring Boot)

This folder contains the Spring Boot application for the backend.

## ✅ Practical Tasks for Backend

### 1. REST API Setup
- Scaffold with Spring Initializr.
- Add dependencies: Web, JPA, PostgreSQL, Security.
- Create RESTful endpoints for core features.
- Add Swagger for API docs.

```bash
./mvnw spring-boot:run
```

### 2. CI/CD Integration
- Use GitHub Actions to build and test:
    - Run unit tests
    - Check formatting with Checkstyle
    - Build artifact

```yaml
# .github/workflows/backend.yml
name: Backend CI

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: '17'
      - name: Build with Maven
        run: ./mvnw clean install

```

### 3. Testing
- Unit tests with JUnit and Mockito
- Integration tests with Spring Boot Test

### 4. Deployment
- Package app with Maven
- Deploy to AWS EC2 or Elastic Beanstalk