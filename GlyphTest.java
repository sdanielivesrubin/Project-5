package prj5;

import student.TestCase;

/**
 * Test for Glyph class
 * 
 * @author Yasmine Belghith (byasmine)
 * @author Eirik Iversen (eiriki)
 * @version 2016.11.10
 */
public class GlyphTest extends TestCase
{

    Glyph glyph;


    /**
     * Sets up test methods
     */
    public void setUp()
    {
        glyph = new Glyph();
    }


    /**
     * Test getShapes method, which should return an array of shapes with length
     * 9 because we initialized it in the constructor
     */
    public void testGetShapes()
    {
        assertEquals(9, glyph.getShapes().length);
    }


    public void testCreateLikeBar()
    {
        glyph.createLikeBar(1, 50);
        assertEquals(50, glyph.getShapes()[1].getWidth());
        glyph.createLikeBar(2, 51);
        assertEquals(51, glyph.getShapes()[2].getWidth());
        glyph.createLikeBar(3, 52);
        assertEquals(52, glyph.getShapes()[3].getWidth());
        glyph.createLikeBar(4, 53);
        assertEquals(53, glyph.getShapes()[4].getWidth());
        Exception exception = null;
        try
        {
            glyph.createLikeBar(5, 2);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("Cannot find the right position", exception.getMessage());
    }


    public void testCreateHeardBar()
    {
        glyph.createHeardBar(5, 50);
        assertEquals(50, glyph.getShapes()[5].getWidth());
        glyph.createHeardBar(6, 51);
        assertEquals(51, glyph.getShapes()[6].getWidth());
        glyph.createHeardBar(7, 52);
        assertEquals(52, glyph.getShapes()[7].getWidth());
        glyph.createHeardBar(8, 53);
        assertEquals(53, glyph.getShapes()[8].getWidth());
        Exception exception = null;
        try
        {
            glyph.createHeardBar(1, 2);
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("Cannot find the right position", exception.getMessage());
    }
}
