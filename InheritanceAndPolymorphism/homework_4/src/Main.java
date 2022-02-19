public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        hireEmployee(company);
        printHighestSalaries(company);
        printLowestSalaries(company);
        fireHalfEmployee(company);
        printHighestSalaries(company);
        printLowestSalaries(company);

    }

    private static void printHighestSalaries(Company company) {
        System.out.println("Top salary: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }

    private static void printLowestSalaries(Company company) {
        System.out.println("Most lowest salary: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary() + " руб.");
        }
    }

    private static void hireEmployee(Company company) {
        for (int i = 0; i < 180; i++) {
            Employee operator = new Operator();
            company.hire(operator);
        }
        for (int i = 0; i < 80; i++) {
            Employee manager = new Manager();
            company.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            Employee topManager = new TopManager();
            company.hire(topManager);
        }
        System.out.println("Hired: " + company.employeesCount() +  " employee");
    }

    private static void fireHalfEmployee(Company company) {
        int countEmployees = company.employeesCount();
        for (int i = 0; i < countEmployees / 2; i++) {
            int employeeIndex = (int) (Math.random() * company.employeesCount());
            company.fire(company.getEmployees().get(employeeIndex));
        }
        System.out.println("Fired: " + countEmployees / 2 + " employee");
    }
}
