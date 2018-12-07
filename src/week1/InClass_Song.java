/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.Date;

/**
 *
 * @author jerem
 */
public class InClass_Song implements InClass_Download {

    final int CAP = 10;
    private final String songName;

    private String album, artist;
    private final Date release;
    private int downloads = 0;

    public InClass_Song(String songName, String album, String artist, Date release) {
        this.songName = songName;
        this.album = album;
        this.artist = artist;
        this.release = release;
    }

    public int getDownloads() {
        return downloads;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public Date getRelease() {
        return release;
    }

    @Override
    public void addDownload() {

        if (this.downloads++ < CAP) {
            this.downloads = this.downloads++;
        } else {

            System.out.println("CAP Reached");
        }
    }

    @Override
    public String toString() {
        return "songName: " + songName
                + "\nalbum: " + album
                + "\nartist: " + artist
                + "\nrelease: " + release
                + "\ndownloads: " + downloads;
    }

}
