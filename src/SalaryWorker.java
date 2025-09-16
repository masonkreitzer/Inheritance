/**
 * SalaryWorker is a subclass of Worker that uses a fixed annual salary.
 */
public class SalaryWorker extends Worker {
    private double annualSalary;

    /**
     * Constructor for SalaryWorker.
     *
     * @param id           The ID of the worker
     * @param firstName    First name
     * @param lastName     Last name
     * @param title        Title (Mr., Ms., etc.)
     * @param yearOfBirth  Year of birth
     * @param hourlyRate   Hourly rate (inherited but unused)
     * @param annualSalary Annual salary
     */
    public SalaryWorker(String id, String firstName, String lastName, String title,
                        int yearOfBirth, double hourlyRate, double annualSalary) {
        super(id, firstName, lastName, title, yearOfBirth, hourlyRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    /**
     * Calculates the weekly pay (fixed portion of annual salary).
     * @param hoursWorked Ignored, included for polymorphism
     * @return Weekly pay from salary
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    /**
     * Displays the weekly pay as a fraction of annual salary.
     */
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.printf("Salaried Worker: Weekly Pay = $%.2f (Annual Salary: $%.2f)%n", weeklyPay, annualSalary);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + annualSalary;
    }

    @Override
    public String toJSON() {
        return """
    {
        "id": "%s",
        "firstName": "%s",
        "lastName": "%s",
        "title": "%s",
        "yearOfBirth": %d,
        "hourlyPayRate": %.1f,
        "annualSalary": %.1f
    }
    """.formatted(getId(), getFirstName(), getLastName(), getTitle(), getYearOfBirth(), getHourlyPayRate(), getAnnualSalary());
    }

    @Override
    public String toXML() {
        return """
        <SalaryWorker>
            <ID>%s</ID>
            <FirstName>%s</FirstName>
            <LastName>%s</LastName>
            <Title>%s</Title>
            <YearOfBirth>%d</YearOfBirth>
            <HourlyPayRate>%.1f</HourlyPayRate>
            <AnnualSalary>%.1f</AnnualSalary>
        </SalaryWorker>
        """.formatted(getId(), getFirstName(), getLastName(), getTitle(), getYearOfBirth(), getHourlyPayRate(), getAnnualSalary());
    }
}
