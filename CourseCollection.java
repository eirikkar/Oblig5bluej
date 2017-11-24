import java.util.ArrayList;
/**
 * The Class CoruseCollection keeps all the information needed to create new courses.
 *
 * @author (Eirik Karlsen)
 * @version (1.0)
 */
public class CourseCollection
{
    private ArrayList <String> courses;
    /**
     * Constructor for objects of class CourseCollection
     * Constructs a new CourseCollection object with a courses ArrayList
     */
    public CourseCollection() {
        courses = new ArrayList<String>();
    }
    
    /**
     * CourseCollection Constructor
     *
     * @param coursesEncoded
     */
    public CourseCollection(String coursesEncoded) {
        this();
        this.addCourse(coursesEncoded);
    }
    
    /**
     * Method encode
     * Encodes courses with ';'.
     * @return returns courses encoded.
     */
    public String encode () {
        String courseEncode = ";";
        return String.join(courseEncode, courses);
    }
    
    /**
     * Method addCourse
     * Takes the param and checks if the parameter is valid. If it is valid it adds it to the courses ArrayList.
     * @param courseCode
     */
    public void addCourse(String courseCode) {
        if (courseCode == null || courseCode.contains(";")) {
            throw new IllegalArgumentException("Is null or contains ';'");
        } else if(courses.contains(courseCode)) {
            throw new AssertionError("Course already in the array!");
        } else {
            courses.add(courseCode);
        }
    }
    
    /**
     * Method printTest
     * Prints courses.
     */
    public void printTest() {
        System.out.println(courses);
    }
}
