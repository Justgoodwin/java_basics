import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String STAFF_TXT = "C:\\Users\\Nikita\\IdeaProjects\\java_basics\\AdvancedOOPFeatures" +
            "\\homework_2\\Employees\\data\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        List<Employee> staffStream = staff.stream()
                .filter(employee -> {
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(employee.getWorkStart());
                    int y = calendar.get(Calendar.YEAR);
                    return y == year;
                })
                .collect(Collectors.toList());
        return staffStream.stream().max(Comparator.comparing(employee -> employee.getSalary())).get();
    }
}