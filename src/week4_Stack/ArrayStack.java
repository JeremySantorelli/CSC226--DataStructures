package week4_Stack;

/**
 *
 * @author Jeremy Santorelli
 * @param <E>
 */
public final class ArrayStack<E> implements Stack<E> {

    private E[] stack;
    private E[] temp;
    private int size = 20;
    private int count = 0;

    public ArrayStack() throws Exception {

        setStack(size);
    }

    @Override
    public void push(E item) {
        if (size - 1 < count + 1) {
            increaseArray();
        }
        this.stack[count] = item;
        this.count++;

    }

    @Override
    public boolean isEmpty() {

        return count == 0;
    }

    @Override
    public E top() {
        return count == 0 ? null : stack[count - 1];
    }

    @Override
    public E pop() {
        if (count > 1) {
            E temp = stack[count - 1];
            stack[count - 1] = null;
            return temp;
        }
        count--;
        return null;
    }

    public void setStack(int cap) throws Exception {
        if (cap < 1) {

            throw new Exception("capacity must be greater than 0");
        }
        this.stack = (E[]) new Object[cap];
    }

    private void increaseArray() {
        size += 20;
        temp = (E[]) new Object[size];
        for (int i = 0; i < stack.length; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
        temp = null;

    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < count; i++) {
            str += stack[i] + " ";
        }
        return str;
    }

    @Override
    public void addSecond(E Item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
