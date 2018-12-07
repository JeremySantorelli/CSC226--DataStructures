package week8_DoublyLinkedList;

import java.util.Random;

/**
 * Test class for Chapter 7 assignment
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String a[]) {
        //QUESTION 1 TEST        
        DownloadInfo head = new DownloadInfo("Low", -1);
        DownloadInfo tail = new DownloadInfo("High", Integer.MAX_VALUE);
        SortedDoublyLinkedListWithHeaderAndTrailer<DownloadInfo> sdllwhat
                = new SortedDoublyLinkedListWithHeaderAndTrailer<>(
                        head, tail);//PART 1 << CONSTRUCTOR WITH DUMMY NODES
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            sdllwhat.add(new DownloadInfo("track" + i, r.nextInt(4999) + 1));
        }
        sdllwhat.add(new DownloadInfo("Removeable Song1", -5));//PART 2
        sdllwhat.add(new DownloadInfo("Removeable Song1", Integer.MAX_VALUE));
        sdllwhat.add(new DownloadInfo("Removeable Song2", 3000));
        sdllwhat.add(new DownloadInfo("Removeable Song3", 0));
        System.out.println("SONGS\n" + sdllwhat);//PART 2
        sdllwhat.remove(new DownloadInfo("Removeable Song", -5));//PART 2
        System.out.println("SONGS >> Remove -2 downloads\n" + sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", Integer.MAX_VALUE));
        System.out.println("SONGS >> remove MAX_INT download\n" + sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", 3000));
        System.out.println("SONGS >> remove 3000 download\n" + sdllwhat);
        sdllwhat.remove(new DownloadInfo("Removeable Song", 0));
        System.out.println("SONGS >> remove minimum download\n" + sdllwhat);

        //QUESTION 2 TEST
        SortedDoubllyLinkedList<Integer> dll = new SortedDoubllyLinkedList<>();
        dll.add(10);
        dll.add(364);
        dll.add(34);
        dll.add(56);
        dll.remove(364);
        System.out.println("forward" + dll.iterateForward());
        System.out.println("reverse" + dll.iterateBackward());
        dll.remove(34);
        System.out.println("forward" + dll.iterateForward());
        dll.remove(56);
        System.out.println("forward" + dll.iterateForward());
        dll.remove(10);
        System.out.println("forward" + dll.iterateForward());
        System.out.println("reverse" + dll.iterateBackward());
    }
}
