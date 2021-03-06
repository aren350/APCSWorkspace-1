import java.util.Iterator;


/**
 * Implements a singly-linked list.
 * 
 * @author Jessica Jiang
 * @version December 12, 2014
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * @author Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;

    private int nodeCount;


    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }


    /**
     * Constructor: creates a list that contains all elements from the array
     * values, in the same order
     * 
     * @param values
     *            array containing all elements for this list
     */
    public SinglyLinkedList( E[] values )
    {
        ListNode<E> tail = null;
        for ( E value : values ) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>( value, null );
            if ( head == null )
                head = node;
            else
                tail.setNext( node );
            tail = node; // update tail
        }

        nodeCount = values.length;
    }


    /**
     * Return true if this list is empty; otherwise returns false.
     * 
     * @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return nodeCount == 0;
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }


    /**
     * Returns true if this list contains an Object equal to obj; otherwise
     * returns false.
     * 
     * @return true if this list contains an Object equal to obj
     */
    public boolean contains( Object obj )
    {
        return indexOf( obj ) >= 0;
    }


    /**
     * Returns the index of the first Object equal to obj; if not found, returns
     * -1.
     * 
     * @param obj
     *            Object to find
     * @return the index of the first Object in equal to obj; if not found,
     *         returns -1.
     */
    public int indexOf( Object obj )
    {
        int count = 0;
        SinglyLinkedListIterator a = new SinglyLinkedListIterator( head );

        while ( a.hasNext() )
        {
            if ( a.next().equals( obj ) )
            {
                return count;
            }

            count++;
        }

        return -1;
    }


    /**
     * Adds obj to this collection. Returns true if successful; otherwise
     * returns false.
     * 
     * @param obj
     *            element to add to this collection
     * @return true if successful; otherwise returns false.
     */
    public boolean add( E obj )
    {
        if ( nodeCount == 0 )
        {
            head = new ListNode<E>( obj, null );
            nodeCount++;
            return true;
        }
        ListNode<E> node = head;
        while ( node.getNext() != null )
        {
            node = node.getNext();
        }
        node.setNext( new ListNode<E>( obj, null ) );
        nodeCount++;
        return true;
    }


    /**
     * Removes the first element that is equal to obj, if any. Returns true if
     * successful; otherwise returns false.
     * 
     * @param obj
     *            element to remove
     * @return true if successful; otherwise returns false.
     */
    public boolean remove( E obj )
    {
        ListNode<E> orig = head;

        if ( nodeCount == 0 )
        {
            return false;
        }
        else if ( nodeCount == 1 )
        {
            if ( orig.equals( obj ) )
            {
                head = null;
                nodeCount = 0;
                return true;
            }
            else
            {
                return false;
            }
        }
        else

        {
            ListNode<E> last = head.getNext();
            for ( int count = 1; nodeCount - 1 > count; count++ )
            {
                if ( last.getValue().equals( obj ) )
                {
                    if ( last.getNext() != null )
                    {
                        head = new ListNode<E>( (E)orig, last );
                    }
                    else
                    {
                        last.setValue( null );
                    }
                    nodeCount--;
                    return true;
                }
                orig = orig.getNext();
                last = last.getNext();
            }
            return false;
        }
    }


    /**
     * Returns the i-th element.
     * 
     * @param i
     *            element to get from the list
     * @return element at index i
     * @throws IndexOutOfBoundsException
     */
    public E get( int i )
    {
        
        /**try
        {
            int count = 0;
            E result = null;

            for ( ListNode<E> node = head; node != null; node = node.getNext(), count++ )
            {
                if ( count == i )
                {
                    result = node.getValue();
                }
            }
            return result;
        }
        catch ( IndexOutOfBoundsException e )
        {
            return null;
        }
        */
        SinglyLinkedListIterator a = new SinglyLinkedListIterator( head );
        int count = i;

        if ( i > this.size() )
        {
            throw new IndexOutOfBoundsException();
        }
        while ( a.hasNext() )
        {
            E obj = (E)a.next();
            if ( count == 0 )
            {
                return obj;
            }
            count--;
        }

        throw new IndexOutOfBoundsException();
    }


    /**
     * Replaces the i-th element with obj and returns the old value.
     * 
     * @param i
     *            index of element to replace
     * @param obj
     *            replacement element of element at index i
     * @return old value previously located at index i
     * @throws IndexOutOfBoundsException
     */
    public E set( int i, E obj )
    {
        /**
        try
        {
            int count = 0;
            E result = null;

            for ( ListNode<E> node = head; node != null; node = node.getNext(), count++ )
            {
                if ( count == i )
                {
                    result = node.getValue();
                    node.setValue( obj );
                    // return result;
                }
            }
        }
        catch ( IndexOutOfBoundsException e )
        {
            return null;
        }
        return result;
        */
        SinglyLinkedListIterator a = new SinglyLinkedListIterator( head );
        int count = i;

        if ( i > this.size() )
        {
            throw new IndexOutOfBoundsException();
        }
        while ( a.hasNext() )
        {
            E prev = (E)a.next();
            if ( count == 0 )
            {
                head.setValue( obj );
                return prev;
            }
            count--;
        }

        throw new IndexOutOfBoundsException();

    }


    /**
     * Inserts obj to become the i-th element. Increments the size of the list
     * by one.
     * 
     * @param i
     *            insertion point in list for obj
     * @param obj
     *            element to insert into list
     * @throws IndexOutOfBoundsException
     */
    public void add( int i, E obj )
    {
        ListNode<E> tempNode = new ListNode<E>( obj, null );
        if ( head == null && i == 0 )
        {
            head = tempNode;
            nodeCount++;
        }
        else if ( nodeCount == 1 )
        {
            if ( i == 0 )
            {
                ListNode<E> prevHead = head;
                tempNode.setNext( prevHead );
                head = tempNode;
            }
            else if ( i == 1 )
            {
                head.setNext( tempNode );
            }
            nodeCount++;
        }
        else if ( i >= 0 )
        {
            ListNode<E> node = head;
            ListNode<E> prevNode = node;
            for ( int y = 0; y < i; y++ )
            {
                if ( node.getNext() != null )
                {
                    prevNode = node;
                    node = node.getNext();
                }
                else
                {
                    throw new IndexOutOfBoundsException();
                }
            }
            tempNode.setNext( node );
            prevNode.setNext( tempNode );
            nodeCount++;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    


    /**
     * Removes the i-th element and returns its value. Decrements the size of
     * the list by one.
     * 
     * @param i
     *            index of element to remove
     * @return element removed from this list
     */
    public E remove( int i )
    {
        ListNode<E> tempNode = head;
        if ( nodeCount == 0 || i >= nodeCount || i < 0 )
        {
            throw new IndexOutOfBoundsException();
        }

        int count = 1;
        ListNode<E> after = head.getNext();
        if ( i == 0 )
        {
            Object obj1 = tempNode.getValue();
            if ( after.getValue() != null )
            {
                ListNode<E> afterA = head.getNext().getNext();
                head = new ListNode<E>( after.getValue(), afterA );
            }
            else
            {
                head = null;
            }
            nodeCount--;
            return (E)obj1;
        }

        for ( count = 1; count <= i; count++ )
        {
            if ( count == i )
            {
                tempNode = tempNode.getNext().getNext();
                Object obj = after.getValue();
                if ( tempNode == null )
                {
                    after.setValue( null );
                    nodeCount--;
                    return (E)obj;
                }
                else
                {
                    head = new ListNode<E>( tempNode.getValue(),
                        (ListNode<E>)after.getNext().getValue() );
                    nodeCount--;
                    return (E)obj;
                }
            }

            tempNode = tempNode.getNext();
            after = after.getNext();
        }
        return null;
    }


    /**
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String result = "[";

        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            result += node.getValue().toString();

            if ( node.getNext() != null )
            {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }


    /**
     * Returns an iterator for this collection.
     * 
     * @return an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>( head );
    }
}
