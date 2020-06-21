package Ex04;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer extends java.rmi.server.UnicastRemoteObject implements IHello {
    private static final long serialVersionUID = 2L;

    public HelloServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            HelloServer hs = new HelloServer();
            Registry registry = LocateRegistry.createRegistry(Constants.CLIENT_PORT);
            registry.bind("hell0", hs);
            System.out.println("Start...");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String say(HelloTask task) throws RemoteException {
        String result = task.execute();
        System.out.println("Execute say,task.execute:" + result);
        return result;
    }
}
