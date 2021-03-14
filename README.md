![BeeOrderly](images/Be%20Orderly.gif)

# **Bee Orderly**

A simple command line JAVA program to create and manage tasks.

## Features

####Models a task with:
- task name
- deadline
- completion status
- project (if any)

####Displays a collection of tasks that can be sorted
- by deadline
- by project

####Supports the ability to
- add a new task
- edit a preexisting task
- mark a task as done
- remove a task


## Built with

- JDK 15.0.2
- JUnit 5.7.1
- Gradle 6.8.3
- Git 2.24.3


## **Getting Sarted**

To run this application clone this repository open terminal and paste this command:
```bash
git clone https://github.com/marcelala/java-to-do-list``
```
On terminal change directory to the cloned local repository.  This application can be run directly via Gradle or via a generated jar file.

### Run with Gradle
In the root folder, start the application with the following command:

```bash ./gradlew run --console=plain``` for Linux/macOS

```bash ./gradlew.bat run -console=plain``` for Windows

## Run with jar file
Generate the jar file with Gradle's build command.
```bash
gradle build
```
The jar file will be generated in `build/libs` which can be run by a Java environment.
```bash
java -jar apps/build/libs/app.jar
```
Running using `gradle build` or `java -jar app.jar` will not allow saving/loading from file, and text format may appear
differently.

To see other functions available with Gradle, execute 
   `./gradlew` on Linux/macOS and `./gradlew.bat` in the cloned local repository


## **Using the application**


1. The main menu will give you 4 choices: 



##Authors and acknowledgments

