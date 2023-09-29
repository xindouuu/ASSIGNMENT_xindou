#  ASSIGNMENT_xindou

This README provides an overview of the SpringBoot project, including design decisions, technologies used, and instructions for setting up and running the project.


# Project Overview

The project is a SpringBoot application that provides CRUD (Create, Read, Update, Delete) functionality for managing client information and cases.
It includes two main entities: Client and Request (representing cases).
Clients can be added, updated, deleted, and retrieved, while cases can be created, retrieved by client ID, and filtered by status or staff assigned.

## Technologies Used

SpringBoot , MyBatis-Plus , MySQL


## Design Decisions

1. Database Schema: The project uses a MySQL database with two main tables: Client and Request. The detailed schema design please refer to springboot_jxd.sql  

2. Entity Mapping: Entity classes (Client and Request) are annotated with MyBatis-Plus annotations for easy database mapping and operations.   

3. Three-Tier Architecture：Mapper -> Service -> Controller. Three Layer Structure are created for managing clients and cases to maintain code modularity and organization.   
 
4. Result Class: A custom Result class is used to standardize JSON responses from API endpoints.

## Project Structure

-   `com.jxd.bean`: Entity classes (`Client` and `Request`).
-   `com.jxd.controller`: Controllers for client and case management.
-   `com.jxd.mapper`: MyBatis mappers for database operations.
-   `com.jxd.service`: Service interfaces and implementations.
-   `com.jxd.util`: Custom `Result` class for JSON responses.
-   `com.jxd.Application`: Main application class.

##  Setup Instructions

1. **Clone the Repository**: 
`git clone https://github.com/xindouuu/ASSIGNMENT_xindou.git`

2. **Database Configuration**:
-   Create a MySQL database according to springboot_jxd.sql 
-   Update the database credentials in the `application.yml` file.

3. **Build and Run** : The application will start and run on `http://localhost:9090`.

# API Documentation

This documentation provides an overview of the APIs available in this application for managing clients and requests. These APIs allow you to perform CRUD (Create, Read, Update, Delete) operations on client and request data.

## Table of Contents

1.  Client APIs
    -   Add Client
    -   Delete Client
    -   Retrieve Client by ID
    -   Retrieve All Clients
    -   Update Client
2.  Request APIs
    -   Create Case
    -   Retrieve Cases by Client ID
    -   Retrieve Completed Cases
    -   Retrieve Outstanding Cases
    -   Retrieve Cases by Staff Name
    -   Update Case

## Client APIs

### Add Client

-   **Endpoint:** `POST /saveClient`
-   **Description:** Add a new client to the system.
-   **Request Body:**
    -   JSON object representing the client.
-   **Response:**
    -   HTTP status code indicating success or failure.

### Delete Client

-   **Endpoint:** `DELETE /del/{id}`
-   **Description:** Delete a client by their ID.
-   **Path Parameter:**
    -   `id` - The ID of the client to be deleted.
-   **Response:**
    -   HTTP status code indicating success or failure.

### Retrieve Client by ID

-   **Endpoint:** `GET /getClientByID/{id}`
-   **Description:** Retrieve a client by their ID.
-   **Path Parameter:**
    -   `id` - The ID of the client to be retrieved.
-   **Response:**
    -   JSON object representing the retrieved client.

### Retrieve All Clients

-   **Endpoint:** `GET /listClients`
-   **Description:** Retrieve a list of all clients.
-   **Response:**
    -   JSON array containing client objects.

### Update Client

-   **Endpoint:** `PUT /updateClient`
-   **Description:** Update an existing client's information.
-   **Request Body:**
    -   JSON object representing the updated client information.
-   **Response:**
    -   HTTP status code indicating success or failure.

## Request (Case) APIs

### Create Case

-   **Endpoint:** `POST /saveCase`
-   **Description:** Create a new case (request) in the system.
-   **Request Body:**
    -   JSON object representing the case (request).
-   **Response:**
    -   HTTP status code indicating success or failure.

### Retrieve Cases by Client ID

-   **Endpoint:** `GET /getCasesByClientId/{id}`
-   **Description:** Retrieve a list of cases (requests) raised by a specific client.
-   **Path Parameter:**
    -   `id` - The ID of the client for whom cases are retrieved.
-   **Response:**
    -   JSON array containing case (request) objects.

### Retrieve Completed Cases

-   **Endpoint:** `GET /getCompletedCases`
-   **Description:** Retrieve a list of all completed cases.
-   **Response:**
    -   JSON array containing case (request) objects.

### Retrieve Outstanding Cases

-   **Endpoint:** `GET /getOutstandingCases`
-   **Description:** Retrieve a list of outstanding cases (cases in progress).
-   **Response:**
    -   JSON array containing case (request) objects.

### Retrieve Cases by Staff Name

-   **Endpoint:** `GET /getCasesbyStaffName`
-   **Description:** Retrieve a list of cases handled by a specific staff member.
-   **Query Parameter:**
    -   `name` - The name of the staff member.
-   **Response:**
    -   JSON array containing case (request) objects.

### Update Case

-   **Endpoint:** `PUT /updateCases`
-   **Description:** Update an existing case (request).
-   **Request Body:**
    -   JSON object representing the updated case (request) information.
-   **Response:**
    -   HTTP status code indicating success or failure.
