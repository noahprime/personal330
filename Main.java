public class Main{

  public static void main(String[] args){
    JdbcDatabase db = new JdbcDatabase(args[0],args[1]);
    db.run();
  }
}
