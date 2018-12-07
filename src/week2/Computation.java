/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

/**
 *
 * @author jerem
 */
public interface Computation<T, S> {//S and T are generic data types
    
    public abstract int doSomething(T t, S s);
    
    
    
}
