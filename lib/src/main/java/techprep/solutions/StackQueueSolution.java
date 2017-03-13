package techprep.solutions;

import techprep.datastructures.StackImpl;

/**
 * Created by smeghani on 3/13/2017.
 */

public class StackQueueSolution {

    /*3.1 Describe how you could use a single array to implement three stacks.*/
    private void stackFromArray(){

        int maxStackSize = 5;
        int noOfStack = 3;

        int[] arr = new int[maxStackSize*noOfStack];
        int[] stackPeek = new int[noOfStack];
        for(int i = 0; i < stackPeek.length; i++){
            stackPeek[i] = (i/noOfStack)*arr.length;
        }
        //push in stack
        int stackno = 0;
        int value = 2;
        if (stackno == noOfStack - 1 && stackPeek[stackno] < arr.length - 1){
            arr[stackPeek[stackno]] = value;
            stackPeek[stackno]++;
        }else if (stackPeek[stackno] < (stackno+1/noOfStack)*arr.length - 1){
            arr[stackPeek[stackno]] = value;
            stackPeek[stackno]++;
        }
        //pop from stack
        if (stackPeek[stackno] > 0){
            stackPeek[stackno]--;
        }
    }

    /*3.2 How would you design a stack which, in addition to push and pop, also has a
    function min which returns the minimum element? Push, pop and min should all
    operate in 0(1) time.*/
    public void getMinOfStack(){
        StackImpl<Integer> stack = new StackImpl<>();
        StackImpl<Integer> stackMin = new StackImpl<>();
        //push method
        int value = 0;
        stack.push(value);
        if (stackMin.isEmpty() || stackMin.top() > value){
            stackMin.push(value);
        }
        //pop method
        if (stack.top() == stackMin.top()){
            stackMin.pop();
        }
        stack.pop();
    }


}
