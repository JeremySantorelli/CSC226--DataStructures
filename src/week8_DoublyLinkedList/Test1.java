/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8_DoublyLinkedList;

import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author jerem
 */
public class Test1 {

    public static void main(String[] args) {

        SortedDoubllyLinkedList<Integer> dll = new SortedDoubllyLinkedList<>();
        dll.add(10);
        System.out.println(dll.iterateForward());
        dll.add(364);
        System.out.println(dll.iterateForward());
        dll.add(34);
        System.out.println(dll.iterateForward());
        dll.add(56);
        Iterator<Integer> it = dll.iterator();
        System.out.println(dll.iterateForward());

        dll.remove(364);
        System.out.println(dll.iterateForward());
        System.out.println(dll.iterateBackward());

        dll.remove(34);
        System.out.println(dll.iterateForward());
        dll.remove(56);
        System.out.println(dll.iterateForward());
        dll.remove(10);
        System.out.println(dll.iterateForward());
        System.out.println(dll.iterateBackward());

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        DownloadInfo head = new DownloadInfo("Low", -1);
        DownloadInfo tail = new DownloadInfo("High", Integer.MAX_VALUE);

        SortedDoublyLinkedListWithHeaderAndTrailer<DownloadInfo> sdllwhat
                = new SortedDoublyLinkedListWithHeaderAndTrailer<>(
                        head, tail);

        Random r = new Random();

        for (int i = 0; i < 11; i++) {
            sdllwhat.add(new DownloadInfo("track" + i, r.nextInt(4999) + 1));
        }

        sdllwhat.add(new DownloadInfo("Removeable Song", Integer.MAX_VALUE));
        sdllwhat.add(new DownloadInfo("Removeable Song", 3000));
        sdllwhat.add(new DownloadInfo("Removeable Song", 0));

        System.out.println(sdllwhat);

        sdllwhat.remove(new DownloadInfo("Removeable Song", -2));
        System.out.println(sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", Integer.MAX_VALUE));
        System.out.println(sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", 3000));
        System.out.println(sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", 0));
        System.out.println(sdllwhat);

    }

}
