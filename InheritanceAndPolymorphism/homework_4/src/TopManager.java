import java.util.HashMap;
import java.util.Map;


public class TopManager implements Employee {
    private static int SALARY = 150000;

    public TopManager(int companyOperationIncome) {
        if (SALARY + companyOperationIncome > 10000000) {
            SALARY += SALARY * 1.5;
        }
    }

    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}
