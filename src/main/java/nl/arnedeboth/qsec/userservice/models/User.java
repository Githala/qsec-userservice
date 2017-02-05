package nl.arnedeboth.qsec.userservice.models;

/**
 * Created by quantu on 04/02/2017.
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String badgeId;
    private int[] groupIds;

    public User(int id, String firstName, String lastName, String badgeId, int[] groupIds)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.badgeId = badgeId;

        this.groupIds = groupIds;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public int[] getGroupIds() {
        return groupIds;
    }
}
