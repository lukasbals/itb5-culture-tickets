package at.fhv.td.dto;

public class DTOClient {
    private String _firstName;
    private String _lastName;
    private String _address;

    public DTOClient(String firstName, String lastName, String address) {
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
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
}
