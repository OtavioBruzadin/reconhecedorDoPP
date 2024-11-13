package Tree;

import Engine.Simbolos.NaoTerminais;
import Engine.Simbolos.Terminais;

public class Node {

    private boolean isTerminal;
    private NaoTerminais naoTerminal = null;
    private Terminais terminal = null;

    private Node parent, left, center, right;

    public Node(boolean isTerminal, NaoTerminais naoTerminal, Terminais terminal) {
        this.isTerminal = isTerminal;
        this.naoTerminal = naoTerminal;
        this.terminal = terminal;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }

    public NaoTerminais getNaoTerminal() {
        if(!isLeaf()) return naoTerminal;
        return null;
    }

    public void setNaoTerminal(NaoTerminais naoTerminal) {
        this.naoTerminal = naoTerminal;
    }

    public Terminais getTerminal() {
        if(isLeaf()) return terminal;
        return null;
    }

    public void setTerminal(Terminais terminal) {
        this.terminal = terminal;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node node) {
        this.parent = node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }
    public Node getCenter() {
        return center;
    }

    public void setCenter(Node node) {
        this.center = node;
    }
    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public boolean isLeaf() {
        return left == null && center == null && right == null;
    }

    public void insertLeaf(Node leaf) {
        if(left == null) {
            setLeft(leaf);
        } else if(center == null) {
            setCenter(leaf);
        } else if(right == null) {
            setRight(leaf);
        }

        leaf.setParent(this);
    }

    public void deleteLeaf(Node leaf) {
        if(leaf == left) {
            left = null;
        } else if(leaf == center) {
            center = null;
        } else if(leaf == right) {
            right = null;
        }
    }
}
