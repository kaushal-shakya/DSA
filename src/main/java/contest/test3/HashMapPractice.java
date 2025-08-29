package contest.test3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapPractice {
    public static void main(String[] args) {

        HashMap<String, String> m1 = new HashMap<>();

        m1.put("A", "a");
        m1.put("B", "b");

        //
        Iterator<Map.Entry<String, String>> it = m1.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Set<String> s1= m1.keySet();
        Iterator<String> it1 = s1.iterator();
        while (it1.hasNext())
        {
            System.out.println(it1.next());
        }
    }


}
