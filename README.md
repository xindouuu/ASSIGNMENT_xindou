#  ASSIGNMENT_xindou

This README provides an overview of the SpringBoot project, including design decisions, technologies used, and instructions for setting up and running the project.


# Project Overview

The project is a SpringBoot application that provides CRUD (Create, Read, Update, Delete) functionality for managing client information and cases.
It includes two main entities: Client and Request (representing cases).
Clients can be added, updated, deleted, and retrieved, while cases can be created, retrieved by client ID, and filtered by status or staff assigned.

## Technologies Used

SpringBoot , MyBatis-Plus , MySQL

## Switch to another file

All your files and folders are presented as a tree in the file explorer. You can switch from one to another by clicking a file in the tree.

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
