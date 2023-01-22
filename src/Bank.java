import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {
    private List<IAccount> accounts;
    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        this.accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetAccountNumber() == accountNumber){
                if (this.accounts.get(i).GetCurrentBalance() >= 0) {
                    this.accounts.remove(i);
                } else {
                    System.out.println("The account isn't closed due to debt");
                }
            }
        };
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<IAccount>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() < 0) {
                accountsInDebt.add(this.accounts.get(i));
            }
        }
        return accountsInDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double BalanceAbove) {
        List<IAccount> accountsInBalance = new ArrayList<IAccount>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() > BalanceAbove) {
                accountsInBalance.add(this.accounts.get(i));
            }
        }
        return accountsInBalance;
    }
}
