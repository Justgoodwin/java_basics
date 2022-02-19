
public class Manager implements Employee {

    private static final int SALARY = 75000;
    private final int earningsForCompany;

    public Manager() {
        this.earningsForCompany = (int )(Math.random() * 25000) + 115000;
    }

    @Override
    public int getMonthSalary() {
        return SALARY + (int) (earningsForCompany * 0.05);
    }
}
