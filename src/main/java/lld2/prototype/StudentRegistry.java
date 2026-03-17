package lld2.prototype;

import java.util.HashMap;

public class StudentRegistry {
    private HashMap<String, Student> map = new HashMap<>();

    Student get(String key) {
        return map.get(key);
    }

    public void put(String key, Student student) {
        map.put(key, student);
    }
}
