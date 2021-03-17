![BeeOrderly](images/Be%20Orderly.gif)

# **Bee Orderly**

A simple command line JAVA application to create and manage tasks in to-do lists.

## Built with

- JDK 15.0.2
- JUnit 5.7.1
- Gradle 6.8.3
- Git 2.24.3


## **Getting Started**

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


###Main menu 
The main menu will offer the user 4 options to choose from.
![Main menu](images/screens/Bee%20Orderly%20Main%20Menu.png)

### View task list
Option 1: allows viewing of the task list sorted by project or by deadline respectively.

![sorted by project](images/screens/option%201%20view%20tasks%20by%20project.png)


![sorted by deadline](images/screens/option%201%20view%20tasks%20by%20deadline.png)


### Add tasks
Option 2: allows the user to add new tasks to the list by entering a task name, task project and deadline.


![add task](images/screens/option%202%20add%20a%20new%20task.png)


### Edit tasks
Option 3: after choosing it the user will view the tasklist in order to select the task to be edited. 

![select a task](images/screens/option%203%20tasks%20are%20displayed%20for%20selection.png)

After slection the user will view a submenu which allows users to choose to edit tasks, mark tasks as done or delete tasks.

![edit a task](images/screens/option%203%20submenu%20task%20edit%20options.png)


### Save and quit task list
Option 4: saves the current task list to file and quits the application. At restart of the application the saved tasks will be loaded.

![save and quit](images/screens/option%204%20save%20and%20quit.png)


##Authors and acknowledgments
Author: Marcela Felix Fortis
Special thanks to all the TAs and other students for all the support.
