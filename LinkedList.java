package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SinglyLinkedList class
 * 
 * @author Yasmine Belghith (byasmine)
 * @author Daniel Rubin (danielir)
 * @version 2016.11.07
 */
public class SinglyLinkedList<T> implements LList<T>
{

    private int     numberOfEntries;
    private Node<T> firstNode;


    /**
     * instantiates firstNode and numberOfEntries for a new LinkedList
     */
    public SinglyLinkedList()
    {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * returns the number of entries in this Linked List
     * 
     * @return the number of entries of the list
     */
    public int size()
    {
        return numberOfEntries;

    }


    /**
     * adds a new Node to the Linked list at a specified index with data of
     * newEntry. Should throw exceptions if the data is null or if our index is
     * out of bounds
     */
    public void add(int index, T newEntry)
    {
        if (newEntry == null) // check if the newEntry object is null
        {
            throw new IllegalArgumentException("Object is null");
        }

        if ((index < 0) || (index > size())) // check if the index is out of
                                             // bounds
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = firstNode;

        if (isEmpty()) // empty List case
        {
            firstNode = new Node<T>(newEntry);
        }

        else // all other cases
        {
            int currentIndex = 0;
            while (current != null)
            {
                if ((currentIndex + 1) == index)
                {
                    Node<T> nextNext = current.next;
                    Node<T> newNode = new Node<T>(newEntry);
                    current.setNext(newNode);
                    newNode.setNext(nextNext);

                }
                current = current.getNext();
                currentIndex++;
            }
        }
        numberOfEntries++;
    }


    /**
     * add a new Node to the linked list at the end of the list
     */
    public void add(T newEntry)
    {
        if (newEntry == null) // check if the newEntry object is null
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = firstNode;

        // empty stack case
        if (isEmpty())
        {
            firstNode = new Node<T>(newEntry);
        }

        // other cases
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<T>(newEntry));
        }
        numberOfEntries++;
    }


    /**
     * checks if our list is empty
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }


    /**
     * remove an entry from the end of the list
     */
    public boolean remove(T entry)
    {
        Node<T> current = firstNode;

        // account for matching firstNode
        if ((null != firstNode) && (entry.equals(current.data)))
        {
            firstNode = firstNode.next;
            numberOfEntries--;
            return true;
        }

        // account for 2+ numberOfEntries
        while (size() >= 2 && (current.next != null))
        {
            if ((entry.equals(current.next.data)))
            {
                if (current.next.next != null)
                {
                    current.setNext(current.next.next);
                }
                numberOfEntries--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * removes an element from the list at a specific index
     */
    public boolean remove(int index)
    {
        // // if the index is invalid
        if (index < 0 || firstNode == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else
        {

            Node<T> current = firstNode;
            int currentIndex = 0;

            // account for 1 numberOfEntries
            if ((index == 0))
            {
                firstNode = firstNode.next;
                numberOfEntries--;
                return true;
            }

            // account for 2+ numberOfEntries
            while (current.next != null)
            {
                if ((currentIndex + 1) == index)
                {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    numberOfEntries--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * returns an element in the list at a specified index
     */
    public T get(int index)
    {
        Node<T> current = firstNode;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null)
        {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException(
                "Index exceeds the numberOfEntries.");
        }
        return data;
    }


    /**
     * testing if the list contains a certain object
     */
    public boolean contains(T entry)
    {
        Node<T> current = firstNode;
        while (current != null)
        {
            if (entry.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * clears the list
     */
    public void clear()
    {
        // make sure we don't call clear on an empty list
        if (firstNode != null)
        {
            firstNode.setNext(null);
            firstNode = null;
            numberOfEntries = 0;
        }
    }


    /**
     * searches for an entry and returns the last index it occurred at if we did
     * find it
     */
    public int lastIndexOf(T entry)
    {
        int lastIndex = -1;
        Node<T> current = firstNode;
        int currentIndex = 0;
        while (current != null)
        {
            if (entry.equals(current.getData()))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * toString - makes a string for the SinglyLinkedList
     * @return string representation of list
     */
    public String toString()
    {
        String result = "{";

        Node<T> current = firstNode;
        while (current != null)
        {
            result += "" + current.getData();
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
    
    
    /**
     * toArray
     * @return an array of the songs in the list
     */
    public Song[] toArray()
    {
        Song[] arr = new Song[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++)
        {
            arr[i] = (Song)this.get(i);
        }
        return arr;
    }


    /**
     * Private Node class
     * 
     * @author Yasmine Belghith (byasmine)
     * @version 2016.11.07
     * @param <E>
     *            the generic type passed in
     */
    private class Node<E>
    {
        protected Node<E> next;
        private E         data;


        public Node(E e)
        {
            data = e;
        }


        public Node<E> getNext()
        {
            return next;
        }


        public E getData()
        {
            return data;
        }


        public void setNext(Node<E> node)
        {
            next = node;
        }
    }


    /**
     * Implements the song list iterator to iterate over songs
     */
    @SuppressWarnings("unused")
    private class LinkedListIterator implements Iterator<T>
    {

        private int     nextPosition;
        private Node<T> currentSong = firstNode;


        public LinkedListIterator()
        {
            nextPosition = 0;
        }


        /**
         * Implements the song list iterator to iterate over songs hasNext
         */
        public boolean hasNext()
        {
            return currentSong.next != null;
        }


        /**
         * Implements the song list iterator to iterate over songs next
         */
        public T next()
        {
            if (hasNext())
            {
                Node<T> returnNode = currentSong;
                currentSong = currentSong.next;
                nextPosition++;
                return (T)returnNode.getData();

            }
            else
            {
                throw new NoSuchElementException("Illegal call to next(); "
                    + "iterator is after end of list.");
            }
        }

    }
}
