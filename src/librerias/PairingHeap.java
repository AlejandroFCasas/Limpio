package librerias;

public class PairingHeap implements PriorityQueue
{    
    /**
     * Construct the pairing heap.
     */
    public PairingHeap( )
    {
        root = null;
        theSize = 0;
    }

    /**
     * Insert into the priority queue, and return a Position
     * that can be used by decreaseKey.
     * Duplicates are allowed.
     * @param x the item to insert.
     * @return the node containing the newly inserted item.
     */
    public PriorityQueue.Position insert( Comparable x )
    {
        PairNode newNode = new PairNode( x );

        if( root == null )
            root = newNode;
        else
            root = compareAndLink( root, newNode );
            
        theSize++;
        return newNode;
    }

    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item.
     * @throws Exception 
     * @throws UnderflowException if pairing heap is empty.
     */
    public Comparable findMin( ) throws Exception
    {
        if( isEmpty( ) )
            throw new Exception( "Pairing heap is empty" );
        return root.element;
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item.
     * @throws Exception 
     * @throws UnderflowException if pairing heap is empty.
     */
    public Comparable deleteMin( ) throws Exception
    {
        if( isEmpty( ) )
            throw new Exception( "Pairing heap is empty" );

        Comparable x = findMin( );
        if( root.leftChild == null )
            root = null;
        else
            root = combineSiblings( root.leftChild );

        theSize--;
        return x;
    }

    /**
     * Change the value of the item stored in the pairing heap.
     * @param pos any Position returned by insert.
     * @param newVal the new value, which must be smaller
     *    than the currently stored value.
     * @throws IllegalArgumentException if pos is null.
     * @throws IllegalValueException if new value is larger than old.
     */
    public void decreaseKey( PriorityQueue.Position pos, Comparable newVal )
    {
        if( pos == null )
            throw new IllegalArgumentException( "null Position passed to decreaseKey" );

        PairNode p = (PairNode) pos;
        
        if( p.element.compareTo( newVal ) < 0 )
            throw new IllegalArgumentException( "newVal/oldval: " + newVal + " /" + p.element );
        p.element = newVal;
        if( p != root )
        {
            if( p.nextSibling != null )
                p.nextSibling.prev = p.prev;
            if( p.prev.leftChild == p )
                p.prev.leftChild = p.nextSibling;
            else
                p.prev.nextSibling = p.nextSibling;

            p.nextSibling = null;
            root = compareAndLink( root, p );
        }
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Returns number of items stored in the priority queue.
     * @return size of the priority queue.
     */
    public int size( )
    {
        return theSize;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
        theSize = 0;
    }
    
    /**
     * Private static class for use with PairHeap.
     */
    private static class PairNode implements PriorityQueue.Position 
    {
        /**
         * Construct the PairNode.
         * @param theElement the value stored in the node.
         */
        public PairNode( Comparable theElement )
        {
            element     = theElement;
            leftChild   = null;
            nextSibling = null;
            prev        = null;
        }

        /**
         * Returns the value stored at this position.
         * @return the value stored at this position.
         */
        public Comparable getValue( )
        {
            return element;
        }
        
            // Friendly data; accessible by other package routines
        public Comparable element;
        public PairNode   leftChild;
        public PairNode   nextSibling;
        public PairNode   prev;
    }

    private PairNode root;
    private int theSize;

    /**
     * Internal method that is the basic operation to maintain order.
     * Links first and second together to satisfy heap order.
     * @param first root of tree 1, which may not be null.
     *    first.nextSibling MUST be null on entry.
     * @param second root of tree 2, which may be null.
     * @return result of the tree merge.
     */
    private PairNode compareAndLink( PairNode first, PairNode second )
    {
        if( second == null )
            return first;

        if( second.element.compareTo( first.element ) < 0 )
        {
            // Attach first as leftmost child of second
            second.prev = first.prev;
            first.prev = second;
            first.nextSibling = second.leftChild;
            if( first.nextSibling != null )
                first.nextSibling.prev = first;
            second.leftChild = first;
            return second;
        }
        else
        {
            // Attach second as leftmost child of first
            second.prev = first;
            first.nextSibling = second.nextSibling;
            if( first.nextSibling != null )
                first.nextSibling.prev = first;
            second.nextSibling = first.leftChild;
            if( second.nextSibling != null )
                second.nextSibling.prev = second;
            first.leftChild = second;
            return first;
        }
    }

    private PairNode [ ] doubleIfFull( PairNode [ ] array, int index )
    {
        if( index == array.length )
        {
            PairNode [ ] oldArray = array;

            array = new PairNode[ index * 2 ];
            for( int i = 0; i < index; i++ )
                array[ i ] = oldArray[ i ];
        }
        return array;
    }
   
        // The tree array for combineSiblings
    private PairNode [ ] treeArray = new PairNode[ 5 ];

    /**
     * Internal method that implements two-pass merging.
     * @param firstSibling the root of the conglomerate;
     *     assumed not null.
     */
    private PairNode combineSiblings( PairNode firstSibling )
    {
        if( firstSibling.nextSibling == null )
            return firstSibling;

            // Store the subtrees in an array
        int numSiblings = 0;
        for( ; firstSibling != null; numSiblings++ )
        {
            treeArray = doubleIfFull( treeArray, numSiblings );
            treeArray[ numSiblings ] = firstSibling;
            firstSibling.prev.nextSibling = null;  // break links
            firstSibling = firstSibling.nextSibling;
        }
        treeArray = doubleIfFull( treeArray, numSiblings );
        treeArray[ numSiblings ] = null;

            // Combine subtrees two at a time, going left to right
        int i = 0;
        for( ; i + 1 < numSiblings; i += 2 )
            treeArray[ i ] = compareAndLink( treeArray[ i ], treeArray[ i + 1 ] );

        int j = i - 2;

            // j has the result of last compareAndLink.
            // If an odd number of trees, get the last one.
        if( j == numSiblings - 3 )
            treeArray[ j ] = compareAndLink( treeArray[ j ], treeArray[ j + 2 ] );

            // Now go right to left, merging last tree with
            // next to last. The result becomes the new last.
        for( ; j >= 2; j -= 2 )
            treeArray[ j - 2 ] = compareAndLink( treeArray[ j - 2 ], treeArray[ j ] );

        return treeArray[ 0 ];
    }

        // Test program
    public static void main( String [ ] args ) throws Exception
    {
        PairingHeap h = new PairingHeap( );
        int numItems = 10000;
        int i = 37;
        int j;

        System.out.println( "Checking; no bad output is good" );
        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
           h.insert( new Integer( i ) );
        for( i = 1; i < numItems; i++ )
            if( ((Integer)( h.deleteMin( ) )).intValue( ) != i )
                System.out.println( "Oops! " + i );

        PriorityQueue.Position [ ] p = new PriorityQueue.Position[ numItems ];
        for( i = 0, j = numItems / 2; i < numItems; i++, j =(j+71)%numItems )
            p[ j ] = h.insert( new Integer( j + numItems ) );
        for( i = 0, j = numItems / 2; i < numItems; i++, j =(j+53)%numItems )
            h.decreaseKey( p[ j ], new Integer( 
                     ((Integer)p[ j ].getValue( )).intValue( ) - numItems ) );
        i = -1;
        while( !h.isEmpty( ) )
            if( ((Integer)( h.deleteMin( ) )).intValue( ) != ++i )
                System.out.println( "Oops! " + i + " " );
        System.out.println( "Check completed" );
    }
}