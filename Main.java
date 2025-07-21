import java.util.Scanner;

public class MiniBankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null; // to store one account for demo

        while (true) {
            System.out.println("\n=== Mini Bank Menu ===");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Account Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String number = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    account = new BankAccount(name, number, balance);
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("No account found. Create one first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("No account found. Create one first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.showAccountInfo();
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public class BankAccount {
        protected String accountName;
        protected String accountNumber;
        protected double balance;

        public void showAccountInfo() {
            System.out.println("\n--- Account Info ---");
            System.out.println("Name: " + accountName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }
    public BankAccount(String accountName, String accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        BankAccount acc1 = new BankAccount("Alice", "001", 500.0);
        BankAccount acc2 = new BankAccount("Bob", "002", 1000.0);

        acc1.showAccountInfo();
        acc2.showAccountInfo();
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New Balance: $" + balance);
        }
    }
    public class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(String accountName, String accountNumber, double balance, double interestRate) {
            super(accountName, accountNumber, balance);
            this.interestRate = interestRate;
        }

        public void applyInterest() {
            double interest = balance * interestRate / 100;
            balance += interest;
            System.out.println("Applied interest: $" + interest + ". New balance: $" + balance);
        }

        @Override
        public void showAccountInfo() {
            super.showAccountInfo();
            System.out.println("Interest Rate: " + interestRate + "%");
        }
    }
}