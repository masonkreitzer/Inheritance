/**
 * Represents a Person with identifying information.
 */
public class Person {
    private final String id;
    private String firstName;
    private String lastName;
    private String title;
    private int yearOfBirth;

    /**
     * Constructs a Person with all fields.
     *
     * @param id           The ID number (non-editable)
     * @param firstName    First name
     * @param lastName     Last name
     * @param title        Title (Mr., Mrs., etc.)
     * @param yearOfBirth  Year of birth
     */
    public Person(String id, String firstName, String lastName, String title, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    //Setters (no setter for ID)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Gets the age of the person in a specified year.
     *
     * @param year The year to calculate the age for
     * @return Age in the specified year
     */
    public int getAge(int year) {
        return year - this.yearOfBirth;
    }

    /**
     * Returns the object data as a CSV string.
     *
     * @return CSV representation
     */
    public String toCSV() {
        return String.join(", ", id, firstName, lastName, title, String.valueOf(yearOfBirth));
    }

    /**
     * Returns the object data as a JSON string.
     *
     * @return JSON representation
     */
    public String toJSON() {
        return String.format("""
            {
                "id": "%s",
                "firstName": "%s",
                "lastName": "%s",
                "title": "%s",
                "yearOfBirth": %d
            }
            """, id, firstName, lastName, title, yearOfBirth);
    }

    /**
     * Returns the object data as an XML string.
     *
     * @return XML representation
     */
    public String toXML() {
        return String.format("""
            <Person>
                <ID>%s</ID>
                <FirstName>%s</FirstName>
                <LastName>%s</LastName>
                <Title>%s</Title>
                <YearOfBirth>%d</YearOfBirth>
            </Person>
            """, id, firstName, lastName, title, yearOfBirth);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person other)) return false;
        return this.id.equals(other.id);
    }
}