# Quiz App Backend

A Spring Boot-based REST API for managing quizzes and questions with dynamic quiz generation capabilities.

## 🚀 Features

- **Question Management**: Create, read, update, and delete quiz questions
- **Dynamic Quiz Generation**: Generate quizzes based on category and difficulty parameters
- **Result Calculation**: Calculate and return quiz scores based on user responses
- **Category-based Filtering**: Filter questions by subject categories
- **RESTful API**: Clean and intuitive API endpoints

## 🛠️ Tech Stack

- **Backend Framework**: Spring Boot 3.5.3
- **Database**: PostgreSQL
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Java Version**: 17+
- **Additional Libraries**: 
  - Lombok (for reducing boilerplate code)
  - Spring Data JPA
  - PostgreSQL Driver

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 17 or higher installed
- PostgreSQL database server running
- Maven installed
- Git (for cloning the repository)

## ⚙️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/quiz-app-backend.git
   cd quiz-app-backend
   ```

2. **Create PostgreSQL Database**
   ```sql
   CREATE DATABASE questiondb;
   ```

3. **Configure Database Connection**
   
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Build and Run the Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## 📚 API Endpoints

### Question Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/question/allQuestions` | Get all questions |
| `POST` | `/question/add` | Add a new question |
| `PUT` | `/question/update/{id}` | Update an existing question |
| `DELETE` | `/question/delete/{id}` | Delete a question |
| `GET` | `/question/category/{category}` | Get questions by category |

### Quiz Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/quiz/create?category={category}&numQ={number}&title={title}` | Create a quiz with specific parameters |
| `GET` | `/quiz/{id}` | Get quiz questions |
| `POST` | `/quiz/submit/{id}` | Submit quiz responses and get results |

## 📝 Sample API Usage

### Adding a Question
```bash
POST /question/add
Content-Type: application/json

{
    "questionTitle": "What is Spring Boot?",
    "option1": "Framework",
    "option2": "Library",
    "option3": "Database",
    "option4": "Language",
    "rightAnswer": "Framework",
    "difficultyLevel": "Medium",
    "category": "Spring"
}
```

### Creating a Quiz
```bash
POST /quiz/create?category=Java&numQ=5&title=Java%20Basics%20Quiz
```

### Submitting Quiz Responses
```bash
POST /quiz/submit/1
Content-Type: application/json

[
    {
        "id": 1,
        "response": "Framework"
    },
    {
        "id": 2,
        "response": "JVM"
    }
]
```

## 🗄️ Database Schema

### Questions Table
- `id` (BIGINT, Primary Key, Auto-increment)
- `question_title` (VARCHAR)
- `option1` (VARCHAR)
- `option2` (VARCHAR)
- `option3` (VARCHAR)
- `option4` (VARCHAR)
- `right_answer` (VARCHAR)
- `difficulty_level` (VARCHAR)
- `category` (VARCHAR)

## 🔧 Configuration

### Application Properties
Key configuration options in `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080
```

## 🚦 Running Tests

```bash
mvn test
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/harshal/quizapp/
│   │   ├── controller/          # REST Controllers
│   │   ├── service/             # Business Logic
│   │   ├── dao/                 # Data Access Layer
│   │   ├── model/              # JPA Entities
│   │   └── QuizappApplication.java
│   └── resources/
│       └── application.properties
└── test/                        # Test files
```



## 🔮 Future Enhancements

- [ ] User authentication and authorization
- [ ] Quiz categories management
- [ ] Question difficulty levels
- [ ] Detailed analytics and reporting
- [ ] Quiz time limits
- [ ] Multiple quiz formats (true/false, fill-in-the-blank)
- [ ] Export quiz results to PDF/Excel

---

⭐ **If you found this project helpful, please give it a star!** ⭐
