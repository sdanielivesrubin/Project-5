package prj5;

import list.AList;

/**
 * 
 * Glyph Generator Class takes in a song list and creates Glyph objects based on
 * the percentages from the Song objects in the list
 * 
 * @author Yasmine Belghith (byasmine)
 * 
 * @version 2016.11.07
 * 
 */

public class GlyphGenerator

{

    private SongList<Song> songs;

    private AList<Glyph> glyphsByMajor;

    private AList<Glyph> glyphsByHobby;

    private AList<Glyph> glyphsByState;

    /**
     * Initializes the SongList field, and 3 AList that will store the Glyphs
     * generated based on Major, Hobby and State
     * 
     * @param songList
     *            the SongList passed in
     */
    public GlyphGenerator(SongList<Song> songList)

    {

        songs = songList;

        glyphsByMajor = new AList<Glyph>();

        glyphsByHobby = new AList<Glyph>();

        glyphsByState = new AList<Glyph>();

    }

    /**
     * Returns the SongList
     * 
     * @return songs the SongList
     */
    public SongList<Song> getSongs()

    {

        return songs;

    }

    /**
     * Gets the List of Glyphs by major
     * 
     * @return glyphsByMajor the AList storing the glyphs
     */
    public AList<Glyph> getGlyphsByMajor()

    {

        return glyphsByMajor;

    }

    /**
     * Gets the List of Glyphs by hobby
     * 
     * @return glyphsByHobby the AList storing the glyphs
     */
    public AList<Glyph> getGlyphsByHobby()

    {

        return glyphsByHobby;

    }

    /**
     * Gets the List of Glyphs by state
     * 
     * @return glyphsByState the AList storing the glyphs
     */
    public AList<Glyph> getGlyphsByState()

    {

        return glyphsByState;

    }

    /**
     * Generates Glyphs based on the percentages calculated for the majors and
     * stores them in an AList
     * 
     * @return glyphsByMajor the AList storing the glyphs
     */
    public AList<Glyph> createGlyphsByMajor()

    {

        for (int i = 0; i < songs.size(); i++)

        {

            Song current = songs.get(i);

            int likePercent = current.majorsPercentages[1];

            int heardPercent = current.majorsPercentages[0];

            Glyph currentGlyph = new Glyph();

            currentGlyph.createLikeBar(1, likePercent);

            currentGlyph.createHeardBar(5, heardPercent);

            int likePercent2 = current.majorsPercentages[3];

            int heardPercent2 = current.majorsPercentages[2];

            currentGlyph.createLikeBar(2, likePercent2);

            currentGlyph.createHeardBar(6, heardPercent2);

            int likePercent3 = current.majorsPercentages[5];

            int heardPercent3 = current.majorsPercentages[4];

            currentGlyph.createLikeBar(3, likePercent3);

            currentGlyph.createHeardBar(7, heardPercent3);

            int likePercent4 = current.majorsPercentages[7];

            int heardPercent4 = current.majorsPercentages[6];

            currentGlyph.createLikeBar(4, likePercent4);

            currentGlyph.createHeardBar(8, heardPercent4);

            glyphsByMajor.add(currentGlyph);

        }

        return glyphsByMajor;

    }

    /**
     * Generates Glyphs based on the percentages calculated for the hobbies and
     * stores them in an AList
     * 
     * @return glyphsByHobby the AList storing the glyphs
     */
    public AList<Glyph> createGlyphsByHobby()

    {

        for (int i = 0; i < songs.size(); i++)

        {

            Song current = songs.get(i);

            int likePercent = current.hobbiesPercentages[1];

            int heardPercent = current.hobbiesPercentages[0];

            Glyph currentGlyph = new Glyph();

            currentGlyph.createLikeBar(1, likePercent);

            currentGlyph.createHeardBar(5, heardPercent);

            int likePercent2 = current.hobbiesPercentages[3];

            int heardPercent2 = current.hobbiesPercentages[2];

            currentGlyph.createLikeBar(2, likePercent2);

            currentGlyph.createHeardBar(6, heardPercent2);

            int likePercent3 = current.hobbiesPercentages[5];

            int heardPercent3 = current.hobbiesPercentages[4];

            currentGlyph.createLikeBar(3, likePercent3);

            currentGlyph.createHeardBar(7, heardPercent3);

            int likePercent4 = current.hobbiesPercentages[7];

            int heardPercent4 = current.hobbiesPercentages[6];

            currentGlyph.createLikeBar(4, likePercent4);

            currentGlyph.createHeardBar(8, heardPercent4);

            glyphsByHobby.add(currentGlyph);

        }

        return glyphsByHobby;

    }

    /**
     * Generates Glyphs based on the percentages calculated for the states and
     * stores them in an AList
     * 
     * @return glyphsByState the AList storing the glyphs
     */
    public AList<Glyph> createGlyphsByState()

    {

        for (int i = 0; i < songs.size(); i++)

        {

            Song current = songs.get(i);

            int likePercent = current.statesPercentages[1];

            int heardPercent = current.statesPercentages[0];

            Glyph currentGlyph = new Glyph();

            currentGlyph.createLikeBar(1, likePercent);

            currentGlyph.createHeardBar(5, heardPercent);

            int likePercent2 = current.statesPercentages[3];

            int heardPercent2 = current.statesPercentages[2];

            currentGlyph.createLikeBar(2, likePercent2);

            currentGlyph.createHeardBar(6, heardPercent2);

            int likePercent3 = current.statesPercentages[5];

            int heardPercent3 = current.statesPercentages[4];

            currentGlyph.createLikeBar(3, likePercent3);

            currentGlyph.createHeardBar(7, heardPercent3);

            int likePercent4 = current.statesPercentages[7];

            int heardPercent4 = current.statesPercentages[6];

            currentGlyph.createLikeBar(4, likePercent4);

            currentGlyph.createHeardBar(8, heardPercent4);

            glyphsByState.add(currentGlyph);

        }

        return glyphsByState;

    }

}