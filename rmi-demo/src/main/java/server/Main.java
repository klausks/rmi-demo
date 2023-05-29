package server;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount bankAccountStub = new BankAccountImpl(BigDecimal.ZERO);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("BankAccount", bankAccountStub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
