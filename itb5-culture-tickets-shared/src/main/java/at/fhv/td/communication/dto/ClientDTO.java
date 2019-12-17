package at.fhv.td.communication.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientDTO implements Serializable {
    private String _firstName;
    private String _lastName;
    private String _address;
    private Long _id;

    public ClientDTO() {
        super();
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClientDTO) {
            return getId().equals(((ClientDTO) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }
}
