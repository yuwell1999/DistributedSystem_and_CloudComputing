package Ex04;

import java.rmi.RemoteException;

public interface IHello extends java.rmi.Remote {
    String say(HelloTask task) throws RemoteException;
}
