package verkettete.liste;
import java.util.Random;

public class List {
    ListElement head;
    public List() { this.head = null; }
    public List( ListElement head_ ) { this.head = head_; }
    public ListElement getHead() { return this.head; }
    
    public void createList( int elements )
    {
        Random random = new Random();
        for(int i = 0; i <= elements; i++)
        {
            ListElement newElement = new ListElement(random.nextInt(500));
            this.addElement( newElement );
        }
    }
    
    public void setHead( ListElement head_ ) { this.head = head_; }
    
    
    public void addElement( int container_ )
    {
        ListElement newElement = new ListElement( container_ );
        this.addElement( newElement );
    }
    
    public void addElement( ListElement element_ )
    {
        ListElement lastElement = this.getLast( );
        if( lastElement == null ) {
            this.head = element_;
        }
        else {
            lastElement.setNext( element_ );
            element_.setLast( lastElement );
        }
    }
    
    public ListElement getElement( int element_ ){
        ListElement returnElement = this.getHead();
        for( int i = 0; i != element_; i++ ) {
            returnElement = returnElement.getNext();
            System.out.println(i);
        }
        return returnElement;
    }
    
    public ListElement getLast( List list_ ) 
    {
        ListElement element = list_.head;
        
        if( element == null ) { return null; }
        
        while( element.getNext() != null ) {
            element = element.getNext();
        }

        return element;
    }
    
    public ListElement getLast() 
    {
        ListElement element = this.getHead();
        if( element == null ) { 
            return null;
        }
        while( element.getNext() != null ) {
            element = element.getNext();
        }
        return element;
    }
    
    public void printList() 
    {
        ListElement print = this.head;
        int i = 1; 
        while( print.getNext() != null ) {
            System.out.println( "Listnode: "+ i +" Content: "+print.getContainer() );
            print = print.getNext();
            i++;
        }
    }
    
    // Recursive Merge Sort
    public List mergeSort( List list_ )
    {
       if( list_.length() <= 1 ) {
           return list_;
       } 
       List left = list_.split( "left" );
       List right = list_.split( "right" );

       left = mergeSort( left );
       right = mergeSort ( right );
       return merge( left, right );
       
    }
    
    public List merge( List left_, List right_ )
    {
        List mergedList = new List();
        int i = 0;
        while( left_.getHead() != null && right_.getHead() != null ) {
            if( left_.getHead().getContainer() <= right_.getHead().getContainer() ) {
                mergedList.addElement( left_.getHead().getContainer() );
                left_.setHead( left_.getHead().getNext() );
                }
            else {
                mergedList.addElement( right_.getHead().getContainer() );
                right_.setHead( right_.getHead().getNext() );
            }
        }
        
        while( left_.getHead() != null ) {
            mergedList.addElement( left_.getHead().getContainer() );
            left_.setHead( left_.getHead().getNext() );
        }
        
        while( right_.getHead() != null ) {
            mergedList.addElement( right_.getHead().getContainer() );
            right_.setHead( right_.getHead().getNext() );
        }
        
        return mergedList;
    }
    
    public int length( )
    {
        if( this.getHead() == null ) {
            return 0;
        }
       
        ListElement counter = this.getHead();
        int length = 1; 
        while( counter.getNext() != null ) {
            length++;
            counter = counter.getNext();
        }
        return length;
    }
    
    @SuppressWarnings("ConvertToStringSwitch")
    public List split( String side_ ) 
    {   
        List splitList = getList();
        List returnList = new List();
        
        switch( side_ ) {
            case "left":
                ListElement currentLeft = getHead();
                for( int i = 0; i <= splitList.length() / 2 - 1; ++i) {
                    returnList.addElement( currentLeft.getContainer() );
                    currentLeft = currentLeft.getNext();
                }
                return returnList;
            case "right":
                ListElement currentRight = getLast();
                for( int i = splitList.length(); i >= (splitList.length() / 2) + 1; --i) {
                    returnList.addElement( currentRight.getContainer() );
                    currentRight = currentRight.getLast();
                }
                return returnList;
        }

        return returnList;
    }
    
    public List getList() 
    {
        ListElement currentElement = getHead();
        
        List returnList = new List();
        returnList.addElement( currentElement );
        
        return returnList;
    }
    
}