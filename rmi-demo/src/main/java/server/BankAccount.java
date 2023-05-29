package server;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccount extends Remote {
    public BigDecimal getBalance() throws RemoteException;

    public BigDecimal deposit(BigDecimal amount) throws RemoteException;

    public BigDecimal withdraw(BigDecimal amount) throws RemoteException;
}
