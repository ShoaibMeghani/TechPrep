package com.smeghani.techprep.datastructures;

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


    public boolean isExpressionCorrect() {

        Stack<String> stack = new Stack<>();
        String expression = "(a+b)*(c-b)";
        boolean isValid = false;

        for (int i = 0; i < expression.length(); i++) {
            String character = expression.charAt(i) + "";

            if (character.equals("(") || character.equals("{") || character.equals("[")) {
                stack.push(character + "");
            } else if (character.equals(")") || character.equals("}") || character.equals("]")) {
                if (stack.peek().equals(character + "")) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            isValid = true;
        }
        return isValid;
    }

    public void readPostFixExpression() {
        Stack<String> stack = new Stack<>();
        String expression = "ab+c*";


        for (int i = 0; i<expression.length();i++){
            String charac = expression.charAt(i)+"";

            if (!charac.equals("+") && !charac.equals("-") && !charac.equals("*") && !charac.equals("/")){
                stack.push(charac);

            }else{
                String prev = stack.peek();
                stack.pop();
                String prev2 = stack.peek();
                stack.pop();

                String result = prev + charac + prev2;
                stack.push(result);
            }

        }
    }

    public void readPreFixExpression() {
        //for prefix just iterate from right side and perform same algorithm

    }

    public void convertInfixToPostFix() {

    }

}
