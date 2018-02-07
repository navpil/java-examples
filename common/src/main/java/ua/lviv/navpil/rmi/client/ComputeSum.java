package ua.lviv.navpil.rmi.client;

import ua.lviv.navpil.rmi.compute.Compute;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeSum {

    public static void main(String[] args) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry("localhost");
            Compute comp = (Compute) registry.lookup(name);

            Sum task = new Sum(4);

            BigDecimal sum = comp.executeTask(task);
            System.out.println(sum);
        } catch (Exception e) {
            System.err.println("ComputeSum exception:");
            e.printStackTrace();
        }

    }

}
