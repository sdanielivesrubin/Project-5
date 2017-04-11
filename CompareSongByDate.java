package prj5;

import java.util.Comparator;

/**
 * Compare Song By Date
 * 
 * @author Yasmine Belghith (byasmine)
 * @version 2016.11.07
 *
 */
public class CompareSongByDate implements Comparator<Song> {

    /**
     * 
     * Comparator that sorts integers and puts them in order least to greatest
     * 
     * (earliest year to latest year)
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

        String date1 = song1.getDate();

        String date2 = song2.getDate();

        return (date1.compareTo(date2));

    }

}
