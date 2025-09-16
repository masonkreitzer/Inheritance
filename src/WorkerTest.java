import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for the Worker class.
 */
public class WorkerTest {

    private Worker worker;

    @BeforeEach
    void setUp() {
        // Use a valid Person constructor call (id, firstName, lastName, title, yearOfBirth)
        worker = new Worker("W001", "John", "Doe", "Mr.", 1980, 15.0);
    }

    @Test
    void testCalculateWeeklyPay_NoOvertime() {
        double hoursWorked = 30;
        double expectedPay = 30 * 15.0;
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.0001);
    }

    @Test
    void testCalculateWeeklyPay_WithOvertime() {
        double hoursWorked = 45;
        double expectedPay = 40 * 15.0 + 5 * 15.0 * 1.5;
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.0001);
    }

    @Test
    void testDisplayWeeklyPay_NoOvertime() {
        double hoursWorked = 30;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        worker.displayWeeklyPay(hoursWorked);

        System.setOut(originalOut);

        String expectedOutput = """
                Regular Hours: 30.0 hours at $15.0/hr = $450.0
                Overtime Hours: 0.0 hours at $22.5/hr = $0.0
                Total Pay: $450.0
                """ + System.lineSeparator();

        String actualOutput = outputStream.toString().replace("\r\n", "\n").trim();
        String expectedNormalized = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualOutput);
    }

    @Test
    void testDisplayWeeklyPay_WithOvertime() {
        double hoursWorked = 45;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        worker.displayWeeklyPay(hoursWorked);

        System.setOut(originalOut);

        String expectedOutput = """
                Regular Hours: 40.0 hours at $15.0/hr = $600.0
                Overtime Hours: 5.0 hours at $22.5/hr = $112.5
                Total Pay: $712.5
                """ + System.lineSeparator();

        String actualOutput = outputStream.toString().replace("\r\n", "\n").trim();
        String expectedNormalized = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedNormalized, actualOutput);
    }

    @Test
    void testToCSV() {
        String expected = "W001, John, Doe, Mr., 1980, 15.0";
        assertEquals(expected, worker.toCSV());
    }

    @Test
    void testToJSON() {
        String expected = """
                {
                    "id": "W001",
                    "firstName": "John",
                    "lastName": "Doe",
                    "title": "Mr.",
                    "yearOfBirth": 1980,
                    "hourlyPayRate": 15.0
                }
                """;
        assertEquals(expected, worker.toJSON());
    }

    @Test
    void testToXML() {
        String expected = """
                <Worker>
                    <ID>W001</ID>
                    <FirstName>John</FirstName>
                    <LastName>Doe</LastName>
                    <Title>Mr.</Title>
                    <YearOfBirth>1980</YearOfBirth>
                    <HourlyPayRate>15.0</HourlyPayRate>
                </Worker>
                """;
        assertEquals(expected, worker.toXML());
    }
}
