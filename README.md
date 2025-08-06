# Phishing Simulator

This is a Java Spring Boot project for simulating email phishing campaigns. It uses Spring Web, Spring Data JPA, Thymeleaf, H2 Database, and Java Mail Sender.

## Getting Started

- Build: `./mvnw clean install`
- Run: `./mvnw spring-boot:run`

## Project Structure
- `src/main/java/com/hackathon/phishing_simulator/` - Application code
- `src/main/resources/templates/` - Thymeleaf templates
- `src/main/resources/static/` - Static resources

## Features
- Simulate phishing campaigns
- Store campaign data in H2 database
- Send emails using Java Mail Sender

## Development
- Uses H2 in-memory database for easy setup
- Modify `application.properties` for custom configuration

# Phishing Campaign Simulator

## System Flow Diagram

```
+-----------------------+
|        Start          |
+-----------------------+
          |
          v
+-----------------------+
|   Campaign Creation    |
+-----------------------+
          |
          |---------------------+
          |                     |
          v                     v
+-----------------------+ +-----------------------+
|  AI-Powered Email     | |  AI-Powered Landing    |
|      Templates        | |        Pages           |
+-----------------------+ +-----------------------+
          |                     |
          |                     |
          +---------------------+
          |
          v
+-----------------------+
|     User Interaction    |
+-----------------------+
          |
          v
+-----------------------+
|     Data Collection    |
+-----------------------+
          |
          v
+-----------------------+
|    AI-Powered Report   |
|      Generation        |
+-----------------------+
          |
          v
+-----------------------+
|     Feedback Loop      |
+-----------------------+
          |
          v
+-----------------------+
|         End           |
+-----------------------+
```

## Overview
This project is a Java Spring Boot phishing campaign simulator. It supports campaign creation, AI-powered email and landing page generation, user interaction tracking, data collection, and automated reporting with feedback loop.

## Features
- Campaign management
- Email template and landing page CRUD
- Live HTML editing and preview
- REST API backend
- User and group management
- Reporting and analytics

## Getting Started
1. Clone the repository
2. Build and run with Maven
3. Access the UI at `http://localhost:8080`

## License
MIT

---
For more details, see the code and documentation.
