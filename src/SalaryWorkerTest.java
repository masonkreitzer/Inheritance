import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the SalaryWorker class.
 */
public class SalaryWorkerTest {

    private SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        salaryWorker = new SalaryWorker("SW001", "Gandalf", "TheGrey", "Dr.", 1000, 0.0, 104000.0);
    }

    @Test
    void testCalculateWeeklyPay() {
        double expected = 104000.0 / 52;
        assertEquals(expected, salaryWorker.calculateWeeklyPay(40), 0.01);
    }

    @Test
    void testDisplayWeeklyPay() {
        salaryWorker.displayWeeklyPay(40);
    }

    @Test
    void testGetSetAnnualSalary() {
        salaryWorker.setAnnualSalary(120000.0);
        assertEquals(120000.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void testToCSV() {
        String expected = "SW001, Gandalf, TheGrey, Dr., 1000, 0.0, 104000.0";
        assertEquals(expected.trim(), salaryWorker.toCSV().trim());
    }

    @Test
    void testToJSON() {
        String expected = """
        {
            "id": "SW001",
            "firstName": "Gandalf",
            "lastName": "TheGrey",
            "title": "Dr.",
            "yearOfBirth": 1000,
            "hourlyPayRate": 0.0,
            "annualSalary": 104000.0
        }
        """;

        System.out.println("Expected JSON:\n" + expected.trim());
        System.out.println("Actual JSON:\n" + salaryWorker.toJSON().trim());

        assertEquals(expected.trim(), salaryWorker.toJSON().trim());
    }

    @Test
    void testToXML() {
        String expected = """
        <SalaryWorker>
            <ID>SW001</ID>
            <FirstName>Gandalf</FirstName>
            <LastName>TheGrey</LastName>
            <Title>Dr.</Title>
            <YearOfBirth>1000</YearOfBirth>
            <HourlyPayRate>0.0</HourlyPayRate>
            <AnnualSalary>104000.0</AnnualSalary>
        </SalaryWorker>
        """;

        System.out.println("Expected XML:\n" + expected.trim());
        System.out.println("Actual XML:\n" + salaryWorker.toXML().trim());

        assertEquals(expected.trim(), salaryWorker.toXML().trim());
    }
}
