import java.util.HashMap;
import java.util.Map;

public class Operator implements Employee {

    private  static final int SALARY = 37000;
    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}
