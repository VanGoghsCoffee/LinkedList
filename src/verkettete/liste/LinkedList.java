package verkettete.liste;

public class LinkedList {

    public static void main(String[] args) {
        List list = new List();
        list.createList( 20 );
        list.printList();
        
        list = list.mergeSort(list);
        list.printList();
    }
}
