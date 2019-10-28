package at.fhv.td;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
    public int square(int number) throws RemoteException;
}