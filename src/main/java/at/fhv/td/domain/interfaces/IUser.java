package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Role;

import java.util.Set;

public interface IUser {
    String getUsername();

    String getPassword();

    String getAddress();

    String getMobile();

    String getEmail();

    Set<Role> getRoles();
}
