package week12_hashing;

import java.util.Objects;

/**
 *
 * @author Jeremy Santorelli
 */
public class Node<K, V> {

    private K key;
    private V val;
    private Node<K, V> link;

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.link = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public Node<K, V> getLink() {
        return link;
    }

    public void setLink(Node<K, V> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", val=" + val + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.key);
        hash = 89 * hash + Objects.hashCode(this.val);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node<?, ?> other = (Node<?, ?>) obj;
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        if (!Objects.equals(this.val, other.val)) {
            return false;
        }
        if (!Objects.equals(this.link, other.link)) {
            return false;
        }
        return true;
    }

    
}
