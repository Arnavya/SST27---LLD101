package exercise;

// Adapter for DB
public class EmployeeDBAdapter implements Employee {
    private final EmployeeDB instance;

    public EmployeeDBAdapter(EmployeeDB instance) {
        this.instance = instance;
    }

    public String getId() { return String.valueOf(instance.getId()); }
    public String getFirstName() { return instance.getFirstName(); }
    public String getLastName() { return instance.getSurname(); }
    public String getEmail() { return instance.getEmailAddress(); }
}
