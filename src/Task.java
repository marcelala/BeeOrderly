import java.util.HashMap;
import java.util.Date;


public class Task {
    private String name;
    private String project;
    private Date deadline;
	private boolean isDone;


   public String getName() {
       return name;
   }

   public void setName() {
       this.name = name;
    }

   public Date getDeadline(){
       return deadline;
   }
    public void setDeadline(Date deadline){
       this.deadline = deadline;
    }

    public String getProject(){
       return project;
    }
    public void setProject(String project){
       this.project = project;

    }

    public boolean isDone() {
       return isDone;
    }
    public void setDone(boolean isDone){
       this.isDone =isDone;
    }


}
