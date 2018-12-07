/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jeremy Santorelli
 */
public class InClass_MusicDownload {

    private List<InClass_Song> songs;

    public InClass_MusicDownload() {
        this.songs = new ArrayList<>();
    }

    public List<InClass_Song> getSongs() {
        return songs;
    }

    public int removeSongByTitle(String title) {
        int removed = 0;
        for (InClass_Song s : songs) {
            if (s.getSongName().equals(title)) {

                songs.remove(s);
                removed++;

            }
        }
        return removed;
    }

    public void add(InClass_Song song) {

        songs.add(song);
    }

    public void downloadTitle(String t) {

        for (int i = 0; i < songs.size(); i++) {

            if (songs.get(i).getSongName().equals(t)) {
                System.out.println("downloading");
                songs.get(i).addDownload();
            } else {
                System.out.println("Title Does not exist");
            }
        }

    }

//    public static void main(String[] args) {
//        InClass_MusicDownload m = new InClass_MusicDownload();
//
//        m.add(new InClass_Song("Title", "Album", "Artist", new Date()));
//
//        System.out.println(m.toString());
//
//    }
    @Override
    public String toString() {

        String str = "";

        for (InClass_Song s : songs) {

            str += s.getSongName() + "\n" + s.getArtist()
                    + "\n" + s.getAlbum()
                    + "\n" + s.getRelease().toString()
                    + "\n" + s.getDownloads() + "\n\n";

        }
        return str;
    }

}
