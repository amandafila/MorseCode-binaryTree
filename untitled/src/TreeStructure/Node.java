package TreeStructure;

public class Node {
    char element;
    Node left;
    Node right;

    public Node(char element) {
        this.element = element;
        left = null;
        right = null;
    }

    public char getElement() {
        return element;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
