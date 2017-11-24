public class Main {
    public static void main(String[] args) {

      Student student = new Student("Asdf", "Qwerty");
      student.addCourse("Kurset");
      student.addCourse("Kurs2");
      student.addCourse("Kurs3");
      UserDatabase.getInstance();
      UserDatabase userdatabase = new UserDatabase();

      UserDatabase.getInstance().addStudent(student);

      System.out.println(UserDatabase.getInstance().saveDatabase());
      System.out.println(userdatabase.loadDatabase());
      System.out.println("Ferdig!");


    }
}