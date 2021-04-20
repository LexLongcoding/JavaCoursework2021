public class BankAccountTest {
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

    

