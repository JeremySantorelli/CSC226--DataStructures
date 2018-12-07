package week4_Stack;

import week3_ArrayList.Node;

/**
 *
 * @author jerem
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    private LinkedStack(Node<E> head) {
        this.top = head;
    }

    @Override
    public void push(E item) {

        Node<E> newNode = new Node<>(item, top);
        this.top = newNode;
        size++;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        return size == 0 ? null : top.getInfo();
    }

    @Override
    public E pop() {//This is not functioning
        if (size == 1) {
            top = null;
        } else if (size > 1 && top.getLink() != null) {
            top = top.getLink();
        }
        size--;
        return null;
    }

    @Override
    public String toString() {
        Node<E> next = top;
        String str = "";

        while (next != null) {

            str += next.getInfo() + " ";
            next = next.getLink();

        }

        return str;
    }
    //2A
    @Override
    public void addSecond(E item) {

        Node<E> secondNode = top.getLink();
        top.setLink(new Node(item, secondNode));
        size++;

    }
    //2B
    @Override
    public void removeLast() {
        Node<E> next = top;
        Node<E> last = null;
        while (next.getLink() != null) {

            if (next.getLink() != null) {
                last = next;
                next = next.getLink();
            }
           

        }
        
        last.setLink(null);

    }
    
    

}
