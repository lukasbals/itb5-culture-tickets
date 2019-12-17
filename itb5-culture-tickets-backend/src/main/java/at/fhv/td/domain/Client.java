package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IClient;
import at.fhv.td.persistence.broker.IModelId;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client implements IClient, IModelId {

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

    @Override
    public Long getId() {
        return _clientId;
    }

    @Override
    public void setId(Long id) {
        _clientId = id;
    }

    @Override
    public String getFirstname() {
        return _firstname;
    }

    public void setFirstname(String firstname) {
        _firstname = firstname;
    }

    @Override
    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        _lastname = lastname;
    }

    @Override
    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }
}