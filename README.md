# <span style="color:Green">NewsPortal</span>
#### <span style="color:white">by Charles Muvaka</span>

NewsPortal is an Api that enables users to add and retrieve information concerning the employees, department and News relating to the entire organisation and departments.

To use the postgres database run the create.sql script in the `src/create.sql` folder in the project directory
or run the following:

````sql
CREATE DATABASE news_portal;
\c news_portal

CREATE TABLE workers(
id serial PRIMARY KEY,
workername VARCHAR,
workerposition VARCHAR,
departmentid INTEGER
);

CREATE TABLE departments(
id serial PRIMARY KEY,
name VARCHAR,
description VARCHAR
);

CREATE TABLE news(
id serial PRIMARY KEY,
topic VARCHAR,
description VARCHAR,
departmentid INTEGER
);
````
Note the database name is `news_portal` if using the postgres database

## <span style="color:Greenyellow"> Prerequisites</span>

- Basic knowledge of On Git CLI
- Java 11
- Gradle as a built tool
- IntelliJ or any Java based IDE
- postgres SQL sever installed
- Postman desktop client installed

## <span style="color:Green">Technologies</span>

- Java 11
- Gradle
- Spark
- JUnit
- Postgres Sql

## <span style="color:Green">Installation</span>

1. Clone or download repository as an archive
2. If archive unzip the archive to get project folder
3. Open the application's root folder in an IDE that can execute builds in java using gradle e.g. IntelliJ or Eclipse.
4. Navigate to the Main.java file and run the `main` class
5. Use the link below to access the labeled request collection in Postman web,fork the collection into your personal workspace.
- "https://www.postman.com/dark-rocket-354200/workspace/team-workspace/collection/20876568-ce40f82f-3c9a-492d-a71e-119eed23c031?action=share&creator=20876568"
6. For testing use Postman desktop client to access the forked collection because their cloud client does not access
   local ports like `localhost:4567`.
7. In postman replace where indicated `:id` the number with the id you want to use in the path variables
8. Make sure you recreate the database in your local psql by running the psql commands above.
9. If you do not fork the already created postman collection make sure to enter and label yours correctly to avoid errors because of extra spaces or missing characters


## Some sample endpoint responses using the Articles and Staff Objects

#### Add a Department

- Entry

```json
{
  "name": "Payments",
  "description": "Facilitates monetary services"
}
```

Response

```json
{
   "id": 1,
   "name": "Payments",
   "description": "Facilitates monetary services"
}
```

#### Add News to a department

- Entry

```json
{
    "topic": "Employee Reduction",
    "description": "Department has decided to reduce the number of it employess",
    "departmentId": 1
  }
```

- Response if department with id does not exist

```json
{
    "errorMessage": "No department with the id exists",
    "status": 404
}
```

- Response if department exists

```json
{
    "id": 1,
    "topic": "Employee Reduction",
    "description": "Department has decided to reduce the number of it employess",
   "departmentId": 1
}
```

#### Get all departments

- Response

```json
[{
   "id": 1,
   "name": "Payments",
   "description": "Facilitates monetary services"
}
]
```

### Get by department by id
- If department with id:3 doesn't exist
```json
{
   "errorMessage": "No department with the id: \"3\" exists",
   "status": 404
}
```
- If department with id:1 exists
```json
{
   "id": 1,
   "name": "Payments",
   "description": "Facilitates monetary services"
}
```

## <span style="color:green">Sample response to show one-to-many relationship to the Department table</span>

### If the department does not exist

- News retrieval error

```json
{
   "errorMessage": "No department with the id: \"3\" exists",
   "status": 404
}
```

- Workers in a department retrieval error

```json
{
   "errorMessage": "No department with the id: \"3\" exists",
   "status": 404
}
```

### If the department exists

- But with no News assigned

```json
{
   "message": "Apologies, there are no available news for this department."
}
```

- With Worker assigned

```json
[
   {
      "departmentId": 1,
      "workerName": "Charles Muvaka",
      "workerPosition" : "Payment Officer"
   }
]
```
 - Department with news assigned
 - 
```json
[
   {
      "id": 1,
      "departmentId": 1,
      "topic": "Employees Reduction",
      "description": "The department has decided to reduce its employees due to the ongoing pandemic"
   }
]
```
#### NOTE: Not all individual response behaviors are covered by the samples but all response types are covered by the samples to provide a correct idea of what responses will look like endpoints are hit

## <span style="color:Green">To Contribute or Fix bug

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -m 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request

## <span style="color:Green">BUGS FOUND</span>

If you come across any bug in the project kindly report using the link below

#### [Link 🔗 ](https://github.com/CharlesMuvaka/newsPortal/issues/new)

## Licence

### MIT License

>
MIT License

Copyright (c) 2022 Charles Muvaka

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE

## <span style="color:green">Support and contact details</span>

> > EMAIL: muvakacharles@gmail.com
