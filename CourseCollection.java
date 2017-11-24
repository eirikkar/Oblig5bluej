import java.util.ArrayList;
/**
 * Write a description of class CourseCollection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CourseCollection
{
    private ArrayList <String> courses;
    /**
     * Constructor for objects of class CourseCollection
     */
    public CourseCollection() {
        courses = new ArrayList<String>();
    }
    
    public CourseCollection(String coursesEncoded) {
        this();
        this.addCourse(coursesEncoded);
    }
    
    public String encode () {
        String courseEncode = ";";
        return String.join(courseEncode, courses);
    }
    
    public void addCourse(String courseCode) {
        if (courseCode == null || courseCode.contains(";")) {
            throw new IllegalArgumentException("Is null or contains ';'");
        } else if(courses.contains(courseCode)) {
            throw new AssertionError("Course already in the array!");
        } else {
            courses.add(courseCode);
        }
    }
    public void printTest() {
        System.out.println(courses);
    }
}
