package main.java.BeeOrderly;


import java.time.LocalDate;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;



public class Task implements Serializable{
    // holds the name of a task and it cannot be empty
    private String name;
    // holds the name of project associated with task, it could be an empty string.
    private String project;
    // The due date of the task as yyyy-mm-dd format
    private LocalDate deadline;
    //if true task is completed
	private boolean isDone;

    public Task(String name, String project, LocalDate deadline) {

        this.name = name;
        this.project = project;
        this.isDone = false;
        this.deadline = deadline;

    }

    //returns the task name
   public String getName() {
       return this.name;
   }

    //sets the name of a task
   public void setName(String name) throws NullPointerException {
       if (name.trim().equals("") || name == null) {
           throw new NullPointerException("REQUIRED: Task name can not be empty.");
       }
       this.name = name.trim();
    }

    //get deadline
   public LocalDate getDeadline(){

       return deadline;
   }

   // edit a deadline
    public void setDeadline(LocalDate deadline)throws DateTimeException {
        // Throws DateTimeException if past date is given
        if (deadline.compareTo(LocalDate.now())<0) {
            throw new DateTimeException("Past Date not allowed");
        }
        //Ensure format is yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.deadline = LocalDate.parse(deadline.format(formattedDate));
    }

    // gets project name
    public String getProject(){

       return this.project;
    }

    //sets the name of a project
    public void setProject(String project){
       this.project = project.trim();

    }
    // is the task done?
    public boolean isDone() {

       return this.isDone;
    }

    //marks a task as completed
    public void setDone(){
       this.isDone = true;
    }
    //marks a task as incomplete
    public void setNotDone(){
        this.isDone = false;
    }
    /* Gets the task data as formatted string
     * @return formatted string of all fields of a task
    */
    public String formattedStringOfTask() {
        return (
                "\nTask     : " + name +
                        "\nProject   : " + project +
                        "\nStatus    : " + (isDone?"Done":"Not done") +
                        "\nDeadline  : " + deadline +
                        "\n");
    }


}
