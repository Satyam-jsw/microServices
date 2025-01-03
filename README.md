# Microservices Architecture
This repository demonstrates a comprehensive microservices-based architecture, showcasing the creation, integration, and communication of multiple services.

1) hotelService Manages:- hotel-related data, Integrated with a PostgreSQL database.
2) userService :- Handles user registration and user data, Integrated with a MySQL database.
3) ratingService:- Manages ratings provided by users for hotels. Integrated with a MongoDB database.
4) apiGateway:- Acts as a gateway to route requests to the appropriate microservices.
5) configServer:- Centralized configuration management for all services.
6) serviceRegistry:- Implements Eureka Server for registering and discovering microservices.

## Features and Implementation
Microservices Creation
Full implementation of Hotel and Rating microservices.
Service Registry and Discovery
Service Registry Server implemented with Eureka.
Service Discovery Client added to User, Hotel, and Rating services for dynamic communication.
## API Communication
Microservices communicate seamlessly via APIs.
Simplified communication by removing the need for hardcoded host and port values.
User Service interacts with Hotel Service for hotel-related operations.
Feign Client Integration
Implemented Feign Client for streamlined communication between User and Hotel services.
## API Gateway
Set up API Gateway for routing requests to appropriate services.
Configured multiple URLs for routing via API Gateway.
## Configuration Management
Centralized configuration using Config Server.
Implemented Cloud Config Client for dynamic property management.
## Resilience and Fault Tolerance
Integrated Circuit Breaker using Resilience4J for fault tolerance.
Added Retry mechanism for handling transient failures.
Implemented Rate Limiter to control traffic using Resilience4J.
## Technologies and Tools
Backend Frameworks: Spring Boot, Spring Cloud.
Databases: MySQL, PostgreSQL, MongoDB.
Communication Tools: REST API, Feign Client, Eureka Server.
Fault Tolerance: Resilience4J (Circuit Breaker, Retry, Rate Limiter).


## Getting Started
1. Clone the repository.
2. Configure the databases (MySQL, PostgreSQL, MongoDB) as required.
3. Run the services in the following order:
4. Config Server
5. Service Registry
6. Other Microservices (userService, hotelService, ratingService)
7. API Gateway
Test the inter-service communication and API calls using Postman.

