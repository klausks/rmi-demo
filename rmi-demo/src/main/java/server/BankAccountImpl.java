package server;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccount  {
    private BigDecimal balance;

    public BankAccountImpl(BigDecimal initialBalance) throws RemoteException {
        super(1099);
        this.balance = initialBalance;
    }
    @Override
    public BigDecimal getBalance() throws RemoteException {
        return balance;
    }

    @Override
    public BigDecimal deposit(BigDecimal amount) throws RemoteException {
        this.balance = this.balance.add(amount);
        return this.balance;
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
