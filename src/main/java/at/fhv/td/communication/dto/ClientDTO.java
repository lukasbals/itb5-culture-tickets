package at.fhv.td.communication.dto;

import at.fhv.td.communication.rmi.interfaces.IClientDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class ClientDTO extends UnicastRemoteObject implements IClientDTO {
    private String _firstName;
    private String _lastName;
    private String _address;
    private Long _id;

    public ClientDTO() throws RemoteException {
        super();
    }

    public String getFirstName() throws RemoteException {
        return _firstName;
    }

    public void setFirstName(String firstName) throws RemoteException {
        _firstName = firstName;
    }

    public String getLastName() throws RemoteException {
        return _lastName;
    }

    public void setLastName(String lastName) throws RemoteException {
        _lastName = lastName;
    }

    public String getAddress() throws RemoteException {
        return _address;
    }

    public void setAddress(String address) throws RemoteException {
        _address = address;
    }

    public Long getId() throws RemoteException {
        return _id;
    }

    public void setId(Long id) throws RemoteException {
        _id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClientDTO) {
            try {
                return getId().equals(((ClientDTO) obj).getId());
            } catch (RemoteException ignored) {
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
