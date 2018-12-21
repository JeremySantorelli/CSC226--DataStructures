package week12_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {
        HashTable<Integer, String> s = new HashTable<>();
        s.put(0, "hello");
        s.put(1, "world");
        s.put(2, "and");
        s.put(2, "and1");

        System.out.println(s.toString());

        System.out.println(s.get(3));

        Map<String, Integer> map = new HashMap<>();
        
        //map.p

    }
}
