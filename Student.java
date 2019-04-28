public class Student{
  private String name;
  private int studentID;

  public Student(int studentID, String name){
    this.name = name;
    this.studentID = studentID;
  }

  public String getName(){
    return this.name;
  }

  public int getStudentID(){
    return this.studentID;
  }
}
