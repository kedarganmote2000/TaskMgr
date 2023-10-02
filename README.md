## Task Manager

The Task Manager is a web-based application designed to help individuals and teams efficiently manage and organize their tasks, to-do lists, and projects. It provides a user-friendly interface to create, edit, categorize, and track tasks, allowing users to stay organized and increase productivity.

## Table of Contents

 1.Project Overview
 2.Getting Started
  - Prerequisites
  - Installation
 3.Usage
  - Project Structure
 4.Endpoints/APIs
  - API Documentation

## Project Overview

Key Features
The Task Manager offers a range of features to enhance task management:
1.Task Creation and Editing: Users can create, edit, and delete tasks. Each task can include a title, due date, Status.
2.Task Status Tracking: Users can mark tasks as completed, in-progress, or pending.
3.Task View: Users can view there task.

Technology Stack
1.Frontend: The frontend of the Task Manager is built using HTML, CSS, and JavaScript. It utilizes a modern JavaScript framework like React for a dynamic user interface.

2.Backend: The backend is developed using a server-side language Java and Framwork SpringBoot. It communicates with the database, manages user authentication, and handles API requests.

3.Database: The project uses a relational MySQL to store user data, tasks, and task lists.

Project Goals
The primary goals of the Task Manager project are:

1.Provide a user-friendly and efficient task management solution for individuals and teams.
2.Enhance productivity by helping users prioritize and organize their tasks effectively.


## Getting Started

To get started with a Task Manager project, you'll need to set up the development environment, install the necessary dependencies, and begin building the application. Here's a basic outline of the steps to get started:


### Prerequisites

Before you start a Task Manager, make sure you have the following prerequisites in place:

1.Development Environment: Set up a development environment on your local machine. You'll need a code editor (e.g., Visual Studio Code and STS), package manager (npm).

2.Database: Choose and set up a database system to store user data, tasks, and task lists. Common choices include MySQL.

3.Frontend Framework: Select a frontend framework or library (e.g. React) for building the user interface.

4.Backend Framework: Select a backend framework or platform (e.g. SpringBoot) to run the server-side logic.

### Installation

Follow these steps to set up the development environment and get your Task Manager project started:

1.Clone the Project Repository:
git clone https://github.com/kedarganmote2000/taskMgr.git

2.Install Frontend Dependencies:
If you're using a frontend framework like React, navigate to the frontend directory and install the dependencies:
- npm i axios
- npm i bootstrap
- npm i react-router-dom

3.Install Backend Dependencies:

Navigate to the backend directory (or root directory if you don't have a separate backend) and install the backend dependencies:
- MySQL
- SpringBoot
- Spring Web
- SpringData JPA
- ModelMapper

4.Database Setup:
Setup a ID and Password of MySQL in application.properties file of SpringBoot.

5.Start the Application:
Run the frontend and backend servers. You may need to run separate commands for each servers.
- For the frontend (e.g., using React):
  npm start
- For the backend(e.g springBoot):
  run the folder as springBoot app

6.Access the Application:

Open your web browser and navigate to the URL where your application is hosted (typically http://localhost:3000 for the frontend and http://localhost:8000 for the backend if using default ports).

## Usage

1.Project Structure:
task-manager/
  ├── frontend/
  │    ├── src/
  |        ├──Layout
  |           ├──Navbar.js
  |        ├──Pages
  |           ├──Home.js
  |        ├──Users
  |           ├──AddTask.js
  |           ├──EditTask.js
  |           ├──ViewTask.js
  │    ├── public/
  |    ├── App.js
  │    ├── package.json
  |    ├──package-lock.json

  
  ├── backend/
  │    ├── Exception/
  |        ├── TaskNotFoundAdvice
  |        ├── TaskNotFoundException
  │    ├── controllers/
  |        ├── TaskController
  │    ├── Entity/
  |        ├── BaseEntity
  |        ├── Task
  │    ├── Repo/
  |        ├── TaskRepo
  │    ├── Application.java
  |    ├── pom.xml


  ## EndPoints/API


Creating endpoints/APIs for a Task Manager involves defining routes that allow users to interact with tasks, lists, and other functionalities. Here's a list of common endpoints/APIs for a Task Manager application:

- API Documentation

Create a Task
URL: /task
Method: POST
Description: Create a new task.
Request Body: Task details (e.g., title, description, due date, priority).
Response: The created task.

Get All Tasks
URL: taskdetails
Method: GET
Description: Get a list of all tasks.
Response: A list of tasks.

Get Task by ID
URL: /tasks/{id}
Method: GET
Description: Get a specific task by its ID.
Response: The task with the specified ID.

Update a Task
URL: /tasks/{id}
Method: PUT
Description: Update an existing task.
Request Body: Updated task details.
Response: The updated task.

Delete a Task
URL: /tasks/{id}
Method: DELETE
Description: Delete a task by its ID.
Response: A success message.
