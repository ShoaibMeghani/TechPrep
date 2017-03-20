package techprep.solutions;

import java.util.ArrayList;
import java.util.LinkedList;

import techprep.datastructures.GraphNode;
import techprep.datastructures.QueueImpl;
import techprep.datastructures.TreeNode;

/**
 * Created by smeghani on 3/14/2017.
 */

public class TreesAndGraphsSolution {

    /*4.1 Implement a function to check if a binary tree is balanced. For the purposes of this
    question, a balanced tree is defined to be a tree such that the heights of the two
    subtrees of any node never differ by more than one.*/
    public int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.getNodeLeft());
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(root.getNodeLeft());
        if (rightHeight == -1) return -1;


        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced(TreeNode node) {
        if (checkHeight(node) == -1) {
            return false;
        } else {
            return true;
        }
    }


    /*4.2 Given a directed graph, design an algorithm to find out whether there is a route
    between two nodes.*/
    public boolean findRoute(GraphNode primNode, GraphNode destNode) {
        QueueImpl<GraphNode> queue = new QueueImpl<>();
        queue.enqueue(primNode);
        while (!queue.isEmpty()) {
            GraphNode node = queue.front();
            node.setState(GraphNode.State.VISTING);
            for (GraphNode n : node.getAdjacentNodes()) {
                if (n.getState().equals(GraphNode.State.UNVISITED)) {
                    n.setState(GraphNode.State.VISITED);
                    if (n.equals(destNode)) {
                        return true;
                    }
                    queue.enqueue(n);
                }
            }

            queue.deque();
        }
        return false;
    }

    /*4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm
    to create a binary search tree with minimal height.*/
    public TreeNode getBNode(int start, int end, int[] array) {
        if (end < start) {
            return null;
        }
        int medium = start + end / 2;
        TreeNode root = new TreeNode();
        root.setData(array[medium]);

        TreeNode left = getBNode(0, medium, array);
        TreeNode right = getBNode(medium + 1, array.length - 1, array);
        root.setNodeLeft(left);
        root.setNodeRight(right);
        return root;
    }


    /*4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at
    each depth (e.g., if you have a tree with depth D, you'll have D linked lists).*/
    public ArrayList<LinkedList<TreeNode>> makeLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        result.add(current);
        while (current.size() > 0) {
            LinkedList<TreeNode> temp = current;
            current = new LinkedList<>();
            for (TreeNode n : temp) {
                if (n.getNodeLeft() != null) {
                    current.add(n.getNodeLeft());
                }

                if (n.getNodeRight() != null) {
                    current.add(n.getNodeRight());
                }
            }
            result.add(current);
        }
        return result;
    }

    /*4.5 Imp/emen t a function to check if a binary tree is a binary search tree.*/
    public boolean isBST(TreeNode<Integer> root, int min, int max) {
        if (root == null)
            return true;

        Integer data = root.getData();

        if ((min <= data) && (data < max) && isBST(root.getNodeLeft(),
                min, data) && isBST(root.getNodeRight(), data, max)) {
            return true;
        }
        return false;
    }

    /*4.6 Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
    a binary search tree. You may assume that each node has a link to its parent.*/
    public TreeNode<Integer> getSuccessor(TreeNode<Integer> node) {
        if (node == null)
            return null;
        if (node.getNodeRight() != null) {
            TreeNode<Integer> n = node.getNodeRight();

            while (n.getNodeLeft() != null) {
                n = n.getNodeLeft();
            }
            return n;
        } else {
            while (node.getParent().getNodeRight().equals(node)) {
                node = node.getParent();
            }
            return node.getParent();
        }

    }

    /*4.7 Design an algorithm and write code to find the first common ancestor of two nodes
    in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
    necessarily a binary search tree.*/
    public boolean isDescendent(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root.equals(node)) {
            return true;
        }
        return isDescendent(root.getNodeRight(), node) || isDescendent(root.getNodeLeft(), node);
    }

    public TreeNode getCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.equals(root) || q.equals(root)) return root;
        boolean is_p_on_left = isDescendent(root.getNodeLeft(), p);
        boolean is_q_on_left = isDescendent(root.getNodeLeft(), q);
        if (is_p_on_left != is_q_on_left) return root;
        return getCommonAncestor(is_p_on_left ? root.getNodeLeft() : root.getNodeRight(), p, q);

    }

    /*4.8 You have two very large binary trees: Tl, with millions of nodes, and T2, with
    hundreds of nodes. Create an algorithm to decide ifT2 is a subtree ofTl.
    A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree ofn
    is identical to T2. That is, if you cut off the tree at node n, the two trees would be
    identical.*/

    public boolean isSubtree(TreeNode node1,TreeNode node2){
        if (node1 == null)
            return false; //tree1 is traversed without finding subtree

        if (node1.equals(node2))
            return matchTree(node1,node2);

        return isSubtree(node1.getNodeLeft(),node2) || isSubtree(node1.getNodeRight(),node2);
    }

    public boolean matchTree(TreeNode node1,TreeNode node2){
        if (node2 == null)
            return true;

        if (!node1.equals(node2))
            return false;

        return matchTree(node1.getNodeLeft(),node2.getNodeRight()) && matchTree(node1.getNodeRight(),node2.getNodeRight());
    }



}
