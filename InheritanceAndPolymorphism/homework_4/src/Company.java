import java.util.*;

public class Company {
    private final List<Employee> employees = new ArrayList<>();
    private int operationIncome;

    public Company() {
        operationIncome = (int)(Math.random() * 265121815); //данные взяты из годовой отчётности ТАТНЕФТЬ
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getOperationIncome() {
        return operationIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return getFilteredListAccordingToCount(count, new Comparator<Employee>() {
            public int compare(Employee first, Employee second) {
                return second.getMonthSalary() - first.getMonthSalary();
            }
        });
    }



    public List<Employee> getLowestSalaryStaff(int count) {
        return getFilteredListAccordingToCount(count, new Comparator<Employee>() {
            public int compare(Employee first, Employee second) {
                return first.getMonthSalary() - second.getMonthSalary();
            }
        });
    }

    private List<Employee> getFilteredListAccordingToCount(int count, Comparator<Employee> comparator) {
        List<Employee> copyList = new ArrayList<>(employees);
        copyList.sort(comparator);
        List<Employee> result = new ArrayList<>();
        for (int i =0; i < count; i++) {
            result.add(copyList.get(i));
        }
        return result;
    }

    public int employeesCount() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
