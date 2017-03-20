package techprep.datastructures;

import sun.reflect.generics.tree.Tree;

/**
 * Created by smeghani on 3/14/2017.
 */

public class TreeNode<T> {
    private TreeNode nodeLeft;
    private TreeNode nodeRight;
    private T data;
    private TreeNode parent;
    private int level;

    public TreeNode getNodeLeft() {
        return nodeLeft;
    }

    public void setNodeLeft(TreeNode nodeLeft) {
        this.nodeLeft = nodeLeft;
    }

    public TreeNode getNodeRight() {
        return nodeRight;
    }

    public void setNodeRight(TreeNode nodeRight) {
        this.nodeRight = nodeRight;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
