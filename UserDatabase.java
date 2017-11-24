import java.nio.file.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.stream.Collectors;
/**
 * Write a description of class UserDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserDatabase
{
    public static final String DATABASE_FILENAME = "DB.tsv";
    public static final Path DATABASE_PATH = Paths.get("DB.tsv");
    private ArrayList <Student> students;
    private static UserDatabase instance;
    
    /**
     * Constructor for objects of class UserDatabase
     */
    public UserDatabase() {
        students = new ArrayList<>();
    }
    
    public static UserDatabase getInstance() {
        if(instance == null){
            instance = new UserDatabase();
        } 
        return instance;
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void listStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public boolean saveDatabase() {
        try {
            Files.write(Paths.get(DATABASE_FILENAME),
                    students.stream()
                            .map(Student::encode)
                            .collect(Collectors.toCollection(ArrayList::new)));
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }
    
    public boolean loadDatabase() {
        try {
            students = Files.lines(Paths.get(DATABASE_FILENAME))
                    .map(Student::new)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
           catch (IOException e) {
           throw  new DatabaseFormatException("Unable to open " + DATABASE_FILENAME);
        } finally {
            return true;
        }
    }
}
