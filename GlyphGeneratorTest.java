package prj5;

import student.TestCase;

/**
 * 
 * Glyph Generator test class
 * 
 * 
 * 
 * @author Yasmine Belghith (byasmine)
 * 
 * @version 2016.11.10
 * 
 */

public class GlyphGeneratorTest extends TestCase

{

    private SongList<Song> songs;

    private GlyphGenerator generator;

    /**
     * Sets up all test methods
     */
    public void setUp()

    {

        songs = new SongList<Song>();

        Song song = new Song("Banana Pancakes", "Jack Johnson", "Accoustic",

                "2008");

        song.updateHeardMajors("Computer Science");

        song.updateLikeMajors("Computer Science");

        Song song1 = new Song("Billie Jean", "Michael Jackson", "Pop", "1997");

        song1.updateHeardHobbies("read");

        song1.updateLikeHobbies("read");

        Song song2 = new Song("Fallout", "Alter Bridge", "Hard Rock", "2010");

        song2.updateHeardStates("Northeast");

        song2.updateLikeStates("Northeast");

        songs.add(song);

        songs.add(song1);

        songs.add(song2);

        generator = new GlyphGenerator(songs);

    }

    /**
     * Tests the createGlyphsByMajor method
     */
    public void testCreateGlyphsByMajor()

    {

        System.out.println(songs.size() + 1);

        System.out.println(songs.toString());

        System.out.println(generator.getGlyphsByMajor());

        assertEquals(3, generator.createGlyphsByMajor().getLength());

    }

    /**
     * Tests the createGlyphsByHobbies method
     */
    public void testCreateGlyphsByHobbies()

    {

        assertEquals(3, generator.createGlyphsByHobby().getLength());

    }

    /**
     * Tests the createGlyphsByState method
     */
    public void testCreateGlyphsByState()

    {

        assertEquals(3, generator.createGlyphsByState().getLength());

    }

}