import java.nio.file.*;
import java.util.ArrayList;
import java.io.IOException;
import java.util.stream.Collectors;
/**
 * The UserDatabase interacts with the database, saves or loads from it and creates a students arraylist.
 *
 * @author (Eirik Karlsen)
 * @version (1.0)
 */
public class UserDatabase
{
    public static final String DATABASE_FILENAME = "DB.tsv";
    public static final Path DATABASE_PATH = Paths.get("DB.tsv");
    private ArrayList <Student> students;
    private static UserDatabase instance;
    
    /**
     * Constructor for objects of class UserDatabase
     * Constructs a new UserDatabase object and makes a students AL.
     */
    private UserDatabase() {
        students = new ArrayList<>();
    }
    
    /**
     * Method getInstance
     * Creates a new UserDatabase object or refers to an existing one.
     * @return Returns a instance for UserDatabase
     */
    public static UserDatabase getInstance() {
        if(instance == null){
            instance = new UserDatabase();
        } 
        return instance;
    }
    
    /**
     * Method addStudent
     * Adds a student to the students ArrayList.
     * @param student
     */
    public void addStudent(Student student) {
        students.add(student);
    }
    
    /**
     * Method listStudents
     * Lists students in the ArrayList students.
     */
    public void listStudents() {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
    
    /**
     * Method saveDatabase
     * Adds the students ArrayList to the database filename "DB.tsv" and
     * encodes the student.
     * @return returns true if the database is updated
     */
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
    
    /**
     * Method loadDatabase
     * Loads the database from 'DB.tsv', creates a new student object.
     * @return Returns true if the database is correctly encoded.
     */
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
