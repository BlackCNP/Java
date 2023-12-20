package hello.world;

import java.util.HashMap;
import java.util.Map;
public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Неможливо внести від'ємну суму");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Неможливо зняти від'ємну суму");
        }
        if (this.balance < amount) {
            throw new InsufficientFundsException("Недостатньо коштів на рахунку");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountSummary() {
        return "Рахунок #" + this.accountNumber + " (" + this.accountName + "): " + this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
}

class Bank {
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public int createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        int accountNumber = nextAccountNumber++;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Рахунок не знайдено");
        }
        return account;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            int account1 = bank.createAccount("Джон", 1000);
            int account2 = bank.createAccount("Банк", 500);

            bank.transferMoney(account1, account2, 200);
            System.out.println(bank.findAccount(account1).getAccountSummary());
            System.out.println(bank.findAccount(account2).getAccountSummary());

            bank.transferMoney(account1, account2, 2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
