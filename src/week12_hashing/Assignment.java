package week12_hashing;

import java.util.Random;

/**
 *
 * @author Jeremy Santorelli
 * @param <K>
 * @param <V>
 */
public class Assignment<K, V> extends HashTable {

    public Assignment(int capacity) {
        super(capacity);
    }

    //QUESTION 1a
    boolean containsKey(K k) {
        int location = k.hashCode() % super.capacity;
        return super.findNode(location, k) != null;
    }

    //QUESTION 1b
    public void remove(K k) {
        int location = k.hashCode() % super.capacity;
        Node<K, V> head = super.buckets[location];
        if (head != null) {
            Node<K, V> cursor = head;
            Node<K, V> precursor = null;
            while (cursor != null) {
                if (precursor != null) {
                    if (cursor.getKey().equals(k)) {
                        precursor.setLink(cursor.getLink());
                    } else {
                        precursor = cursor;
                        cursor = cursor.getLink();
                    }
                } else if (cursor.getKey().equals(k)) {
                    super.buckets[location] = cursor.getLink();
                    cursor = cursor.getLink();
                } else {
                    precursor = cursor;
                    cursor = cursor.getLink();
                }

            }
        }
    }
    
    
    
    

    
    
    
    
    //QUESTION 1c
    public int getNumItems() {
        int size = 0;
        for (int i = 0; i < super.capacity; i++) {
            Node<K, V> cursor = buckets[i];
            while (cursor != null) {
                size++;
                cursor = cursor.getLink();
            }
        }
        return size;
    }

    //QUESTION 1d
    public void displayHashMapStatistics() {
        double[] stats = new double[super.capacity];
        double sum = 0.0;
        double count = 0.0;
        for (int i = 0; i < super.capacity; i++) {
            stats[i] = 0.0;
            Node<K, V> cursor = buckets[i];
            while (cursor != null) {
                stats[i] += 1;
                cursor = cursor.getLink();
            }
            if (stats[i] != 0.0) {
                count++;
            }
            sum += stats[i];
        }
        System.out.printf("Standard Deviation: %.3f\n",
                standardDeviation(sum / count, stats, count));
    }

    public double hashMapStatistics() {
        double[] stats = new double[super.capacity];
        double sum = 0.0;
        double count = 0.0;
        for (int i = 0; i < super.capacity; i++) {
            stats[i] = 0.0;
            Node<K, V> cursor = buckets[i];
            while (cursor != null) {
                stats[i] += 1;
                cursor = cursor.getLink();
            }
            if (stats[i] != 0.0) {
                count++;
            }
            sum += stats[i];
        }
        return standardDeviation(sum / count, stats, count);

    }

    
    
    
    
    private double standardDeviation(double avgLength,
            double[] stats, double n) {
        double summation = 0.0;
        for (int i = 0; i < capacity; i++) {
            if (stats[i] != 0.0) {
                summation += Math.pow((avgLength - stats[i]), 2);
            }
        }
        return Math.sqrt(summation / n);
    }

    public static boolean isPrime(int num) {
        int remainder;
        for (int i = 2; i <= num / 2; i++) {
            remainder = num % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        int capacity = 4;

        Assignment<Integer, Integer> s = new Assignment<>(capacity);
        Random r = new Random();

        //QUESTION 1
        System.out.println("Question 1\n");
        s.put(1, r.nextInt());
        s.put(2, r.nextInt());
        s.put(3, r.nextInt());
        s.put(4, r.nextInt());
        s.put(1, r.nextInt());
        s.put(2, r.nextInt());
        s.put(3, r.nextInt());
        s.put(4, r.nextInt());
        s.put(3, r.nextInt());
        s.put(2, r.nextInt());

        System.out.println(s.toString());
        System.out.println("1a >> " + s.containsKey(3));//QUESTION 1a
        System.out.println("1a >> " + s.containsKey(6));//QUESTION 1a
        System.out.println("\n1c >> " + s.getNumItems());//QUESTION 1c
        System.out.print("\n1d >> ");
        s.displayHashMapStatistics();//QUESTION 1d
        System.out.println("\nRemove key 3\n");
        s.remove(2);//QUESTION 1b
        System.out.println("1c >> " + s.getNumItems() + "\n");//QUESTION 1b
        System.out.println(s.toString());
        System.out.print("1d >> ");
        s.displayHashMapStatistics();//QUESTION 1d

        s.remove(1);
        s.remove(3);
        s.remove(4);
        System.out.println("Remove all Elements" + s.toString());

        //QUESTION 2
        System.out.println("\nQuestion 2\n");
        for (int size = 1; size < 151; size += 3) {
            if (isPrime(size)) {
                s = new Assignment<>(size);
                for (int i = 0; i < 101; i++) {
                    s.put(r.nextInt(size), r.nextInt(100) + i);
                }
                double s2s = 100.0 / size;
                System.out.printf("Array Size: %d Ratio: %.2f ", size, s2s);
                s.displayHashMapStatistics();
            }

        }

    }

}
