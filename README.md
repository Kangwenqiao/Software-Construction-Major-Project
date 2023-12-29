# Equation Application

**Author:** 202107927wqKang  
**Contact:** wenqiaokang@outlook.com  
**University:** NCWU (North China University of Water Resources and Electric Power)  
**Location:** Zhengzhou, Henan, China

## Overview

Equation Application is a JavaFX program that generates arithmetic questions for users with an interactive user interface. It allows users to generate, save, load, and check arithmetic questions.

## Features

- **Generate Questions:** Generates a set of arithmetic questions.
- **Save Questions:** Stores questions in a MySQL database.
- **Load Questions:** Retrieves and displays questions from the database.
- **Check Questions:** Allows users to check their answers and provides an accuracy report.

## Prerequisites

- Java Development Kit (JDK) is installed.
- MySQL database is set up, and the necessary tables exist.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/Equation-Application.git
   cd Equation-Application
   ```

2. **Compile and Run:**
   ```bash
   javac EquationApplication.java
   java EquationApplication
   ```

3. **Configure Database:**
   - Ensure MySQL is running.
   - Modify MySQL connection details in `MySQLUtil.java`.

4. **Use the Application:**
   - Follow on-screen instructions to generate, save, load, and check arithmetic questions.

## Database Configuration

Modify MySQL connection details in `MySQLUtil.java` to match your database configuration.

```java
// MySQLUtil.java

private static final String JDBC_URL = "jdbc:mysql://your-database-host:3306/your-database-name";
private static final String USERNAME = "your-username";
private static final String PASSWORD = "your-password";
```

## Dependencies

The application uses JavaFX for the graphical user interface.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

- **Name:** 202107927wqKang
- **Email:** wenqiaokang@outlook.com

For inquiries or issues, please feel free to contact the author.
