package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Role;

import java.util.Set;

public interface IUser {
    String getUsername();

    String getEmail();

    Set<Role> getRoles();
}
