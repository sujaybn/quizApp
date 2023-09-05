# Springboot Microservices Practice - Quiz Application

## Introduction
This project is a practice exercise developed using the Spring Boot framework to create a simple Quiz application. Currently, it serves as a backend application.

## Tools Used
- JDK 17
- Spring Boot 3.1.3
- Maven
- Postman
- PostgreSQL

## Scope for Improvement
The project has the following areas for improvement:
1. Add code coverage configuration like Jacoco
2. Add Junit test cases
3. Implement DELETE functionality for questions.
4. Implement UPDATE functionality for questions.
5. Add validation and exception handling.
6. Read questions from a CSV file and populate the database.
7. Develop a front-end application for user interaction.
8. Implement CI/CD.
9. Deploy the web-application on GCP/AWS.

## Running the Application Locally
To run the application on your local machine, follow these steps:

1. Clone this project to your local machine.
2. Open the project in your preferred IDE (IntelliJ or Eclipse).
3. Ensure that Maven dependencies are resolved by running `mvn clean install`.
4. Install PgAdmin from [https://www.pgadmin.org/download/](https://www.pgadmin.org/download/).
5. Create a database named **questiondb** using PgAdmin.
    - You can use the UI to create the database `questiondb`.
    - Run the following SQL command to create the `question` table:

   ```sql
   CREATE TABLE "question" (
       "id" SERIAL PRIMARY KEY,
       "category" VARCHAR(25),
       "difficulty_level" VARCHAR(25),
       "option1" VARCHAR(255),
       "option2" VARCHAR(255),
       "option3" VARCHAR(255),
       "option4" VARCHAR(255),
       "question_title" VARCHAR(255),
       "correct_answer" VARCHAR(255)
   );
   ```
6. Run the `QuizappApplication`.
    - The server will run on `https://localhost:8080`.
    - Access all available questions at [http://localhost:8080/question/allQuestions](http://localhost:8080/question/allQuestions).
    - To perform CRUD operations, use Postman and send the following requests:
        1. **GET** `http://localhost:8080/question/allQuestions`
        2. **POST** `http://localhost:8080/question/add`
            - Payload example:
           ```json
           {
               "questionTitle": "This is one more test question for POST?",
               "option1": "op1",
               "option2": "op2",
               "option3": "op3",
               "option4": "op4",
               "correctAnswer": "op3",
               "difficultyLevel": "Easy",
               "category": "test"
           }
           ```
        3. **POST** `http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz`
        4. **GET** `http://localhost:8080/quiz/get/1`
        5. **POST** `http://localhost:8080/quiz/submit/1`
            - Payload example:
           ```json
           [
               {
                   "id": "25",
                   "response": "Option 3"
               },
               {
                   "id": "26",
                   "response": "Option 2"
               },
               {
                   "id": "27",
                   "response": "Option 3"
               },
               {
                   "id": "28",
                   "response": "Option 2"
               },
               {
                   "id": "30",
                   "response": "Option 1"
               }
           ]
           ```