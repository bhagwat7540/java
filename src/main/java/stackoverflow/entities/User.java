package stackoverflow.entities;

import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private int reputation;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.reputation = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReputation() {
        return reputation;
    }

    public void updateReputation(int reputation) {
        this.reputation += reputation;
    }
}
