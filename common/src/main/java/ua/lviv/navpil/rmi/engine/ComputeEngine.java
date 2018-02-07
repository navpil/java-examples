package ua.lviv.navpil.rmi.engine;

import ua.lviv.navpil.rmi.compute.Compute;
import ua.lviv.navpil.rmi.compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {


    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";

            ComputeEngine engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            LocateRegistry.getRegistry().rebind(name, stub);
            System.out.println("bound");

        } catch (RemoteException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
}
