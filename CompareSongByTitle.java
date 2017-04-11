package prj5;

import java.util.Comparator;

/**
 * Compare Song By Title
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */
public class CompareSongByTitle implements Comparator<Song> {

    /**
     * 
     * Comparator that sorts strings Used to put songs in a list sorted by Title
     * 
     * in alphabetical order
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

        String title1 = (song1).getTitle();

        String title2 = (song2).getTitle();

        return (title1.compareTo(title2));

    }

}
