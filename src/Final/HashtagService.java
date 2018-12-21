package Final;

import java.util.ArrayList;
import java.util.List;
import week12_hashing.HashTable;
import week12_hashing.Node;

/**
 *
 * @author Jeremy Santorelli
 * 
 * QUESTION 9
 */
public class HashtagService<K, V> extends HashTable {

    public HashtagService(int capacity) {
        super.capacity = capacity;
        super.buckets = (Node<K, V>[]) new Node[capacity];
    }

    public HashtagService() {
        this(31);
    }

    public List<K> getAllHashtags(HashtagService<String, String> s) {
        List<K> tags = new ArrayList<>();
        for (int i = 0; i < s.capacity; i++) {
            if (s.getBuckets()[i] != null) {

                Node<K, V> cursor = s.getBuckets()[i];
                while (cursor != null) {
                    tags.add(cursor.getKey());
                    cursor = cursor.getLink();
                }
            }

        }
        return tags;
    }

    public List<V> getAllMessages(HashtagService<String, String> s) {
        List<V> tags = new ArrayList<>();
        for (int i = 0; i < s.capacity; i++) {
            if (s.getBuckets()[i] != null) {

                Node<K, V> cursor = s.getBuckets()[i];
                while (cursor != null) {
                    tags.add(cursor.getVal());
                    cursor = cursor.getLink();
                }
            }

        }
        return tags;

    }

}
