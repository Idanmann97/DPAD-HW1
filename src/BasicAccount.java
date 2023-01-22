public class BasicAccount extends Account {

    //State

    double withdrawalLimit;


    //Constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        if (withdrawalLimit < 0) {
            this.withdrawalLimit = 0;
        } else {
            this.withdrawalLimit = withdrawalLimit;
        }
    }

//Behaviour

    @Override
    public void Deposit(double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
        }
    }

    @Override
    public double Withdraw(double amount) {
        double result;
        if (amount > 0) {
            if (amount > this.withdrawalLimit) {
                amount = this.withdrawalLimit;
            }

            if (this.balance - amount > 0) {
                this.balance = this.balance - amount;
                result = amount;
            } else {
                result = this.balance;
                this.balance = 0;
            }
        } else {
            result = 0;
        }
        return result;
    }
}