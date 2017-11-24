
/**
 * The Name class creates and encodes names.
 *
 * @author (Eirik Karlsen)
 * @version (1.0)
 */
public class Name
{
    private String firstName;
    private String surname;
    
    /**
     * Name Constructor
     *
     * @param firstName A parameter
     * @param surname A parameter
     */
    public Name(String firstName, String surname)
    {
       this.firstName = firstName;
       this.surname = surname;
    }
    /**
     * Name Constructor
     *
     * @param encodedIdentity Takes encodedIdentity as a parameter.
     */
    public Name(String encodedIdentity) {
        encodedIdentity = encode();
    }

    /**
     * Method getFirstName
     *
     * @return Returns firstName
     */
    public String getFirstName () {
        return firstName;
    }
    
    /**
     * Method getSurname
     *
     * @return Returns surname
     */
    public String getSurname () {
        return surname;
    }
    
    /**
     * Method encode
     *
     * @return returns firstName and surname encoded
     */
    public String encode () {
        return firstName + ";" + surname;
    }
}
