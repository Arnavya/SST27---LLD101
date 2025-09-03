package exercise;

public class CSVEmployeeFactory implements EmployeeFactory {
    public Employee create(Object source) {
        return new EmployeeCSVAdapter((EmployeeCSV) source);
    }
}
