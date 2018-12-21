package week12_hashing;

/**
 *
 * @author Jeremy Santorelli
 */
public class HashTable<K, V> {

    public Node<K, V>[] buckets;
    public int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<K, V>[]) new Node[capacity];
    }

    public HashTable() {
        this(31);
    }

    public Node<K, V>[] getBuckets() {
        return buckets;
    }

    public int getCapacity() {
        return capacity;
    }

    public void put(K k, V v) {
        int location = Math.abs(k.hashCode() % capacity);
        Node<K, V> node = findNode(location, k);
        if (node == null) {
            node = new Node<>(k, v);
            node.setLink(buckets[location]);
            buckets[location] = node;
        } else {
            Node<K, V> newNode = new Node<>(k, v);
            newNode.setLink(node);
            buckets[location] = newNode;
        }
    }

    protected Node<K, V> findNode(int location, K k) {
        Node<K, V> head = buckets[location];
        if (head != null) {
            Node<K, V> cursor = head;
            while (cursor != null) {
                if (cursor.getKey().equals(k)) {
                    return cursor;
                } else {
                    cursor = cursor.getLink();
                }

            }
        }
        return null;
    }

    public V get(K k) {
        int location = k.hashCode() % capacity;
        Node<K, V> node = findNode(location, k);
        if (node == null) {
            return null;
        } else {
            return node.getVal();
        }
    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < capacity; i++) {
            if (buckets[i] == null) {

            } else {
                Node<K, V> cursor = buckets[i];
                int count = 1;
                String spacing = "";
                while (cursor != null) {
                    str += spacing + "Key: " + cursor.getKey() + " Level: " + count + " Value: " + cursor.getVal() + "\n";
                    count++;
                    spacing += "  ";
                    cursor = cursor.getLink();
                }

            }
        }
        return str;
    }

}
