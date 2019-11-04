package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Role;
import at.fhv.td.domain.User;

import java.util.List;

public interface IHasRole {

    Long getHasRoleId();

    List<Role> getRoles();

    List<User> getUsers();
}
