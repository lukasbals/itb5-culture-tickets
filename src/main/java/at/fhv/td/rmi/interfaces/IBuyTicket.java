package at.fhv.td.rmi.interfaces;

import javafx.util.Pair;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBuyTicket extends Remote {
    public Pair<Boolean, String> buyTicket(ITicketDTO ticket) throws RemoteException;
}
