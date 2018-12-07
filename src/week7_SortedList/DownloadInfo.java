package week7_SortedList;

import java.util.Comparator;

/**
 *
 * @author Jeremy Santorelli
 */
public class DownloadInfo implements Comparable {

    private final String songName;

    private final String album;
    private int downloads = 0;

    public DownloadInfo(String songName, String album) {
        super();
        this.songName = songName;
        this.album = album;
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

    public void addDownload() {

        this.downloads++;

    }

    private static Comparator<DownloadInfo> downloadComparator
            = new Comparator<DownloadInfo>() {

        @Override
        public int compare(DownloadInfo o1, DownloadInfo o2) {
            return o1.compareTo(o2);
        }

    };

    public static Comparator<DownloadInfo> getDownloadComparator() {
        return downloadComparator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DownloadInfo other = (DownloadInfo) obj;
        return this.downloads == other.downloads;
    }

    @Override
    public int compareTo(Object o) {
        final DownloadInfo other = (DownloadInfo) o;
        int ret;
        if (this.equals(other)) {
            ret = 0;
        } else {
            ret = this.getDownloads() - other.getDownloads();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "SONG = { " + songName
                + ", " + album
                + ", " + downloads + "}";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.downloads;
        return hash;
    }

}
