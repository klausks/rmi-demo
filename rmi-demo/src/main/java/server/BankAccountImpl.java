package server;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class BankAccountImpl implements BankAccount {
    private BigDecimal balance;

    public BankAccountImpl(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }
    @Override
    public BigDecimal getBalance() throws RemoteException {
        return balance;
    }

    @Override
    public void deposit(BigDecimal amount) throws RemoteException {
        this.balance.add(amount);
    }

    @Override
    public BigDecimal withdraw(BigDecimal amount) throws RemoteException, IllegalArgumentException {
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("The withdrawal amount is greater than the total account balance");
        }
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }
}
