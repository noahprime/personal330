// ssh -p 922 -L 3306:mysql.cs.wwu.edu:3306 primen@linux.cs.wwu.edu
// javac -cp ".:mysql-connector-java-8.0.15.jar" *.java
// java -cp ".:mysql-connector-java-8.0.15.jar" Main 'primen' 'K0H7#hL(+3U'

import java.sql.*;
import java.util.ArrayList;

public class JdbcDatabase{
  private String userID;
  private String password;
  private final String preConnectionString = "jdbc:mysql://mysql.cs.wwu.edu:3306/";
  private final String postConnectionString = "?useSSl=false";
  private String connectionString;
  private ArrayList<Student> students = new ArrayList<Student>();

  public JdbcDatabase(String userID, String password){
    this.userID = userID;
    this.password = password;
    this.connectionString = preConnectionString + userID + postConnectionString;
  }

  public void run(){
    try{
      Connection connection = getConnection();
      if(connection != null){
        Statement query = connection.createStatement();
        ResultSet result = query.executeQuery("SELECT * FROM student");

        while(result.next()){
          System.out.println(result.getInt(1) + " " + result.getString(2));
          Student s = new Student(result.getInt(1), result.getString(2));
          this.student.add(s);
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  private Connection getConnection(){
    try{
      return DriverManager.getConnection(this.connectionString,this.userID,this.password);
    }catch(SQLException sqle){
      sqle.printStackTrace();
      return null;
    }
  }
}
