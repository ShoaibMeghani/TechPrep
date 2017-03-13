package techprep.datastructures;

//import android.util.Log;

/**
 * Created by smeghani on 11/18/2016.
 */

public class TreeImpl<T extends Comparable> {


    public static final class Node<T> {
        T data;
        Node right;
        Node left;

        public Node(T data, Node right, Node left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }
    }


    private Node mainRoot;


    public Node insert(Node parent, T data) {

        if (parent == null) {

            parent = new Node(data, null, null);

        } else {
            if (data.compareTo(parent.data) > 0) {
                parent.right = insert(parent.right, data);
            } else {
                parent.left = insert(parent.left, data);

            }
        }

        return parent;
    }

    public boolean search(Node parent, T data) {
        if (parent == null) {
            return false;
        } else if (data.compareTo(parent.data) == 0) {
            return true;
        } else if (data.compareTo(parent.data) > 0) {
            return search(parent.right, data);
        } else {
            return search(parent.left, data);
        }
    }

    public void bfsTraversal(Node root){
        if (root != null){

            QueueImpl<Node> queue = new QueueImpl<>();
            queue.enqueue(root);

            while(!queue.isEmpty()){
                Node currentNode = queue.front().data;
                Node left = currentNode.left;
                Node right = currentNode.right;

                if (left != null){
                    queue.enqueue(left);
                }

                if (right != null){
                    queue.enqueue(right);
                }
                queue.deque();

            }

        }
    }

    public void dfsTraversal(Node root){

    }








    public void dfsTraversalPreOrder(Node root){

        if (root == null){
            return;
        }
        //Log.d("node", root.data + "");
        dfsTraversalPreOrder(root.left);
        dfsTraversalPreOrder(root.right);
    }



}
