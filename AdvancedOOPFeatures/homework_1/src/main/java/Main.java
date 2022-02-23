import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "C:\\Users\\Nikita\\IdeaProjects\\" +
            "java_basics\\AdvancedOOPFeatures\\homework_1\\data\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        sortBySalaryAndAlphabet(staff);

        for (Employee inStaffList : staff) {
            System.out.println(inStaffList);
        }
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((s1, s2) -> {
            if (s1.getSalary().equals(s2.getSalary())) {
                return s1.getName().compareTo(s2.getName());
            }
            return s1.getSalary().compareTo(s2.getSalary());
        });
    }
}