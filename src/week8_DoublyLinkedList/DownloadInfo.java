package week8_DoublyLinkedList;

import java.util.Comparator;

/**
 *
 * @author Jeremy Santorelli
 */
public class DownloadInfo implements Comparable {

    private final String songName;
    private int downloads = 0;

    public DownloadInfo(String songName, int downloads) {
        super();
        this.songName = songName;
        this.downloads = downloads;
    }

    public int getDownloads() {
        return downloads;
    }

    public String getSongName() {
        return songName;
    }

    private static final Comparator<DownloadInfo> downloadComparator
            = DownloadInfo::compareTo;

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
        return songName + ", " + downloads + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.downloads;
        return hash;
    }
}
