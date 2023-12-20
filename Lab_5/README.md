[повернутись назад](https://github.com/BlackCNP/Java/blob/main/README.md)
# Проект "Bank Account"

Цей проект представляє систему банківських рахунків. Він включає в себе наступні класи:

## Клас `BankAccount`

Цей клас представляє банківський рахунок. Він має такі поля:
- `accountNumber`: номер рахунку.
- `accountName`: ім'я рахунку.
- `balance`: баланс рахунку.

Також він має такі методи:
- `deposit(double amount)`: внесення грошей на рахунок.
- `withdraw(double amount)`: зняття грошей з рахунку.
- `getBalance()`: отримання поточного балансу.
- `getAccountSummary()`: отримання інформації про рахунок.

## Клас `Bank`

Цей клас представляє банк, який управляє банківськими рахунками. Він має такі поля:
- `accounts`: колекція банківських рахунків.
- `nextAccountNumber`: номер наступного рахунку.

Також він має такі методи:
- `createAccount(String accountName, double initialDeposit)`: створення нового рахунку.
- `findAccount(int accountNumber)`: пошук рахунку за номером.
- `transferMoney(int fromAccountNumber, int toAccountNumber, double amount)`: переказ грошей між рахунками.

## Класи виключень

Проект також включає в себе декілька класів виключень для обробки помилок:
- `InsufficientFundsException`: виключення, що виникає, коли на рахунку недостатньо коштів для здійснення операції.
- `NegativeAmountException`: виключення, що виникає, коли сума операції є від'ємною.
- `AccountNotFoundException`: виключення, що виникає, коли рахунок не знайдено.

## Клас `TestBank`

Цей клас використовується для тестування функціональності банку.

## Code

```java
public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            int account1 = bank.createAccount("Account1", 1000);
            int account2 = bank.createAccount("Account2", 500);

            bank.transferMoney(account1, account2, 200);
            System.out.println(bank.findAccount(account1).getAccountSummary());
            System.out.println(bank.findAccount(account2).getAccountSummary());

            bank.transferMoney(account1, account2, 2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
``` 
#### Пояснення
Цей код створює новий об’єкт Bank, а потім створює два рахунки, «Користувач» і «Банк», із початковим балансом 1000 і 500 відповідно. Потім він переносить 200 з «Акаунта1» в «Акаунт2» і роздруковує підсумки рахунків для обох облікових записів.

Потім він намагається перенести ще 200 з 'Рахунок1' на 'Рахунок2'. Якщо «Account1» не буде мати достатньо коштів, це призведе до створення та перехоплення «InsufficientFundsException», а на консолі буде надруковано повідомлення про помилку «Недостатньо коштів».