/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6_Queue;



/**
 *
 * @author jerem
 * @param <T>
 */
public class Node<T> {

    private T info;
    private Node<T> link;

    public Node(T info) {
        this.info = info;
        this.link = null;
    }

    public Node(T info, Node<T> link) {
        this.info = info;
        this.link = link;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getLink() {
        return link;
    }

    public void setLink(Node<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", link=" + link + '}';
    }
    
    

}
