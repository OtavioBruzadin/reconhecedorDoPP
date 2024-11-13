package Tree;

public class Tree {

    private Node root;
    private int size;

    public Tree(Node root) {
        this.root = root;
        this.size = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void readLeaves() {
        readLeaves(root);
    }

    public void readLeaves(Node root) {
        if(root.isLeaf()) {
            System.out.println(root.getTerminal());
            return;
        }

        if(root.getLeft() != null) readLeaves(root.getLeft());
        if(root.getCenter() != null) readLeaves(root.getCenter());
        if(root.getRight() != null) readLeaves(root.getRight());
    }
}
