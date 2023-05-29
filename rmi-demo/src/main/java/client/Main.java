package client;

import server.BankAccount;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            BankAccount bankAccount = (BankAccount) registry.lookup("BankAccount");

            System.out.printf("Initial balance: %s%n", bankAccount.getBalance());
            System.out.printf("Balance after deposit of 10.00: %s%n", bankAccount.deposit(new BigDecimal("10.00")));
            System.out.printf("Balance after withdrawal of 3.00: %s%n", bankAccount.withdraw(new BigDecimal("3.00")));
            System.out.printf("Error when trying to withdraw more than the available balance: %s%n", bankAccount.withdraw(new BigDecimal("10.00")));


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}