package at.fhv.td;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServant extends UnicastRemoteObject implements ICalculator {

    public CalculatorServant() throws RemoteException {
        super();
    }

    public int square(int number) {
        return number * number;
    }
}