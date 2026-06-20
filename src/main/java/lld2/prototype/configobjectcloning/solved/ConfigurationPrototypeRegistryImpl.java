package lld2.prototype.configobjectcloning.solved;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationPrototypeRegistryImpl implements ConfigurationPrototypeRegistry {

    private Map<ConfigurationType, Configuration> map = new HashMap<>();

    @Override
    public void addPrototype(Configuration user) {
        map.put(user.getType(), user);
    }

    @Override
    public Configuration getPrototype(ConfigurationType type) {
        return map.get(type);
    }

    @Override
    public Configuration clone(ConfigurationType type) {
        Configuration c = getPrototype(type);
        return c.cloneObject();
    }
}
