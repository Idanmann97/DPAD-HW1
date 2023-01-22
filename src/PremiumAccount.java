public class PremiumAccount extends Account {
    //Constructor
    public PremiumAccount(int accountNumber) {

        this.accountNumber = accountNumber;
    }

//Behaviour
    @Override
    public void Deposit(double amount) {
        if (amount>0) {
            this.balance = this.balance + amount;
        }
    }

    @Override
    public double Withdraw(double amount) {
        if (amount > 0) {
            this.balance = this.balance - amount;
            return amount;
        }
        return 0;
    }
}
