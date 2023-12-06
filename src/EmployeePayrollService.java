import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {
    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollDataToFile();
        employeePayrollService.countEntries();
        employeePayrollService.printEmployeePayrollsFromFile();
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter employee id : ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter employee name");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary : ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    private void writeEmployeePayrollDataToFile() {
        try (FileWriter writer = new FileWriter("employee_payroll.txt", true)) {
            for (EmployeePayrollData employee : employeePayrollList) {
                writer.write(employee.toString() + "\n");
            }
            System.out.println("Employee payroll data appended to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private void printEmployeePayrollsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_payroll.txt"))) {
            System.out.println("Employee Payroll Data from File:");
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private void countEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_payroll.txt"))) {
            long count = reader.lines().count();
            System.out.println("Number of entries: " + count);
        } catch (IOException e) {
            System.err.println("Error counting entries: " + e.getMessage());
        }
    }
}
