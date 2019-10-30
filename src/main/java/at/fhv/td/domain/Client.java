package at.fhv.td.domain;

import javax.persistence.*;

/**
 * @author Lukas Bals
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", updatable = false, nullable = false)
    private Long _clientId;

    @Column(name = "firstname")
    private String _firstname;

    @Column(name = "lastname")
    private String _lastname;

    @Column(name = "address")
    private String _address;

    public Long getClientId() {
        return _clientId;
    }

    public void setClientId(Long clientId) {
        this._clientId = clientId;
    }

    public String getFirstname() {
        return _firstname;
    }

    public void setFirstname(String firstname) {
        this._firstname = firstname;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        this._lastname = lastname;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        this._address = address;
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname();
    }
}
