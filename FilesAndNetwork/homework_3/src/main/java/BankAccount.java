import javax.xml.crypto.Data;
import java.time.LocalDate;

public class BankAccount {
        private String accountType;
        private String accountNumber;
        private String currency;
        private String data;
        private String operationReference;
        private String operationDescription;
        private String income;
        private String expenses;

        public BankAccount() {
        }

        public BankAccount(String accountType,
                           String accountNumber,
                           String currency,
                           String data,
                           String operationReference,
                           String operationDescription,
                           String income,
                           String expenses) {
                this.accountType = accountType;
                this.accountNumber = accountNumber;
                this.currency = currency;
                this.data = data;
                this.operationReference = operationReference;
                this.operationDescription = operationDescription;
                this.income = income;
                this.expenses = expenses;
        }

        public String getAccountType() {
                return accountType;
        }

        public String getAccountNumber() {
                return accountNumber;
        }

        public String getCurrency() {
                return currency;
        }

        public String getData() {
                return data;
        }

        public String getOperationReference() {
                return operationReference;
        }

        public String getOperationDescription() {
                return operationDescription;
        }

        public String getIncome() {
                return income;
        }

        public String getExpenses() {
                return expenses;
        }
}

