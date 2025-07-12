# 🧠 Quiz Management API

A Spring Boot-based REST API for managing quizzes, retrieving questions, and evaluating answers.

## 📌 Features

1 Create quizzes by category and difficulty
2 Fetch quiz questions for users (excluding correct answers)
3 Submit answers and calculate the score
4 CRUD operations on quiz questions
5 Uses PostgreSQL for persistent storage

📘 Question Module Endpoints
These endpoints allow you to manage the quiz questions.
| Method   | Endpoint                        | Description                                |
| -------- | ------------------------------- | ------------------------------------------ |
| `GET`    | `/question/allquestion`         | Fetch all questions from the database      |
| `GET`    | `/question/category/{category}` | Fetch all questions of a specific category |
| `POST`   | `/question/add`                 | Add a new question to the database         |
| `PUT`    | `/question/update/{id}`         | Update a question with given ID            |
| `DELETE` | `/question/delete/{id}`         | Delete a question with given ID            |

🧠 Quiz Module Endpoints
These endpoints manage the lifecycle of a quiz and user responses.
| Method | Endpoint                                                       | Description                                                      |
| ------ | -------------------------------------------------------------- | ---------------------------------------------------------------- |
| `POST` | `/quiz/create?category={category}&numQ={number}&title={title}` | Create a quiz using random questions of a given category         |
| `GET`  | `/quiz/get/{id}`                                               | Get quiz questions by quiz ID (only options, no correct answers) |
| `POST` | `/quiz/submit/{id}`                                            | Submit quiz responses and get score                              |

🔧 Developer Notes
Lombok's @Data annotation was initially used to generate boilerplate code like getters and setters.
However, due to configuration issues during development, manual getter and setter methods were added instead.
If Lombok is properly configured in your environment, feel free to remove the explicit getters/setters and use @Data , @RequiredArgsConstructor and @Getter/@Setter.



**Bilal Shaikh**  
Backend Developer  
