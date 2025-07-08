# BankingApp-CICD - Automated deployment of a Spring Boot-based mobile banking application using Azure DevOps CI/CD pipelines. This project demonstrates a secure, streamlined approach to building, testing, and releasing application updates to Azure Web Apps, following best practices for modern DevOps workflows.

# URLs (for submission)


* **Azure Web App (Live URL)**: \[https://app-wallet-cwu-b3cyamc4dsdnb7d9.southeastasia-01.azurewebsites.net/]
                                \[https://app-wallet-cwu-b3cyamc4dsdnb7d9.southeastasia-01.azurewebsites.net/swagger-ui.html]

# Introduction

This project demonstrates a complete CI/CD pipeline setup for a Spring Boot application using **Azure DevOps** and **Azure App Service** for deployment. The core objective is not only to build a secure and functional RESTful service using Spring Boot and JWT authentication, but more importantly, to automate its deployment through Azure’s cloud infrastructure.

Through this project, we aim to:

- Create a basic Spring Boot application with login and signup functionality.

- Configure and automate build and deployment steps using Azure Pipelines.

- Deploy the application to Azure App Service and ensure it runs as expected.

- Handle integration, configuration, and troubleshooting of pipeline-related challenges.

This documentation outlines the entire process, from project setup to successful deployment, focusing primarily on DevOps practices and cloud deployment.


# Project Architecture

The architecture of this project follows a typical microservice-like structure with integrated CI/CD using Azure DevOps. The components are outlined below:

### 1. Spring Boot Backend

* **Controllers**: Handle HTTP requests for signup, signin, and user profile.
* **Services**: Contain business logic for user management and authentication.
* **Repositories**: Interface with the in-memory H2 database using Spring Data JPA.
* **Configuration**: Includes security setup (JWT filter, password encoder, etc.).

### 2. CI/CD Pipeline in Azure DevOps

A single YAML file (`azure-pipelines.yml`) is used to:

* **Build** the application using Maven.
* **Package** it into a JAR file.
* **Publish artifacts**.
* **Deploy** the JAR file directly to **Azure App Service** using the `AzureWebApp` task.

To overcome **pipeline parallelism limitations** in Azure DevOps Free Tier, a **self-hosted runner** was configured and used for executing the pipeline efficiently without delays.

### 3. Azure App Service

* Runs the deployed Spring Boot JAR file.
* Binds to a dynamic port assigned by Azure (`${PORT:8080}` fallback).
* Supports public access through the given `.azurewebsites.net` domain.

This architecture ensures a smooth, automated flow from code commit to live deployment without any manual intervention.

# Tech Stack


The project leverages the following technologies and tools:

* **Java 11** – Core programming language used to develop the application.
* **Spring Boot** – Framework for building the RESTful backend.
* **Spring Security + JWT** – For authentication and authorization.
* **H2 Database (in-memory)** – Lightweight, fast database for local and cloud testing.
* **Maven** – Build tool for compiling, packaging, and managing dependencies.
* **Azure DevOps** – For CI/CD pipeline setup, repository hosting, and deployment automation.
* **Azure App Service** – Hosting platform for deploying the Spring Boot application.
* **Swagger UI** – For API documentation and interaction.

# Local Setup


Steps followed for local development and testing:

1. Clone the repository and open the project in VS Code.
2. Configure the `application.properties` with the following H2 in-memory database settings:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

3. Run the Spring Boot application.
4. Access Swagger UI at `http://localhost:8080/swagger-ui.html`.
5. Use the `/auth/signup` and `/auth/signin` endpoints to test user authentication.
6. Use the generated JWT to access protected endpoints like `/user/{username}`.

# Testing (Screenshots)

**Signup & Signin (Swagger):**

* POST `/auth/signup` with username and password.
* POST `/auth/signin` and receive a JWT.

**Accessing User Info:**

* GET `/user/{username}` using JWT in Authorization header.

**H2 Console:**

* Available at `/h2-console`
* JDBC URL: `jdbc:h2:mem:testdb`
* User: `sa`, Password: *(empty)*

*(Screenshots are assumed to be attached with the report.)*



# Pipeline Flow

- A single YAML file (`azure-pipelines.yml`) was used to handle both build and deploy stages.

**Pipeline Steps:**

1. **Checkout Code** – Pulls code from Azure Repos.
2. **Build** – Compiles the Spring Boot application and creates a `.jar` using Maven.
3. **Publish Artifact** – Uploads the `.jar` file as an artifact.
4. **Deploy to Azure App Service** – Uses the `AzureWebApp` task to deploy the `.jar` to the configured Azure Web App.

- Pipeline is triggered automatically on push to `main` branch.

- To avoid delays in execution due to free-tier limitations (parallelism restrictions), a **self-hosted agent** was used to reliably run the pipeline without waiting in the hosted queue.


# Azure Deployment and Limitations

**Deployment Target:** Azure App Service

**Issues faced:**

* H2 file-based DB did not work reliably on Azure; replaced with in-memory DB (`jdbc:h2:mem:testdb`).
* `PORT` binding required for Azure compatibility: `server.port=${PORT:8080}`.
* Memory limits on free App Service tier caused performance issues occasionally.
* Swagger UI sometimes failed to load due to port mismatches or app hanging silently.

**Fixes Applied:**

* Updated DB settings to in-memory.
* Verified app startup logs using Azure Log Stream.
* Ensured Swagger loads correctly by confirming proper deployment path and port usage.

# Conclusion and Suggestions

The project successfully demonstrates how to:

* Develop a secure Spring Boot app with JWT auth.
* Deploy using Azure DevOps CI/CD pipeline.
* Host the application on Azure App Service.

**Suggestions for improvement:**

* Use PostgreSQL or Azure SQL for persistent data.
* Implement logging/monitoring using Application Insights.
* Introduce separate staging and production pipelines.
* Add unit/integration test stages to the pipeline for robustness.

This setup lays a strong foundation for cloud-native application deployment using DevOps best practices.





