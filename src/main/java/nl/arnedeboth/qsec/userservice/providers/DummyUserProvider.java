package nl.arnedeboth.qsec.userservice.providers;

import nl.arnedeboth.qsec.userservice.models.User;
import nl.arnedeboth.qsec.userservice.providers.IUserProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by quantu on 04/02/2017.
 */
public class DummyUserProvider implements IUserProvider {

    private Set<User> users = new HashSet<User>();

    public DummyUserProvider()
    {
        users.add(new User(1, "Viktor", "Lantsov", new String[] {"12345", "f0279a7e"}, new int[] {1 ,2, 3}));
        users.add(new User(2, "John", "Doe", new String[] {"23451", "6eeeb1ab"}, new int[] {2} ));
        users.add(new User(3, "Jane", "Doe", new String[] {"34512"}, new int[] {3} ));
        users.add(new User(4, "Denna Maria", "Aska", new String[] {"54321", "3d65b4ab"}, new int[] {1} ));
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> possibleUser =  users.stream().filter(u -> u.getId() == id).findFirst();
        return possibleUser.orElse(null);
    }

    @Override
    public User getUserByBadgeId(String badgeId) {
        Optional<User> possibleUser = users.stream().filter(u -> Arrays.stream(u.getBadgeIds()).anyMatch(bid -> bid.equals(badgeId))).findFirst();
        return possibleUser.orElse(null);
    }
}
