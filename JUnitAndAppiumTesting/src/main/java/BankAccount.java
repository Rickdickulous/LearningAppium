public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive = true;  // default value
    private String holderName;

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double getBalance() {
        System.out.println("getBalance: $" + balance);
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public boolean isActive() {
        System.out.println("Account active: " + isActive);
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double withdraw(double amount) {
        if(balance - amount > minimumBalance) {
            System.out.println("Withdrawing $" + amount + " from current balance of $" + balance);
            balance -= amount;
            return amount;
        }
        else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount) {
        System.out.println("Depositing $" + amount + " to current balance of $" + balance);
        return balance += amount;
    }
}
