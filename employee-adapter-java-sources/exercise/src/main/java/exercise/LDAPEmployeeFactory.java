package exercise;

public class LDAPEmployeeFactory implements EmployeeFactory {
    public Employee create(Object source) {
        return new EmployeeLDAPAdapter((EmployeeLDAP) source);
    }
}
