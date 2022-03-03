import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {
    private double incomeSum = 0;
    private double expenseSum = 0;
    private static String pathToCSV;
    private final ArrayList<BankAccount> bankAccountList = new ArrayList<>();

    public Movements(String pathMovementsCsv){
        this.pathToCSV = pathMovementsCsv;
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathToCSV));
            for (int i = 1; i < lines.size(); i++) {
                String[] elements = lines.get(i).split(",");
                bankAccountList.add(new BankAccount(elements[0],
                        elements[1],
                        elements[2],
                        elements[3],
                        elements[4],
                        elements[5],
                        elements[6],
                        elements[7]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        for (BankAccount account : bankAccountList) {
            Pattern pattern = Pattern.compile("\\d+(\\.)?(\\d+)?");
            Matcher matcherCleanNumber;
            matcherCleanNumber = pattern.matcher(account.getExpenses());
            matcherCleanNumber.find();
            double expense = Double.parseDouble(matcherCleanNumber.group());
            expenseSum += expense;
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        for (BankAccount account : bankAccountList) {
            Pattern pattern = Pattern.compile("\\d+(\\.)?(\\d+)?");
            Matcher matcherCleanNumber;
            matcherCleanNumber = pattern.matcher(account.getIncome());
            matcherCleanNumber.find();
            double income = Double.parseDouble(matcherCleanNumber.group());
            incomeSum += income;
        }
        return incomeSum;
    }
}
