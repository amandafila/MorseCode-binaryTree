package TreeStructure;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(String code, char letter) {
        if (root == null) {
            root = new Node(' ');
        }
        insert(root, code, letter, 0);
    }

    private void insert(Node node, String code, char letter, int index) {
        if (index == code.length()) {
            node.element = letter;
            return;
        }

        char c = code.charAt(index);

        if (c == '.') {
            if (node.left == null) {
                node.left = new Node(' ');
            }
            insert(node.left, code, letter, index + 1);
        } else if (c == '-') {
            if (node.right == null) {
                node.right = new Node(' ');
            }
            insert(node.right, code, letter, index + 1);
        }
    }

    public void fillTree(Tree userTree){
        userTree.insert(".-", 'a');
        userTree.insert("-...", 'b');
        userTree.insert("-.-.", 'c');
        userTree.insert("-..", 'd');
        userTree.insert(".", 'e');
        userTree.insert("..-.", 'f');
        userTree.insert("--.", 'g');
        userTree.insert("....", 'h');
        userTree.insert("..", 'i');
        userTree.insert(".---", 'j');
        userTree.insert("-.-", 'k');
        userTree.insert(".-..", 'l');
        userTree.insert("--", 'm');
        userTree.insert("-.", 'n');
        userTree.insert("---", 'o');
        userTree.insert(".--.", 'p');
        userTree.insert("--.-", 'q');
        userTree.insert(".-.", 'r');
        userTree.insert("...", 's');
        userTree.insert("-", 't');
        userTree.insert("..-", 'u');
        userTree.insert("...-", 'v');
        userTree.insert(".--", 'w');
        userTree.insert("-..-", 'x');
        userTree.insert("-.--", 'y');
        userTree.insert("--..", 'z');
    }

}
