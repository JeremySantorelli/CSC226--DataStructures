package week1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jeremy Santorelli
 */
public class InClass {

    public static void main(String[] args) {
        int num = 10;
        Integer intObj = 10;
        System.out.println("Sum is = " + (num + intObj));

        int[] arr = new int[3];
        arr[0] = 23;
        int[] arr1 = new int[]{11, 22, 33};
        arr = arr1;//turned int aliases
        arr1[0] = 100;
        System.out.println(arr + "  " + arr1);// shows how reference addresses are stored

        List<String> str = new ArrayList<>();

        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");

        str.add(0, "elements");

        System.out.println(str);

        InClass_Song song = new InClass_Song("Title", "Album", "Artist", new Date());
        song.addDownload();
        System.out.println(song.toString());
        
        InClass_MusicDownload m = new InClass_MusicDownload();

        m.add(song);
        m.downloadTitle("Title");

        System.out.println(m.toString());

    }

}
