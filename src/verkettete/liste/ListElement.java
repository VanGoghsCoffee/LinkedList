package verkettete.liste;

public class ListElement {
    public ListElement() {}
    public ListElement(int value_) { this.container = value_; }
    public void setNext( ListElement next_ ) { this.next = next_; }
    public ListElement getNext() { return this.next; }
    public void setLast( ListElement last_ ) { this.last = last_; }
    public ListElement getLast() { return this.last; }
    public int getContainer() { return this.container; }
    
    private ListElement next;
    private ListElement last;
    private int container;  
}
