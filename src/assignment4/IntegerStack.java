/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;


/**
 *
 * @author jerem
 */
public final class IntegerStack<E> implements Stack<E> {

    private E[] stack;
    private int count = 0;

    public IntegerStack(int size) throws Exception {
        setStack(size);
    }

    @Override
    public void push(E item) {
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
    public void pop() {
        if (count > 1) {
            stack[count - 1] = null;
        }
        count--;
    }

    public void setStack(int cap) throws Exception {
        if (cap < 1) {

            throw new Exception("capacity must be greater than 0");
        }
        this.stack = (E[]) new Object[cap];
    }

    @Override
    public String toString() {

        String str = "";

        for (int i = 0; i < count; i++) {
            str += stack[i] + " ";
        }
        return str;
    }

    public int getCount() {
        return count;
    }        

}
