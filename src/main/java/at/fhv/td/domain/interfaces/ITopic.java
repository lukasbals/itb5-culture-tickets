package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.User;

import java.util.Set;

/**
 * @author Lukas Bals
 */
public interface ITopic {
    Long getId();

    String getName();

    Set<User> getUsers();
}
