package prj5;

import java.util.Comparator;

/**
 * Compare Song By Artist
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */
public class CompareSongByArtist implements Comparator<Song> {

    /**
     * 
     * Comparator that sorts strings in alphabetical order used to put songs in
     * 
     * a list sorted by artist name in alphabetical order
     * 
     * 
     * 
     * @param song1
     * 
     *            first song to be compared
     * 
     * @param song2
     * 
     *            second song to be compared
     * 
     * @return -1, 0, or 1 based on whether song1 comes before song2
     * 
     */
    @Override

    public int compare(Song song1, Song song2)

    {

        String artist1 = song1.getArtist();

        String artist2 = song2.getArtist();

        return (artist1.compareTo(artist2));

    }

}
