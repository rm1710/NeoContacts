# NeoContacts

A modern, full-featured contact management application built with Spring Boot. NeoContacts provides an intuitive interface for organizing, managing, and sharing your contacts with powerful features like cloud-based image storage, OAuth2 authentication, and secure data management.

## Features

- **Contact Management**: Create, read, update, and delete contacts with detailed information
- **Cloud Image Storage**: Integrate with Cloudinary for reliable image hosting and management
- **Security**: Spring Security with OAuth2 support for secure authentication
- **Database**: MySQL integration with JPA for robust data persistence
- **Validation**: Built-in data validation to ensure data integrity
- **Development Tools**: Spring Boot DevTools for enhanced development experience
- **API**: RESTful endpoints for contact operations

## Tech Stack

### Backend
- **Framework**: Spring Boot 3.2.5
- **Language**: Java 17
- **Database**: MySQL with Spring Data JPA
- **Security**: Spring Security with OAuth2
- **Image Storage**: Cloudinary HTTP5 Client
- **Build Tool**: Maven
- **Additional**: Lombok for reducing boilerplate code

### Dependencies
- Spring Boot Actuator (monitoring and management endpoints)
- Spring Data JPA (database operations)
- Spring Web (REST endpoints)
- Spring Validation (input validation)
- Spring Security (authentication & authorization)
- OAuth2 Client (social login support)
- Thymeleaf (server-side templating)
- MySQL Connector (database driver)
- Cloudinary (image management)

## Prerequisites

Before running this project, make sure you have:

- **Java 17** or higher installed
- **Maven 3.6+** installed
- **MySQL 8.0+** server running
- **Cloudinary Account** for image storage (API key and secret)
- **OAuth2 Provider Credentials** (if using social login)

## Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd NeoContacts
```

### 2. Configure Application Properties
Create or update `application.properties` file with your configuration:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/neocontacts
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Cloudinary Configuration
cloudinary.api-key=your_cloudinary_api_key
cloudinary.api-secret=your_cloudinary_api_secret
cloudinary.cloud-name=your_cloudinary_cloud_name

# OAuth2 Configuration (if using)
spring.security.oauth2.client.registration.[provider].client-id=your_client_id
spring.security.oauth2.client.registration.[provider].client-secret=your_client_secret
```

### 3. Create Database
```bash
mysql -u root -p
CREATE DATABASE neocontacts;
```

### 4. Build the Project
```bash
mvn clean install
```

### 5. Run the Application
```bash
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

## Project Structure

```
NeoContacts/
├── src/
│   ├── main/
│   │   ├── java/com/example/neocontacts/
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── service/          # Business logic
│   │   │   ├── repository/       # Data access layer
│   │   │   ├── model/            # Entity classes
│   │   │   ├── security/         # Security configuration
│   │   │   └── config/           # Application configuration
│   │   └── resources/
│   │       ├── templates/        # Thymeleaf templates
│   │       └── static/           # Static resources (CSS, JS, images)
│   └── test/                     # Test files
├── pom.xml                       # Maven configuration
└── mvnw                          # Maven wrapper
```

## API Endpoints

### Contacts
- `GET /api/contacts` - Get all contacts
- `GET /api/contacts/{id}` - Get a specific contact
- `POST /api/contacts` - Create a new contact
- `PUT /api/contacts/{id}` - Update a contact
- `DELETE /api/contacts/{id}` - Delete a contact

## Authentication

NeoContacts supports multiple authentication methods:

1. **Form-Based Authentication**: Traditional username and password login
2. **OAuth2**: Integration with social providers (Google, GitHub, etc.)

All sensitive endpoints are protected by Spring Security.

## Image Management

Images are stored on Cloudinary. When uploading a contact photo:

1. Select an image file
2. The system uploads it to your Cloudinary account
3. A secure URL is stored in the database
4. The image is displayed in the contact details

## Development

### Enable Debug Logging
Add to `application.properties`:
```properties
logging.level.com.example.neocontacts=DEBUG
```

### Use Spring Boot DevTools
The project includes Spring Boot DevTools for automatic restart during development. Just run the application and changes to files will trigger a restart.

### Run Tests
```bash
mvn test
```

## Configuration Management

Key configuration files:
- `pom.xml` - Maven dependencies and build configuration
- `application.properties` - Spring Boot application properties
- Security configuration classes in the `security/` package

## Troubleshooting

### Database Connection Issues
- Ensure MySQL is running
- Verify credentials in `application.properties`
- Check that the database exists

### Image Upload Fails
- Verify Cloudinary API credentials
- Check internet connectivity
- Ensure Cloudinary account is active

### OAuth2 Issues
- Verify OAuth2 provider credentials are correct
- Check redirect URI configuration matches your provider settings
- Ensure callback URLs are properly configured

## Contributing

To contribute to NeoContacts:

1. Create a feature branch
2. Make your changes
3. Write or update tests
4. Submit a pull request with a clear description

## License

This project is licensed under the MIT License.

## Support

For issues, questions, or suggestions, please open an issue on the GitHub repository.

## Roadmap

Future features planned for NeoContacts:
- Contact groups and categories
- Advanced search and filtering
- Contact import/export (CSV, vCard)
- Mobile app version
- Contact sharing and collaboration
- Activity logging and audit trails
- Email integration
- Calendar integration

---

**Last Updated**: February 2026

Happy contact managing with NeoContacts!
