package week7_SortedList;

import java.util.Random;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {
        SortedArrayList<Integer> aList = new SortedArrayList<>(20);
        LinkedSortedList<Integer> lList = new LinkedSortedList<>();

        //Test for noEntry
        aList.removeAll(2);
        lList.removeAll(2);

        //QUESTION 1 TEST
        System.out.println("ARRAY LIST\n\n");
        aList.add(7);
        aList.add(5);
        aList.add(3);
        aList.add(5);
        aList.add(2);
        aList.add(5);

        System.out.println(aList);
        aList.removeAll(9);
        System.out.println(aList + " Remove 9");
        aList.removeAll(5);
        System.out.println(aList + " Remove 5");
        aList.add(1);
        aList.add(3);
        aList.add(1);
        aList.add(9);
        aList.add(1);
        System.out.println(aList);
        aList.removeAll(1);
        System.out.println(aList + " Remove 1");
        aList.removeAll(9);
        System.out.println(aList + " Remove 9");
        //QUESTION 2 TEST
        aList.removeAllbutOne(3);
        System.out.println(aList + " Remove all but one 3");
        aList.removeAllbutOne(2);
        System.out.println(aList + " Remove all but one 2");
        aList.add(1);
        aList.add(3);
        aList.add(1);
        aList.add(9);
        aList.add(1);
        System.out.println(aList);
        aList.removeAllbutOne(1);
        System.out.println(aList + " Remove all but one 1");

        //QUESTION 1 TEST
        System.out.println("\n\nLINKED LIST\n\n");
        lList.add(4);
        lList.add(3);
        lList.add(4);
        lList.add(9);
        lList.add(4);
        lList.add(2);
        lList.add(4);
        lList.add(1);
        lList.add(4);
        System.out.println(lList);
        lList.removeAll(1);
        System.out.println(lList + " Remove 1");
        lList.removeAll(9);
        System.out.println(lList + " Remove 9");
        lList.removeAll(4);
        System.out.println(lList + " Remove 4");
        lList.removeAll(2);
        System.out.println(lList + " Remove 2");
        lList.removeAll(3);
        System.out.println(lList + " Remove 3");
        lList.removeAll(100);

        //QUESTION 2 TEST
        lList.add(4);
        lList.add(3);
        lList.add(4);
        lList.add(9);
        lList.add(4);
        lList.add(2);
        lList.add(4);
        lList.add(1);
        lList.add(4);
        System.out.println(lList);
        lList.removeAllButOne(4);
        System.out.println(lList + " Remove all but one 4");
        lList.removeAllButOne(3);
        System.out.println(lList + " Remove all but one 3");
        lList.removeAllButOne(9);
        System.out.println(lList + " Remove all but one 9");
        lList.removeAllButOne(1);
        System.out.println(lList + " Remove all but one 1\n\n\n");

        //Question 3
        SortedArrayList<DownloadInfo> dIList
                = new SortedArrayList<>(
                        20, DownloadInfo.getDownloadComparator());
        for (int i = 'A'; i <= 'T'; i++) {
            dIList.add(new DownloadInfo("Song "
                    + (i - 'A' + 1), "album " + (char) i));
        }

        System.out.println(dIList + "\n\n");
        Random r = new Random();
        for (int i = 0; i < 20000; i++) {
            dIList.get(r.nextInt(20)).addDownload();
        }
        System.out.println(dIList);
    }

}
