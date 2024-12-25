<p align="center">
  <img src="Logo/to-do-list.png" alt="Logo" width="150" />
</p>

# Simple To-Do List

To build a simple To-Do List with functionality for creating, updating, and deleting tasks, here's a high-level overview of the steps:

**Here's what it does:**

* **Create Task:** Add a new task to the list.
* **Update Task:** Edit the details of an existing task.
* **Delete Task:** Remove a task from the list.

## Tech Stack

* **Backend:** Spring Boot, PostgreSQL and Swagger

## Run Locally

- Clone the project

```bash
   git clone https://github.com/makarandhinge/TodoManagement.git
```

- Go to the backend project directory

```bash
  cd backend
```

- Ensure that Java is installed on your system. You can verify this by running the following command

```bash
  java -version
```

- If java is not installed, you can follow the installation instructions from [here](https://github.com/makarandhinge/Installtion-Guideline/blob/main/Java.md)

- Configure the Backend

```bash

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/<database_name>
spring.datasource.username=<db_username>
spring.datasource.password=<db_password>

```

- Build the project

```bash
  ./mvnw clean install
```

- Run the Spring Boot application

```bash
  ./mvnw spring-boot:run
```

The backend should now be running on http://localhost:8080.
