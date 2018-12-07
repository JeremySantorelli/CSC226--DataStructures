/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_ArrayList;

import assignment1.SparseArrayEntry;
import java.util.Random;

/**
 *
 * @author Jeremy Santorelli
 */
public class NewTest {
    
    public static void main(String[] args) {
        
        System.out.println("Array Lizt Testing\n");
        Lizt<SparseArrayEntry> l = new ArrayLizt<>();
        Random r = new Random();
        for (int i = 0; i < 30; i += 3) {
            l.add(new SparseArrayEntry(i, i, r.nextInt(100) + i));
        }
        System.out.println("Original Array\n");
        System.out.println(l.toString());
        
        Lizt<SparseArrayEntry> everyOther = l.retrieveEveryOtherItem();
        System.out.println("\nEvery Other Array\n");
        System.out.println(everyOther.toString());
        
        l.remove(new SparseArrayEntry(6, 6, null));
        l.remove(new SparseArrayEntry(-1, null, null));
        System.out.println(new SparseArrayEntry(500, 500, null));
        
        System.out.println("\nRemove '(6,6)'\n");
        System.out.println(l.toString());
        
        l.removeAt(-1);
        l.removeAt(0);
        l.removeAt(8);
        l.removeAt(1000);
        
        System.out.println("\nRemove At Index\n");
        System.out.println(l.toString());
        
        l.addToTop(new SparseArrayEntry(8, 6, 75309));
        System.out.println("\nAdd to front of Array\n");
        System.out.println(l.toString());
        
        l.removeFirstTwo();
        System.out.println("\nRemove First Two of Array\n");
        System.out.println(l.toString());
        
        System.out.println("\n\nLinked Lizt Testing\n");
        
        l = new LinkedLizt<>();
        for (int i = 0; i < 30; i += 2) {
            l.add(new SparseArrayEntry(i, i, r.nextInt(100) + i));
        }
        System.out.println("Original Linked\n");
        System.out.println(l.toString());
        
        l.addToTop(new SparseArrayEntry(83, 83, 8675309));
        
        System.out.println("Add Last To Linked\n");
        System.out.println(l.toString());
        
        l.removeFirstTwo();
        System.out.println("Remove First Two Linked\n");
        System.out.println(l.toString());
        
        l.removeAt(3);
        l.removeAt(0);
        l.removeAt(15);
        System.out.println("\nRemove At Index\n");
        System.out.println(l.toString());
        
        l = l.retrieveEveryOtherItem();
        System.out.println("\nEvery Other Linked\n");
        System.out.println(l.toString());
        
    }
    
}
