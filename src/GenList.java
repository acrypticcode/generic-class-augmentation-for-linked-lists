//Creates a linked list class that can accept values of any data type
public class GenList<T> {
    private Node head;
    private Node tail;
    private int size;


    private class Node {
        private T data;
        private Node next;
        private Node(T item) {
            data = item;
            next = null;
        }
    }

    //constructors
    public GenList () {
        head = null;
        tail = null;
    }

    public GenList(T[] array){
        head = null;
        tail = null;
        for (int i=0;i<array.length;i++){
            insert(array[i]);
        }
    }

    public int indexOf (Object o){
        //returns the index that the argument occupies in the list or -1 if the object is not present
        Node current;
        int pos;
        current = head;
        pos = 0;
        while (current !=  null){
            if (current.data == o){
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public Object[] toArray(){
        //returns an array containing the list items
        Object[] ary = new Object[size];
        Node current;
        int i = 0;

        current = head;
        while (current != null){
            ary[i] = current.data;
            current = current.next;
            i++;
        }
        return ary;
    }

    public T elementAt(int index){
        //returns the linked list element at the given index
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
            if (current == null){
                throw new IndexOutOfBoundsException();
            }
        }
        return current.data;
    }

    //two insert methods to add items to the linked list
    public void insert(T item) {
        Node n = new Node(item);

        if (tail == null) {
            head = n;
        }
        else{
            tail.next = n;
        }
        tail = n;
        size++;
    }

    public void insert(int i, T item){

        Node n = new Node(item);

        if (i > size){
            throw new IndexOutOfBoundsException();
        }

        else if (i == size){
            insert(item);
            return;
        }

        else if (i == 0){
            head = n;
        }

        else {
            Node current = head;
            for (int pos = 0; pos < i - 1; pos++) {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
        }

        size++;
    }

    //two delete methods to remove items from the list
    public void delete(T item) {
        Node cur = head, back = null;

        while (cur != null) {
            if (cur.data.equals(item)) {
                if (back == null)
                    head = cur.next;
                else
                    back.next = cur.next;

                size--;
                break; // leave the loop
            } else {
                back = cur;
                cur = cur.next; // move to the next node
            }
        }
    }

    public void delete (int index){
        Node current;

        if (index >= size){
            throw new IndexOutOfBoundsException();
        }


        if (index == 0){
            head = head.next;
            if (size == 1){
                tail = null;
            }
            size--;
            return;
        }

        current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        if (size == index+1){
            tail = current;
        }
        size--;
    }

    @Override
    public String toString() {
        String o = "[";
        Node p = head;

        // first data value is alone.
        if ( p != null ) {
            o += p.data;
            p = p.next;
        }
        // remaining data values have ", value"
        while ( p != null ) {
            o += ", " + p.data;
            p = p.next;
        }
        return o + "]";
    }
}