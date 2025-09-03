package exercise;

// Adapter for LDAP
public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP instance;

    public EmployeeLDAPAdapter(EmployeeLDAP instance) {
        this.instance = instance;
    }

    public String getId() { return instance.get("uid"); }
    public String getFirstName() { return instance.get("givenName"); }
    public String getLastName() { return instance.get("sn"); }
    public String getEmail() { return instance.get("mail"); }
}
