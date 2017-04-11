package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * SinglyLinkedListTest class
 * 
 * @author Yasmine Belghith (byasmine)
 * @author Daniel Rubin (danielir)
 * @version 2016.11.07
 */
public class SinglyLinkedListTest extends TestCase
{
    private SinglyLinkedList<Integer> llist;
    private SinglyLinkedList<String>  strList;
    private Song song1;

    /**
     * sets up tests
     */
    public void setUp()
    {
        llist = new SinglyLinkedList<Integer>();
        strList = new SinglyLinkedList<String>();

        song1 = new Song("AA", "AA", "AA", "2001");

        // adding sample elements to test with
        llist.add(1);
        llist.add(3);
        llist.add(5);
        llist.add(6);
        llist.add(7);
        llist.add(1);
        llist.add(2);
    }

    /**
     * tests the size method
     */
    public void testSize()
    {
        assertEquals(7, llist.size());
    }

    /**
     * tests the add2param method
     */
    public void testAdd2Param()
    {
        // null object case
        Integer na = null;
        Exception e = null;
        try
        {
            llist.add(0, na);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
        assertNotNull(e);
        assertEquals("Object is null", e.getMessage());

        // index out of bounds case: index < 0
        Exception t = null;
        try
        {
            llist.add(-1, 5);
        }
        catch (Exception exception)
        {
            t = exception;
        }
        assertTrue(t instanceof IndexOutOfBoundsException);
        assertNotNull(t);
        assertEquals("Index is out of bounds", t.getMessage());

        // index out of bounds case: index > numberOfEntries
        Exception r = null;
        try
        {
            llist.add(10, 5);
        }
        catch (Exception exception)
        {
            r = exception;
        }
        assertTrue(r instanceof IndexOutOfBoundsException);
        assertNotNull(r);
        assertEquals("Index is out of bounds", r.getMessage());

        // adding to a list with numerous entries
        llist.add(5, 2);
        assertEquals(2, llist.get(5).intValue());
        assertEquals(1, llist.get(6).intValue());

        // adding to an empty list
        llist.clear();
        llist.add(0, 10);
        assertEquals(1, llist.size());
        assertEquals(10, llist.get(0).intValue());
    }

    /**
     * tests the add method
     */
    public void testAdd()
    {
        // null object case
        Integer na = null;
        Exception e = null;
        try
        {
            llist.add(na);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
        assertNotNull(e);
        assertEquals("Object is null", e.getMessage());

        // adding to the end of a list
        llist.add(1);
        assertEquals(8, llist.size());

        // adding to an empty list
        llist.clear();
        llist.add(10);
        assertEquals(1, llist.size());
        assertEquals(10, llist.get(0).intValue());
    }

    /**
     * tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertFalse(llist.isEmpty());
        llist.clear();
        assertTrue(llist.isEmpty());
    }

    /**
     * tests the removeEntry method
     */
    public void testRemoveEntry()
    {
        // using a String Linked list so there is no confusion with entering an
        // integer parameter into the remove methods

        // empty case
        assertFalse(strList.remove("hello"));

        // matching firstNode
        strList.add("hello");
        assertTrue(strList.remove("hello"));
        assertTrue(strList.isEmpty());

        // list of 2+ entries
        strList.add("hello");
        strList.add("hello2");
        strList.add("hello3");
        strList.add("hello4");
        strList.add("hello5");
        assertTrue(strList.remove("hello4"));
        assertEquals(4, strList.size());
        
        setUp();
        
        // list of 2 entries
        strList.add("hello");
        strList.add("hello2");
        assertTrue(strList.remove("hello2"));
        assertEquals(1, strList.size());
        
        setUp();
        
        // list of 2 entries one null
        strList.add("hello");
        assertTrue(strList.remove("hello"));
        assertEquals(0, strList.size());


        
        
        
    }

    /**
     * tests the removeIndex method
     */
    public void testRemoveIndex()
    {
        // for indices < 0
        Exception e = null;
        try
        {
            strList.remove(-1);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        assertNotNull(e);
        assertEquals("Index is out of bounds", e.getMessage());

        // when firstNode == null
        Exception t = null;
        try
        {
            strList.remove(1);
        }
        catch (Exception exception)
        {
            t = exception;
        }
        assertTrue(t instanceof IndexOutOfBoundsException);
        assertNotNull(t);
        assertEquals("Index is out of bounds", t.getMessage());

        // removing the front
        strList.add("hello");
        assertTrue(strList.remove(0));
        assertTrue(strList.isEmpty());

        // removing from a list of strings
        strList.add("hello");
        strList.add("hello2");
        strList.add("hello3");
        strList.add("hello4");
        strList.add("hello5");
        assertTrue(strList.remove(3));

        // removing when index > size
        Exception r = null;
        try
        {
            strList.remove(15);
        }
        catch (Exception exception)
        {
            r = exception;
        }
        assertTrue(r instanceof IndexOutOfBoundsException);
        assertNotNull(r);
        assertEquals("Index is out of bounds", r.getMessage());
    }

    /**
     * tests the get method
     */
    public void testGet()
    {
        // for indices that return null data
        Exception e = null;
        try
        {
            llist.get(10);
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        assertNotNull(e);
        assertEquals("Index exceeds the numberOfEntries.", e.getMessage());

        assertEquals(7, llist.get(4).intValue());
        llist.remove(4);
        assertEquals(1, llist.get(4).intValue());
    }

    /**
     * tests the contains method
     */
    public void testContains()
    {
        assertTrue(llist.contains(1));
        assertFalse(llist.contains(100));
    }

    /**
     * tests the lastIndexOf method
     */
    public void testLastIndexOf()
    {
        assertEquals(-1, llist.lastIndexOf(100));
        assertEquals(5, llist.lastIndexOf(1));
    }

    /**
     * tests the toString method
     */
    public void testToString()
    {
        strList.add("hello1");
        strList.add("hello2");
        strList.add("hello3");
        strList.add("hello4");
        assertEquals("{hello1, hello2, hello3, hello4}", strList.toString());
    }


    /**
     * tests the toArray method
     */
    public void testToArray()
    {
        Song[] songArray = new Song[1];
        songArray[0] = song1;
        SinglyLinkedList<Song> llist2 = new SinglyLinkedList<Song>();
        llist2.add(song1);       
        
        assertTrue(Arrays.equals(songArray, llist2.toArray()));
    }


    /**
     * tests the iterate method
     */
    public void testIterate() //this test fails at line 290
    {
        Iterator<Integer> iterate = llist.iterator();
        assertTrue(iterate.hasNext());
        assertEquals(1, iterate.next().intValue());
        assertEquals(3, iterate.next().intValue());

        // when iterator is at end of list
        llist.clear();
        Iterator<Integer> iterate2 = llist.iterator();
        Exception e = null;
        try
        {
            iterate2.next();
        }
        catch (Exception exception)
        {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
        assertNotNull(e);
        assertEquals("Illegal call to next(); "
            + "iterator is after end of list.", e.getMessage());
    }
    
    
    
    /**
     * tests the clear method
     */
    public void testClear()
    {
        assertFalse(llist.isEmpty());
        
        llist.clear();
        assertTrue(llist.isEmpty());
        
        llist.clear();
        assertTrue(llist.isEmpty());        
    }
    
    
    
    
}
