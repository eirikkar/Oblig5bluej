import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private Name name;
    private CourseCollection courses;
    
    /**
     * Constructor for objects of class Student
     */
    public Student(String firstName, String surname) {
       name = new Name(firstName, surname);
       courses = new CourseCollection();
    }
    
    public Student(String encodedStudent) {

        //Splits encodedStudent
        String[] parts = new String[2];
        parts = encodedStudent.split("\t");

        // Splits names into firstName and surname
        String names = parts[0];
        String[] newname = new String[2];
        newname = names.split(";");
        String firstName = newname[0];
        String surname = newname[1];

        //Creates new objects for Student object
        name = new Name(firstName, surname);
        courses = new CourseCollection();

        //Splits courses, removes ';' from course list and adds courses to the CourseCollection object
        String[] course = parts [1].split(";");
      //  List<String> list = new ArrayList<String>(Arrays.asList(course));
      //  list.removeAll(Collections.singleton(";"));
        for (String c: course) addCourse(c);
    }
    
    public String encode() {
        return name.encode() + "\t" + courses.encode();
    }
    
    /**
     * Method getName
     *
     * @return The return value
     */
    public Name getName() {
        return name;
    }
    
    /**
     * Method getCourses
     *
     * @return The return value
     */
    public CourseCollection getCourses() {
        return courses;
    }
    
    public void addCourse (String course) {
        courses.addCourse(course);
    }
    
}
