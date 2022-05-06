package cafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public int getCount(){
        return employees.size();
    }

    public boolean removeEmployee(String name) {
        for (Employee e : employees
        ) {
            if (e.getName().equals(name)) {
                employees.remove(e);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        int age = 0;
        Employee employee = null;
        for (Employee e : employees
        ) {
            if (e.getAge() > age) {
                age = e.getAge();
                employee = e;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name) {
        for (Employee e : employees
        ) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Cafe %s", name)).append(System.lineSeparator());
        for (Employee e: employees
             ) {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
