public class StandardAccount extends Account {
    //State
    double creditLimit;

    //Constructor
    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
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
            if (this.balance == this.creditLimit) {
                result = 0;
            } else if (this.balance - this.creditLimit < amount) {
                result = this.balance - this.creditLimit;
                this.balance = this.creditLimit;
            } else {
                this.balance = this.balance - amount;
                result = amount;
            }
        } else {
            result = 0;
        }
        return result;
    }
}
