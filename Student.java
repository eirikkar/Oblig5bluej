
/**
 * The student class is responsible for the creation of a student with name and courses.
 *
 * @author (Eirik Karlsen)
 * @version (1.0)
 */
public class Student
{
    private Name name;
    private CourseCollection courses;
    
    /**
     * Constructor for objects of class Student
     * Creates a student object
     */ 
    public Student(String firstName, String surname) {
       name = new Name(firstName, surname);
       courses = new CourseCollection();
    }
    
    /**
     * Student Constructor
     *
     * @param encodedStudent Takes the encodedStudent parameter and creates a
     * student object from the database.
     */
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

        //Splits courses and adds them to the CourseCollection object
        String[] course = parts [1].split(";");
        for (String c: course) addCourse(c);
    }
    
    /**
     * Method encode
     * 
     * @return returns the student name and courses encoded
     */
    public String encode() {
        return name.encode() + "\t" + courses.encode();
    }
    
    /**
     * Method getName
     *
     * @return Returns student name
     */
    public Name getName() {
        return name;
    }
    
    /**
     * Method getCourses
     *
     * @return returns the students courses
     */
    public CourseCollection getCourses() {
        return courses;
    }
    
    /**
     * Method addCourse
     * Adds courses to the student
     * @param course
     */
    public void addCourse (String course) {
        courses.addCourse(course);
    }
    
}
