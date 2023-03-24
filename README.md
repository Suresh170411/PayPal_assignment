# Task Planner
Task Planner Spring Boot Application


![](https://github.com/Suresh170411/PayPal_assignment/blob/main/Images/Checklist.jpg)

## About
Task Planner application is able to perform all the CRUD based operation and can manage data to the database
hassle free.

## Features

- User record can be registerd to the database
- User can signIn using the registered credentials
- User can add tasks to the sprint
- User can see the percentage of the task complition
- User can update it's own credentials as well as the task



## Technologies and Dependencies Used
- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Security
- Devtools
- MySQL
- Lombok
- Maven



## API Root and Endpoint

- Register one user to the database
- Method : POST
```
http://localhost:8888/person/signUp
```
- SignIn the user using the valid credentials
- Method : GET
```
http://localhost:8888/signIn
```
- Post one task into the database
- Method : POST
```
http://localhost:8888/task
```
- Get the task using the taskId
- Method : GET
```
http://localhost:8888/task/{taskId}
```

- Get all the tasks
- Method : GET
```
http://localhost:8888/tasks
```

- Find the percentage of the task complition
- Method : GET
```
http://localhost:8888/task/data/percent
```
