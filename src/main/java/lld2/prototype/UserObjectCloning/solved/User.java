package lld2.prototype.UserObjectCloning.solved;

public class User implements ClonableObject<User> {
    private long userId;
    private String username;
    private String email;
    private String displayName;
    private int age;
    private UserType type;

    public User() {}
    public User(User source) {
        this.userId = source.userId;
        this.username = source.username;
        this.email = source.email;
        this.displayName = source.displayName;
        this.age = source.age;
        this.type = source.type;
    }

    public User(long userId, String username, String email, String displayName, int age, UserType type) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.displayName = displayName;
        this.age = age;
        this.type = type;
    }

    public User cloneObject() {
        return new User(this);
    }
    
    public long getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public UserType getType() {
        return type;
    }
}