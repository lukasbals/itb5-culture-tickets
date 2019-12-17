package at.fhv.td.communication.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private long _userId;
    private String _userName;
    private List<String> _roles;

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public List<String> getRoles() {
        return _roles;
    }

    public void setRoles(List<String> roles) {
        _roles = roles;
    }
}
