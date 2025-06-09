# 🧱 Initializing the Spring Boot Project

You can bootstrap your Spring Boot backend project using one of the following two methods:

## 🛠️ Option 1: Using IntelliJ IDEA

1. Open IntelliJ IDEA
2. Go to `File → New → Project`
3. Choose `Spring Initializr`
4. Fill in the project metadata:
    - **Group**: com.example
    - **Artifact**: backend
    - **Name**: backend
    - **Type**: Maven
    - **Language**: Java
    - **Packaging**: Jar
    - **Java version**: 17 or higher
5. Click `Next`
6. Select `Dependencies`:
    - **Spring Web**
    - **Spring Data JPA**
    - **Spring Security (optional)**
    - **PostgreSQL Driver**
    - **Spring Boot DevTools**
    - **Lombok (optional but recommended)**
    - **Spring Configuration Processor (optional)**
7. Click `Finish`


IntelliJ will generate and open the project automatically.

## 🌐 Option 2: Using Spring Initializr Website

1. Visit [https://start.spring.io](https://start.spring.io)
2. Fill in the following:
    - **Project**: Maven
    - **Language**: Java
    - **Spring Boot**: Choose the latest stable version
    - **Group**: com.example
    - **Artifact**: backend
    - **Name**: backend
    - **Packaging**: Jar
    - **Java**: 17 or 21
3. Click `Add Dependencies` and choose:
    - **Spring Web**
    - **Spring Data JPA**
    - **PostgreSQL Driver**
    - **Spring Security**
    - **Lombok**
4. Click `GENERATE`
    - A `.zip` file will download. 
    
5. Extract `.zip` into your [backend/](../backend/) folder.

Open the folder with IntelliJ or your IDE of choice and let it import the Maven project.

