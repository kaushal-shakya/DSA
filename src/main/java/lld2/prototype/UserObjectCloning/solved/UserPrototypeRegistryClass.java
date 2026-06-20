package lld2.prototype.UserObjectCloning.solved;

import java.util.HashMap;
import java.util.Map;

public class UserPrototypeRegistryClass implements UserPrototypeRegistry {

    private Map<UserType, User> registry = new HashMap<>();

    public void addPrototype(User user) {
        this.registry.put(user.getType(), user);
    }

    public User getPrototype(UserType type) {
        return registry.get(type);
    }

    public User clone(UserType type) {
        
        User u = getPrototype(type);
        return u.cloneObject();
    }
}
