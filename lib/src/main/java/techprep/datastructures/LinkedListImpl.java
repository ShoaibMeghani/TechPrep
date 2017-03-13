package techprep.datastructures;

/**
 * Created by smeghani on 11/11/2016.
 */

public class LinkedListImpl<T> {


    public static final class Link<T> {
        public T data;
        public Link next;

        public Link(T data, Link next) {
            this.data = data;
            this.next = next;
        }
    }

    private Link<T> head;
    private int size;


    //Time complixity O(1)

    /**
     * Adds object at the head of a linked list.
     *
     * @param obj element to insert
     */
    public void add(T obj) {
        Link<T> tempLink = new Link<>(obj, head);
        head = tempLink;
        size++;
    }

    //Time complixity O(n) if incase list already has element

    /**
     * Adds object at any given position of a linked list.
     *
     * @param obj element to insert
     */
    public void add(T obj, int position) {
        Link<T> newLink = new Link<>(obj, null);

        if (position == 1) {
            newLink.next = head;
            head = newLink;
            size++;
            return;
        }
        Link<T> tempLink = head;
        for (int i = 0; i < position; i++) {
            tempLink = head.next;
        }

        newLink.next = tempLink.next;
        tempLink.next = newLink;
        size++;
    }

    //Time complixity O(n)

    /**
     * Adds object at any given position of a linked list.
     *
     * @param position position of the element to be removed
     * @return removed element
     */
    public Link<T> remove(int position) {
        if (position > 0 && position < size) {

            Link<T> tempLink = head;
            for (int i = 0; i < position; i++) {
                tempLink = head.next;
            }

            Link<T> deletedNode = tempLink.next;
            tempLink.next = deletedNode.next;
            size--;

            return deletedNode;


        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public void reverse() {
        if (head != null) {

            Link<T> current = head;
            Link<T> prevLink = null;
            Link<T> tempLink = null;

            while (current != null) {

                tempLink = current.next;
                current.next = prevLink;
                prevLink = current;
                current = tempLink;

            }


        }
    }


    public void recursiveReverse(Link<T> link) {
        if (link.next == null) {
            head = link;
            return;
        }

        recursiveReverse(link);

        Link<T> temp = link.next;
        temp.next = link;
        link.next = null;

    }


    public void recursivePrint(Link<T> link) {
        if (link.next == null) {
            return;
        }

        recursivePrint(link.next);
        //print link here

    }


    public int size(){
        return  size;
    }

    public Link<T> getHead() {
        return head;
    }

    public void setHead(Link<T> head) {
        this.head = head;
    }
}
