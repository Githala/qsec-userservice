package nl.arnedeboth.qsec.userservice.providers;

import nl.arnedeboth.qsec.userservice.models.User;

import java.util.Set;

/**
 * Created by quantu on 04/02/2017.
 */
public interface IUserProvider {

    Set<User> getUsers();

    User getUserById(int id);

    User getUserByBadgeId(String badgeId);

}
