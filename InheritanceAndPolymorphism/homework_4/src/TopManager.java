import java.util.HashMap;
import java.util.Map;

public class TopManager implements Employee {

    private static int SALARY = 150000;

    @Override
    public int getMonthSalary() {
        if (SALARY + Company.getIncome() > 10000000) {
            SALARY += SALARY * 1.5;
            return SALARY;
        }
        return SALARY;
    }
}
