package techprep.solutions;

import java.util.Stack;

import techprep.datastructures.StackImpl;

/**
 * Created by smeghani on 3/13/2017.
 */

public class StackQueueSolution {

    /*3.1 Describe how you could use a single array to implement three stacks.*/
    private void stackFromArray() {

        int maxStackSize = 5;
        int noOfStack = 3;

        int[] arr = new int[maxStackSize * noOfStack];
        int[] stackPeek = new int[noOfStack];
        for (int i = 0; i < stackPeek.length; i++) {
            stackPeek[i] = (i / noOfStack) * arr.length;
        }
        //push in stack
        int stackno = 0;
        int value = 2;
        if (stackno == noOfStack - 1 && stackPeek[stackno] < arr.length - 1) {
            arr[stackPeek[stackno]] = value;
            stackPeek[stackno]++;
        } else if (stackPeek[stackno] < (stackno + 1 / noOfStack) * arr.length - 1) {
            arr[stackPeek[stackno]] = value;
            stackPeek[stackno]++;
        }
        //pop from stack
        if (stackPeek[stackno] > 0) {
            stackPeek[stackno]--;
        }
    }

    /*3.2 How would you design a stack which, in addition to push and pop, also has a
    function min which returns the minimum element? Push, pop and min should all
    operate in 0(1) time.*/
    public void getMinOfStack() {
        StackImpl<Integer> stack = new StackImpl<>();
        StackImpl<Integer> stackMin = new StackImpl<>();
        //push method
        int value = 0;
        stack.push(value);
        if (stackMin.isEmpty() || stackMin.top() > value) {
            stackMin.push(value);
        }
        //pop method
        if (stack.top() == stackMin.top()) {
            stackMin.pop();
        }
        stack.pop();
    }

    /*3.3 Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
    in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
    Stacks should be composed of several stacks and should create a new stack once
    the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
    pop () should behave identically to a single stack (that is, pop () should return the
    same values as it would if there were just a single stack).
    FOLLOW UP
    Implement a function popAt(int index) which performs a pop operation on a
    specific sub-stack.*/

    //TODO: Implement Code


    /*3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
        different sizes which can slide onto any tower. The puzzle starts with disks sorted
        in ascending order of size from top to bottom (i.e., each disk sits on top of an even
        larger one). You have the following constraints:
        (T) Only one disk can be moved at a time.
        (2) A disk is slid off the top of one tower onto the next rod.
        (3) A disk can only be placed on top of a larger disk.
        Write a program to move the disks from the first tower to the last using Stacks.*/

    //TODO: Implement Code

    /*3.5 Implement a MyQueue class which implements a queue using two stacks.*/
    private void makeQueueFromStacks() {
        StackImpl<Integer> stack1 = new StackImpl<>();
        StackImpl<Integer> stack2 = new StackImpl<>();

        //enqeue
        stack1.push(1);

        //dequeu
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        stack2.pop();
    }

    /*3.6 Write a program to sort a stack in ascending order (with biggest items on top).
    You may use at most one additional stack to hold items, but you may not copy the
    elements into any other data structure (such as an array). The stack supports the
    following operations: push, pop, peek, and isEmpty.*/
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            Integer item1 = stack.peek();
            stack.pop();
            while (tempStack.peek() != null && tempStack.peek() > item1) {
                stack.push(tempStack.peek());
                tempStack.pop();
            }
            tempStack.push(item1);
        }
    }


    /*3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
    out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
    at the shelter, or they can select whether they would prefer a dog or a cat (and will
    receive the oldest animal of that type). They cannot select which specific animal they
    would like. Create the data structures to maintain this system and implement operations
    such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
    use the built-in L inkedL ist data structure.*/
    //TODO: Implement Code

    /*Check if expression has balanced paranthesis*/
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


        for (int i = 0; i < expression.length(); i++) {
            String charac = expression.charAt(i) + "";

            if (!charac.equals("+") && !charac.equals("-") && !charac.equals("*") && !charac.equals("/")) {
                stack.push(charac);

            } else {
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

