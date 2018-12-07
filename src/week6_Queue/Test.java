package week6_Queue;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {

        CircularLinkedQ<Integer> circleQ = new CircularLinkedQ();
        //Check behavior of toString() when Queue isEmpty() = true
        System.out.println("toString() " + circleQ.toString());

        //Check behavior of dequeue when Queue isEmpty() = true
        System.out.println("DEQUEUE: " + circleQ.dequeue());

        //enqueue and dequeue from Queue with normal operations
        circleQ.enqueue(1);
        if (!circleQ.isEmpty()) {
            System.out.println("DEQUEUE: " + circleQ.dequeue());
        }
        circleQ.enqueue(2);
        circleQ.enqueue(50);
        if (!circleQ.isEmpty()) {
            System.out.println("DEQUEUE: " + circleQ.dequeue());
        }
        circleQ.enqueue(60);
        circleQ.enqueue(70);
        circleQ.enqueue(80);
        if (!circleQ.isEmpty()) {
            System.out.println("toString() " + circleQ.toString());
            System.out.println("DEQUEUE: " + circleQ.dequeue());

            System.out.println("toString() " + circleQ.toString());
        }

        //Check behavior of enqueue when given a "null" value
        circleQ.enqueue(null);
        System.out.println("toString() " + circleQ.toString());
    }
}
