public class TestGenListString {

    public static void main(String[] args) {

        GenList<String> ll = new GenList<String>();

        System.out.println("\nAdding Blue, Red, Orange and Green to the list");
        ll.insert("Blue");
        ll.insert("Red");
        ll.insert("Orange");
        ll.insert(3,"Green"); // adds directly to end using index.
        System.out.println(ll);
        System.out.println("size is now " + ll.size());
        System.out.println("The index of Orange is " + ll.indexOf("Orange"));

        System.out.println("\nAdding Yellow to index 2.");
        ll.insert(2, "Yellow");
        System.out.println(ll);
        System.out.println("size is now " + ll.size());
        System.out.println("The index of Yellow is " + ll.indexOf("Yellow"));

        System.out.println("\nTesting toArray()");
        Object[] o = ll.toArray();
        System.out.println("Object array:");
        for (int x = 0; x < o.length; x++)
            System.out.println("o[" + x + "] = " + o[x]);

        System.out.println("\nRemoving Green from end of list");
        ll.delete("Green"); // beginning
        System.out.println(ll);
        System.out.println("size is now " + ll.size());

        System.out.println("\nThe element at index 1 is " + ll.elementAt(1));

        System.out.println("\nTesting IndexOutOfBoundsException for elementAt()");
        try {
            System.out.println("THIS IS OUT OF BOUNDS " + ll.elementAt(10));
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Hurray! Caught the bad one!");
        }

        System.out.println("\nRemoving Red (index 1) from middle of list");
        ll.delete(1); // Red at index 1.
        System.out.println(ll);
        System.out.println("size is now " + ll.size());

        System.out.println("\nRemoving Blue (index 0) from front of list");
        ll.delete(0); // front
        System.out.println(ll);
        System.out.println("size is now " + ll.size());

        System.out.println("\nRemoving Orange (index 1) from end of list");
        ll.delete(1); // Orange at index 1.
        System.out.println(ll);
        System.out.println("size is now " + ll.size());
    }
}

