import java.util.ArrayList;

/**
 * Entry point for the application that demonstrates the use of the Person,
 * Worker, and SalaryWorker classes.
 */
public class InheritanceDemo {

    public static void main(String[] args) {

        // Step 1: Create 3 Workers and 3 SalaryWorkers
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("W001", "John", "Doe", "Mr.", 1985, 20.0));
        workers.add(new Worker("W002", "Jane", "Smith", "Ms.", 1990, 22.5));
        workers.add(new Worker("W003", "Mike", "Johnson", "Mr.", 1978, 25.0));

        workers.add(new SalaryWorker("SW001", "Alice", "Brown", "Dr.", 1980, 0.0, 104000.0));
        workers.add(new SalaryWorker("SW002", "Bob", "White", "Mr.", 1975, 0.0, 85000.0));
        workers.add(new SalaryWorker("SW003", "Clara", "Black", "Ms.", 1988, 0.0, 96000.0));

        // Step 2: Simulate 3 weekly pay periods
        int[] hoursWorkedPerWeek = {40, 50, 40};

        System.out.println("=== Weekly Pay Report ===\n");

        for (int week = 0; week < hoursWorkedPerWeek.length; week++) {
            System.out.printf("Week %d (Hours Worked: %d):%n", week + 1, hoursWorkedPerWeek[week]);
            System.out.println("-----------------------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-10s%n", "ID", "Name", "Type", "Pay");
            System.out.println("-----------------------------------------------------------");

            for (Worker worker : workers) {
                String fullName = worker.getFirstName() + " " + worker.getLastName();
                String type = worker instanceof SalaryWorker ? "SalaryWorker" : "Worker";
                double pay = worker.calculateWeeklyPay(hoursWorkedPerWeek[week]);
                System.out.printf("%-10s %-15s %-15s $%.2f%n", worker.getId(), fullName, type, pay);
            }

            System.out.println();
        }
    }
}
