package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IUser;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements IUser {
    @Id
    @Column(name = "username", updatable = false, nullable = false)
    private String _username;

    @Column(name = "password")
    private String _password;

    @Column(name = "address")
    private String _address;

    @Column(name = "mobile")
    private String _mobile;

    @Column(name = "email")
    private String _email;

    @Override
    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    @Override
    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }

    @Override
    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    @Override
    public String getMobile() {
        return _mobile;
    }

    public void setMobile(String mobile) {
        _mobile = mobile;
    }

    @Override
    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }
}
