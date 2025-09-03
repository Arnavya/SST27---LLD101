package exercise;
// Adapter for CSV
public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV instance;

    public EmployeeCSVAdapter(EmployeeCSV instance) {
        this.instance = instance;
    }

    public String getId() { return instance.tokens()[0]; }
    public String getFirstName() { return instance.tokens()[1]; }
    public String getLastName() { return instance.tokens()[2]; }
    public String getEmail() { return instance.tokens()[3]; }
}
