# Springboot microservices practice
### Introduction:
 This is a practice project that is developed using Springoot framework to create a simple Quiz application. At this point, it is only a backend application.
### Tools used:
1. JDK 17
2. Springboot 3.1.3
3. Maven
4. Postman
5. PostgreSql 

### Scope for imporovement:
1. DELETE questions 
2. UPDATE questions 
3. Add validations and exception handling 
4. Read the questions DB from a CSV file and add to DB
4. Develop a front end application

### To run the application on your local, Kindly follow the below steps:
1. Clone this project to your local
2. Open the project in your IDE (IntelliJ or Eclipse)
3. Ensure that the maven dependencies are resolved and do a ```mvn clean install```
4. Install PgAdmin from https://www.pgadmin.org/download/
5. Ensure that you create a database under in PgAdmin. You can use UI to create the DB with the name **questiondb**.
   1.  Run this command to create the _question_ table:                                                                                                                      
    ```CREATE TABLE "question" ("id" SERIAL PRIMARY KEY,
    "category" VARCHAR(25),
    "difficulty_level" VARCHAR(25),
    "option1" VARCHAR(255),
    "option2" VARCHAR(255),
    "option3" VARCHAR(255),
    "option4" VARCHAR(255),
    "question_title" VARCHAR(255),
    "correct_answer" VARCHAR(255)
    );```
6. Run the QuizappApplication 
   1. The server will run on https://localhost:8080
   2. Open your browser and run the below url to get all the available questions on http://localhost:8080/question/allQuestions
   3. To run the CRUD operations, use postman to run the below payload 
      1. **GET** http://localhost:8080/question/allQuestions
      2. **POST** http://localhost:8080/question/add
   Payload:
       ***{
          "questionTitle": "This is one more test question for POST?",
          "option1": "op1",
          "option2": "op2",
          "option3": "op3",
          "option4": "op4",
          "correctAnswer": "op3",
          "difficultyLevel": "Easy",
          "category": "test"
          }***
       3. **POST** http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz
       4. **GET** http://localhost:8080/quiz/get/1
       5. **POST** http://localhost:8080/quiz/submit/1
     
Payload: ***[
       {
       "id":"25",
       "response":"Option 3"
       },
       {
       "id":"26",
       "response":"Option 2"
       },
       {
       "id":"27",
       "response":"Option 3"
       },
       {
       "id":"28",
       "response":"Option 2"
       },
       {
       "id":"30",
       "response":"Option 1"
       }
]***