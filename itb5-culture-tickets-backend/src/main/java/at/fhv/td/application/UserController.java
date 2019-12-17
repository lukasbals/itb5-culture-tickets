package at.fhv.td.application;

import at.fhv.td.domain.Topic;
import at.fhv.td.domain.User;
import at.fhv.td.persistence.PersistenceFilter;
import at.fhv.td.persistence.broker.UserBroker;

import java.util.LinkedList;
import java.util.List;

public class UserController {

    private UserController() {
    }

    public static User getUser(String userName) {
        List<PersistenceFilter> filters = new LinkedList<>();
        filters.add(new PersistenceFilter(PersistenceFilter.FilterType.EQ, "_username", userName));
        List<User> foundUsers = UserBroker.getInstance().getAll(filters);

        if (foundUsers.size() == 1) {
            return foundUsers.get(0);
        }

        return null;
    }

    public static List<Topic> getTopics(String username) {
        User user = getUser(username);
        if (user != null) {
            return new LinkedList<>(user.getTopics());
        }
        return null;
    }

    public static boolean hasRole(User executingUser, String roleName) {
        if (executingUser != null) {
            boolean hasGivenRole = executingUser.getRoles().stream().anyMatch(role -> role.getRoleName().equalsIgnoreCase(roleName));
            boolean hasAdminRole = executingUser.getRoles().stream().anyMatch(role -> role.getRoleName().equalsIgnoreCase("admin"));
            return hasAdminRole || hasGivenRole;
        }

        return false;
    }
}
