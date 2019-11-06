package at.fhv.td.dto;

import at.fhv.td.rmi.interfaces.IClientDTO;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientDTO extends UnicastRemoteObject implements IClientDTO {
    private String _firstName;
    private String _lastName;
    private String _address;
    private Long _id;

    public ClientDTO () throws RemoteException {

    }

    public ClientDTO(String firstName, String lastName, String address, Long id) throws RemoteException {
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
        _id = id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
}
