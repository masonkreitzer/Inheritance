import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Person class.
 * Tests the constructor, mutator methods, and specified methods in Person.
 * Getter methods are not tested as per instructions.
 */
public class PersonTest {

    private Person person;

    /**
     * Sets up a new Person instance before each test.
     */
    @BeforeEach
    void setUp() {
        person = new Person("000001", "Bilbo", "Baggins", "Esq.", 1060);
    }

    /**
     * Tests the constructor initializes all fields correctly.
     */
    @Test
    void testConstructor() {
        assertEquals("000001", person.getId(), "ID should be initialized");
        assertEquals("Bilbo", person.getFirstName(), "First name should be initialized");
        assertEquals("Baggins", person.getLastName(), "Last name should be initialized");
        assertEquals("Esq.", person.getTitle(), "Title should be initialized");
        assertEquals(1060, person.getYearOfBirth(), "Year of birth should be initialized");
    }

    /**
     * Tests the setFirstName mutator method.
     */
    @Test
    void testSetFirstName() {
        person.setFirstName("Frodo");
        assertEquals("Frodo", person.getFirstName(), "First name should be updated");
    }

    /**
     * Tests the setLastName mutator method.
     */
    @Test
    void testSetLastName() {
        person.setLastName("Baggins");
        assertEquals("Baggins", person.getLastName(), "Last name should be updated");
    }

    /**
     * Tests the setTitle mutator method.
     */
    @Test
    void testSetTitle() {
        person.setTitle("Mr.");
        assertEquals("Mr.", person.getTitle(), "Title should be updated");
    }

    /**
     * Tests the setYearOfBirth mutator method.
     */
    @Test
    void testSetYearOfBirth() {
        person.setYearOfBirth(1080);
        assertEquals(1080, person.getYearOfBirth(), "Year of birth should be updated");
    }

    /**
     * Tests the getAge(int year) method calculates age correctly for a given year.
     */
    @Test
    void testGetAgeForYear() {
        int testYear = 2000;
        int expectedAge = testYear - 1060;  // assuming person born in 1060 in your test setup
        assertEquals(expectedAge, person.getAge(testYear), "Age should be year minus year of birth");
    }

    /**
     * Tests the toJSON() method to ensure the Person object
     * is correctly converted into a JSON formatted string.
     */
    @Test
    void testToJSON() {
        String expected = """
            {
                "id": "000001",
                "firstName": "Bilbo",
                "lastName": "Baggins",
                "title": "Esq.",
                "yearOfBirth": 1060
            }
            """;
        assertEquals(expected, person.toJSON(), "toJSON should format person data correctly in JSON");
    }

    /**
     * Tests the toXML() method to ensure the Person object
     * is correctly converted into an XML formatted string.
     */
    @Test
    void testToXML() {
        String expected = """
            <Person>
                <ID>000001</ID>
                <FirstName>Bilbo</FirstName>
                <LastName>Baggins</LastName>
                <Title>Esq.</Title>
                <YearOfBirth>1060</YearOfBirth>
            </Person>
            """;
        assertEquals(expected, person.toXML(), "toXML should format person data correctly in XML");
    }

    /**
     * Tests the toString method returns the expected formatted string.
     */
    @Test
    void testToString() {
        String expected = "000001, Bilbo, Baggins, Esq., 1060";
        assertEquals(expected, person.toString(), "toString should format the person data correctly");
    }
}
