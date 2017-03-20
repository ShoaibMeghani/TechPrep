package techprep.datastructures;

/**
 * Created by smeghani on 11/13/2016.
 */

public class QueueImpl<T> {

    public static final class Link<T> {
        T data;
        Link next;

        public Link(T data, Link next) {
            this.data = data;
            this.next = next;
        }
    }

    private Link<T> front,rear;
    private int size;


    public void enqueue(T obj) {

        Link<T> newLink = new Link<>(obj, null);
        if (front == null && rear == null){
            front = newLink;
            rear = newLink;
            size++;
            return;
        }

        newLink.next = rear;
        rear = newLink;
        size++;
    }

    public void deque() {
        if (front != null){
            front = front.next;
        }else if(front == rear){
            front = null;
            rear = null;
        }
    }

    public T front() {
        if (front != null){
            return  front.data;
        }

        return null;
    }




    public boolean isEmpty(){
        return  size == 0;
    }
}
