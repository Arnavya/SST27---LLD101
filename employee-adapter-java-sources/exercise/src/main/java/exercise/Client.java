package exercise;

import java.util.*;

public class Client {
  public static void main(String[] args) {
    List<EmployeeCSV> csvRows = List.of(
            new EmployeeCSV("101,John,Doe,john.doe@acme.com"),
            new EmployeeCSV("102,Sarah,Lee,sarah.lee@acme.com")
    );

    List<EmployeeDB> dbRows = List.of(
            new EmployeeDB(201, "Ravi", "Kumar", "ravi.kumar@contoso.com"),
            new EmployeeDB(202, "Anita", "Sharma", "anita.sharma@contoso.com")
    );

    List<EmployeeLDAP> ldapRows = List.of(
            new EmployeeLDAP(Map.of("uid","301","givenName","Wei","sn","Zhang","mail","wei.zhang@example.org")),
            new EmployeeLDAP(Map.of("uid","302","givenName","Elena","sn","Garcia","mail","elena.garcia@example.org"))
    );

    List<Employee> all = new ArrayList<>();

    EmployeeFactory csvFactory = new CSVEmployeeFactory();
    for (EmployeeCSV e : csvRows) {
      all.add(csvFactory.create(e));
    }

    EmployeeFactory dbFactory = new DBEmployeeFactory();
    for (EmployeeDB e : dbRows) {
      all.add(dbFactory.create(e));
    }

    EmployeeFactory ldapFactory = new LDAPEmployeeFactory();
    for (EmployeeLDAP e : ldapRows) {
      all.add(ldapFactory.create(e));
    }

    EmployeePrinter.print(all);
  }
}
