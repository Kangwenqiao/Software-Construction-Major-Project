
```markdown
# EquationApplication

**Author:** 202107927wqKang
**Contact:** wenqiaokang@outlook.com
**University:** NCWU (North China University of Water Resources and Electric Power)
**Location:** Zhengzhou, Henan, China

## Overview

The EquationApplication is a JavaFX application designed to generate arithmetic questions for users and facilitate interactive learning. It features a graphical user interface with menus, buttons, and charts, allowing users to generate, save, load, and check arithmetic questions.

## Features

- **Generate Questions:** Dynamically creates a set of arithmetic questions.
- **Save Questions:** Stores generated questions in a MySQL database.
- **Load Questions:** Retrieves and displays questions from the database.
- **Check Questions:** Allows users to check their answers and provides an accuracy report.

## Prerequisites

Before running the EquationApplication, ensure the following:

- Java Development Kit (JDK) is installed.
- MySQL database is set up, and the necessary tables exist.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/EquationApplication.git
   cd EquationApplication
   ```

2. **Compile and Run:**
   ```bash
   javac EquationApplication.java
   java EquationApplication
   ```

3. **Configure Database:**
   - Ensure that MySQL is running.
   - Modify MySQL connection details in `MySQLUtil.java`.

4. **Use the Application:**
   - Follow the on-screen instructions to generate, save, load, and check arithmetic questions.

## Database Configuration

Modify the MySQL connection details in the `MySQLUtil.java` file to match your database configuration.

```java
// MySQLUtil.java

private static final String JDBC_URL = "jdbc:mysql://your-database-host:3306/your-database-name";
private static final String USERNAME = "your-username";
private static final String PASSWORD = "your-password";
```

## Dependencies

The application uses JavaFX for the graphical user interface. Ensure that JavaFX libraries are included in your project.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any inquiries or issues, please contact the author:

- **Name:** 202107927wqKang
- **Email:** wenqiaokang@outlook.com

Feel free to reach out with feedback or suggestions!

```

Make sure to replace placeholders like `your-username`, `your-database-host`, `your-database-name`, `your-username`, and `your-password` with your actual information. Additionally, include any additional sections or information that you find relevant for users of your application.
