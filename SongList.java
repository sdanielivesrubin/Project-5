package prj5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Song List Class stores Song objects
 * 
 * @author Yasmine Belghith (byasmine)
 * @author Daniel Rubin (danielir)
 * @version 2016.11.07
 * @param <T>
 */

public class SongList<T> extends SinglyLinkedList<T>
{

    /**
     * Constructor calls the constructor of the SinglyLinkedList class
     */

    public SongList()

    {
        super();
    }


    /**
     * creates an array from this SongList sorts the array given the input
     * comparator clears this list adds elements back to this list from the
     * array in specified order
     * 
     * @param comparator
     *            the comparator to be used for comparing elements
     */

    @SuppressWarnings("unchecked")

    public void sort(Comparator<Song> comparator)

    {

        Song[] arrayToSort = (Song[])super.toArray();

        Arrays.sort(arrayToSort, comparator);

        this.clear();

        for (int i = 0; i < arrayToSort.length; i++)

        {

            this.add(i, (T)arrayToSort[i]);

        }

    }


    /**
     * Creates a sorted song list in alphabetical order by Title
     * 
     */

    public void sortByTitle()

    {

        Comparator<Song> titleComparator = new CompareSongByTitle();

        sort(titleComparator);

    }


    /**
     * Creates a sorted song list in alphabetical order by Artist
     * 
     */

    public void sortByArtist()

    {

        Comparator<Song> artistComparator = new CompareSongByArtist();

        sort(artistComparator);

    }


    /**
     * Creates a sorted song list in alphabetical order by Genre
     * 
     */

    public void sortByGenre()

    {

        Comparator<Song> genreComparator = new CompareSongByGenre();

        sort(genreComparator);

    }


    /**
     * Creates a sorted song list in alphabetical order by Date (earliest to
     * latest)
     */

    public void sortByDate()

    {

        Comparator<Song> dateComparator = new CompareSongByDate();

        sort(dateComparator);

        this.toString();

    }


    /**
     * Prints the Song List
     * 
     * @return the compiled toString of all of the songs in the list
     */

    public String toString()

    {

        Iterator<T> iter = this.iterator();

        StringBuilder sb = new StringBuilder();

        Song song;

        while (iter.hasNext())

        {
            song = (Song)iter.next();
            sb.append(song.toString());
        }
        return sb.toString();

    }


}
