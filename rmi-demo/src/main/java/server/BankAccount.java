package server;

import java.math.BigDecimal;
import java.rmi.Remote;

public interface BankAccount extends Remote {
    public BigDecimal getSaldo();

    public void deposit(BigDecimal amount);

    public BigDecimal withdraw(BigDecimal amount);
}
