/**
 * Worker class that extends Person and includes hourly pay rate.
 */
public class Worker extends Person {
    private final double hourlyPayRate;

    /**
     * Constructor for Worker.
     *
     * @param id           The ID of the worker
     * @param firstName    First name
     * @param lastName     Last name
     * @param title        Title (Mr., Ms., etc.)
     * @param yearOfBirth  Year of birth
     * @param hourlyPayRate Hourly pay rate
     */
    public Worker(String id, String firstName, String lastName, String title, int yearOfBirth, double hourlyPayRate) {
        super(id, firstName, lastName, title, yearOfBirth);
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * The Worker class represents an hourly employee and extends the Person class.
     * It adds an hourly pay rate and provides functionality to:
     * - Calculate weekly pay including overtime
     * - Display detailed weekly pay breakdown
     * - Export worker data in CSV, JSON, and XML formats
     * This class is intended for use in payroll systems or employee recordkeeping,
     * and serves as a base for subclasses like SalaryWorker.
     */
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    /**
     * Calculates weekly pay based on hours worked.
     * Regular hours up to 40 are paid at hourlyPayRate.
     * Overtime hours (above 40) are paid at 1.5 times hourlyPayRate.
     *
     * @param hoursWorked Total hours worked in a week
     * @return Calculated weekly pay including overtime if applicable
     */
    public double calculateWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double overtimeRate = hourlyPayRate * 1.5;

        return (regularHours * hourlyPayRate) + (overtimeHours * overtimeRate);
    }

    /**
     * Prints detailed breakdown of weekly pay to the console.
     * Shows regular hours/pay, overtime hours/pay, and total pay.
     * Matches exact output format expected by tests (line breaks, spaces, etc.).
     *
     * @param hoursWorked Total hours worked in a week
     */
    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double overtimeRate = hourlyPayRate * 1.5;

        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * overtimeRate;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.1f hours at $%.1f/hr = $%.1f%n", regularHours, hourlyPayRate, regularPay);
        System.out.printf("Overtime Hours: %.1f hours at $%.1f/hr = $%.1f%n", overtimeHours, overtimeRate, overtimePay);
        System.out.printf("Total Pay: $%.1f%n", totalPay);
    }

    /**
     * Converts Worker information into CSV format string.
     *
     * @return CSV formatted string of the Worker details
     */
    public String toCSV() {
        // Matches the test format exactly with spacing
        return String.format("%s, %s, %s, %s, %d, %.1f",
                getId(), getFirstName(), getLastName(), getTitle(), getYearOfBirth(), hourlyPayRate);
    }

    /**
     * Converts Worker information into JSON format string using Java 15+ text blocks.
     * Indentation and line breaks match test expectations exactly.
     *
     * @return JSON formatted string of the Worker details
     */
    public String toJSON() {
        return """
            {
                "id": "%s",
                "firstName": "%s",
                "lastName": "%s",
                "title": "%s",
                "yearOfBirth": %d,
                "hourlyPayRate": %.1f
            }
            """.formatted(getId(), getFirstName(), getLastName(), getTitle(), getYearOfBirth(), hourlyPayRate);
    }

    /**
     * Converts Worker information into XML format string using Java 15+ text blocks.
     * Matches test output formatting (indentation, line breaks).
     *
     * @return XML formatted string of the Worker details
     */
    public String toXML() {
        return """
            <Worker>
                <ID>%s</ID>
                <FirstName>%s</FirstName>
                <LastName>%s</LastName>
                <Title>%s</Title>
                <YearOfBirth>%d</YearOfBirth>
                <HourlyPayRate>%.1f</HourlyPayRate>
            </Worker>
            """.formatted(getId(), getFirstName(), getLastName(), getTitle(), getYearOfBirth(), hourlyPayRate);
    }
}