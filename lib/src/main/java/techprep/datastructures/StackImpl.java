package techprep.datastructures;

import java.util.Stack;

/**
 * Created by smeghani on 11/13/2016.
 */

public class StackImpl<T> {

    public static final class Link<T> {
        T data;
        Link next;

        public Link(T data, Link next) {
            this.data = data;
            this.next = next;
        }
    }

    private Link<T> top;
    private int size;


    public void push(T obj) {

        Link<T> newLink = new Link<>(obj, top);
        top = newLink;
        size++;
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public T top() {
        return top.data;
    }


    public boolean isEmpty(){
      return  size == 0;
    }




}
