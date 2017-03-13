package techprep.solutions;

import java.util.HashSet;
import java.util.LinkedList;

import techprep.datastructures.LinkedListImpl;
import techprep.datastructures.StackImpl;

/**
 * Created by smeghani on 3/12/2017.
 */

public class LinkedListSolution {


    /*2.1 Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?*/
    public void removeDuplicates(LinkedListImpl<String> linkedList) {

        //This solution is with buffer, if there is no buffer available run 2 loops to check each element Time 0(N^2)
        HashSet<String> set = new HashSet<>();
        LinkedListImpl.Link<String> link = linkedList.getHead();
        LinkedListImpl.Link prev = null;
        while (link != null) {

            if (set.contains(link.data)) {
                prev.next = link.next;
            } else {
                set.add(link.data);
                prev = link;
            }

            link = link.next;
        }
    }

    /*2.2 Implement an algorithm to find the kth to last element of a singly linked list.*/
    public int getLink(LinkedListImpl.Link<String> link, int kthIndex) {
        if (link == null)
            return 0;

        if (link.next == null) {
            return 1;
        }
        int i = getLink(link.next, 3) + 1;

        if (i == 3) {
            //printOnConsole(link.data);
        }
        return i;
    }

    /*2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given
          only access to that node.*/
    public void deleteNode(LinkedListImpl.Link<String> linkToDelete) {
        linkToDelete.data = (String) linkToDelete.next.data;
        linkToDelete.next = linkToDelete.next.next;
    }


    /*2.4 Write code to partition a linked list around a value x, such that all nodes less than x
          come before alt nodes greater than or equal to x.*/
    public void partitionLinkedList(LinkedListImpl<Integer> linkedList, int x) {
        LinkedListImpl.Link<Integer> link = linkedList.getHead();
        LinkedListImpl.Link<Integer> secondHead = null;
        LinkedListImpl.Link<Integer> mainSecondHead = null;
        LinkedListImpl.Link<Integer> prev = null;

        while (link != null) {
            if (link.data < x) {
                prev = link;
                link = link.next;
            } else {
                if (secondHead == null) {

                    secondHead = link;
                    mainSecondHead = secondHead;

                } else {
                    secondHead.next = link;
                    secondHead = link;
                }

                if (prev != null) {
                    prev.next = link.next;
                } else {
                    linkedList.setHead(link.next);
                }

                link = link.next;
            }
        }
        secondHead.next = null;
        prev.next = mainSecondHead;
    }

    /*2.5 You have two numbers represented by a linked list, where each node contains a
    single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
    of the list. Write a function that adds the two numbers and returns the sum as a
    linked list.
    FOLLOW UP
    Suppose the digits are stored in forward order. Repeat the above problem.*/
    public void addLinkedListDigits(LinkedListImpl<Integer> l1, LinkedListImpl<Integer> l2) {
        LinkedList<Integer> result = new LinkedList();
        int remainder = 0;
        LinkedListImpl.Link<Integer> link1 = l1.getHead();
        LinkedListImpl.Link<Integer> link2 = l2.getHead();
        while (link1 != null || link2 != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (link1 != null) {
                l1Value = link1.data;
            }
            if (link2 != null) {
                l2Value = link2.data;
            }
            int res = l1Value + l2Value + remainder;
            if (res < 10) {
                result.add(res);
                remainder = 0;
            } else if (res < 20) {
                result.add(res - 10);
                remainder = 1;
            } else {
                result.add(0);
                remainder = 2;
            }
            if (link1 != null) {
                link1 = link1.next;
            }
            if (link2 != null) {
                link2 = link2.next;
            }
        }
    }

    /*2.6 Given a circular linked list, implement an algorithm which returns the node at the
    beginning of the loop.*/
    public LinkedListImpl.Link<String> findBeginning(LinkedListImpl<String> linkedList) {
        LinkedListImpl.Link<String> fast = linkedList.getHead();
        LinkedListImpl.Link<String> slow = linkedList.getHead();
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow == null || fast == null) {
            // no beginning
        }
        slow = linkedList.getHead();
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /*2.7 Implement a function to check if a linked list is a palindrome,*/
    public boolean isPalindrome(LinkedListImpl<Integer> list){
        //Solution 1 is to make copy of the list, reverse it and compare. Other is to use stack
        StackImpl<Integer> stack = new StackImpl<>();
        LinkedListImpl.Link<Integer> current = list.getHead();
        while(current != null){
            stack.push(current.data);
            current = current.next;
        }

        LinkedListImpl.Link<Integer> current2 = list.getHead();
        while(!stack.isEmpty()){
            if (current2.data == stack.top()){
                stack.pop();
                current2 = current2.next;
            }else{
                return false;
            }
        }
        return  true;
    }

}
