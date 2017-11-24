
/**
 * Write a description of class Name here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Name
{
    private String firstName;
    private String surname;
    /**
     * Constructor for objects of class Name
     */
    public Name(String firstName, String surname)
    {
       this.firstName = firstName;
       this.surname = surname;
    }
    /**
     * Name Constructor
     *
     * @param encodedIdentity A parameter
     */
    public Name(String encodedIdentity) {
        encodedIdentity = encode();
    }

    /**
     * Method getFirstName
     *
     * @return The return value
     */
    public String getFirstName () {
        return firstName;
    }
    
    /**
     * Method getSurname
     *
     * @return The return value
     */
    public String getSurname () {
        return surname;
    }
    
    /**
     * Method encode
     *
     * @return The return value
     */
    public String encode () {
        return firstName + ";" + surname;
    }
}
