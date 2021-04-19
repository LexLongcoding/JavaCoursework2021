import java.util.*;

public class BankAccount {
    public static int numAccounts = 0;
    public static double totalHoldings = 0;

    private static String createAccount() {
        String subst = "";
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            subst += r.nextInt(10);
        }
        return subst;
    }

    private String accountNum;
    private double checkingBal;
    private double savingsBal;

    public BankAccount() {
        BankAccount.numAccounts += 1;
        this.checkingBal = 0;
        this.savingsBal = 0;
        this.accountNum = BankAccount.createAccount();
    }



    public double getCheckingBalance() {
        return this.checkingBal;
    }

    public double getSavingsBalance() {
        return this.savingsBal;
    }

    public void depositMoney(double amount, String account) {
        if (account.equals("savings"))
            this.savingsBal += amount;
        else if (account.equals("checking"))
            this.checkingBal += amount;
        BankAccount.totalHoldings += amount;
    }

    public void withdrawMoney(double amount, String account) {
        boolean successful = false;
        if (account.equals("savings")) {
            // check if enough in account
            if (this.savingsBal - amount >= 0) {
                successful = true;
                this.savingsBal -= amount;
            }
        } else if (account.equals("checking")) {
            // check if enough in account
            if (this.checkingBal - amount >= 0) {
                successful = true;
                this.checkingBal -= amount;
            }
        }
        if (successful) {
            BankAccount.totalHoldings -= amount;
        }
    }

    public void displayAccountBalance() {
        // %.2f formats decimal to the 10s place
        System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBal, this.checkingBal));
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.depositMoney(100.49, "checking");
        ba.depositMoney(3.00, "savings");
        ba.displayAccountBalance();

        System.out.println(BankAccount.totalHoldings);

        ba.withdrawMoney(50, "checking");
        ba.withdrawMoney(50, "savings");
        ba.displayAccountBalance();

        System.out.println(BankAccount.totalHoldings);
    }
}
