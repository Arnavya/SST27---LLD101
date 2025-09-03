package exercise;

public class DBEmployeeFactory implements EmployeeFactory {
    public Employee create(Object source) {
        return new EmployeeDBAdapter((EmployeeDB) source);
    }
}
