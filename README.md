<h1 align="center">NeoContacts</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/rm1710/neocontacts?color=56BEB8">
  <img alt="Github language count" src="https://img.shields.io/github/languages/count/rm1710/neocontacts?color=56BEB8">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/rm1710/neocontacts?color=56BEB8">
  <img alt="License" src="https://img.shields.io/github/license/rm1710/neocontacts?color=56BEB8">
</p>

<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#memo-license">License</a>
</p>

<br>

## :dart: About ##

**NeoContacts** is a modern, full-featured **contact management application** built with **Spring Boot**.  
It allows users to securely **create, manage, and organize contacts**, supporting advanced features like **OAuth2 authentication**, **cloud-based image storage**, and **RESTful APIs**.

The project follows **clean architecture**, focuses on **security**, and is designed to be **scalable and production-ready**.

---

## :sparkles: Features ##

:heavy_check_mark: Create, read, update, and delete contacts  
:heavy_check_mark: Secure authentication using Spring Security & OAuth2  
:heavy_check_mark: Cloud-based image storage using Cloudinary  
:heavy_check_mark: RESTful API for contact management  
:heavy_check_mark: MySQL database with JPA & Hibernate  
:heavy_check_mark: Input validation and error handling  
:heavy_check_mark: Developer-friendly setup with Spring Boot DevTools  

---

## :rocket: Technologies ##

### Backend
- **Spring Boot 3.2.5**
- **Java 17**
- **Spring Data JPA**
- **Spring Security + OAuth2**
- **MySQL**
- **Maven**
- **Lombok**
- **Thymeleaf**

### Additional Tools
- Cloudinary (image management)
- Spring Boot Actuator
- Spring Validation

---

## :white_check_mark: Requirements ##

Before starting :checkered_flag:, ensure you have:

- Java **17+**
- Maven **3.6+**
- MySQL **8.0+**
- Git installed
- Cloudinary account (API key & secret)
- OAuth2 credentials (optional)

---

## :checkered_flag: Starting ##

```bash
# Clone the repository
git clone https://github.com/rm1710/neocontacts

# Navigate into the project
cd NeoContacts

# Create database
CREATE DATABASE neocontacts;

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
