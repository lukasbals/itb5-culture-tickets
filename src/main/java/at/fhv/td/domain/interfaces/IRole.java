package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.User;

import java.util.Set;

public interface IRole {
    Long getRoleId();

    String getRoleName();

    String getRights();

    Set<User> getUsers();
}
