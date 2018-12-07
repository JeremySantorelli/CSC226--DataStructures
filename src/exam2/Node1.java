/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import week3_ArrayList.*;

/**
 *
 * @author jerem
 * @param <T>
 */
public class Node1<T> {

    private T info;
    private Node1<T> link;

    public Node1(T info) {
        this.info = info;
        this.link = null;
    }

    public Node1(T info, Node1<T> link) {
        this.info = info;
        this.link = link;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node1<T> getLink() {
        return link;
    }

    public void setLink(Node1<T> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", link=" + link + '}';
    }
    
    

}
