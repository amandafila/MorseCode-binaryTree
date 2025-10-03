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

        letter = Character.toLowerCase(letter);

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

    //--- ../-.-. .- .-. .-.. --- ...

    public String decode(String code) {

        if (code.trim().isEmpty()) {
            return "";
        }
        return decode(code + " ", "", root, 0, root);
    }

    private String decode(String code, String phrase, Node currentNode, int index, Node treeRoot) {

        if (index == code.length()) {
            return phrase;
        }

        char symbol = code.charAt(index);

        if (symbol == '.') {

            return decode(code, phrase, currentNode.left, index + 1, treeRoot);
        } else if (symbol == '-') {

            return decode(code, phrase, currentNode.right, index + 1, treeRoot);
        } else {

            String newPhrase = phrase + currentNode.element;


            if (symbol == '/') {
                newPhrase += " ";
            }

            return decode(code, newPhrase, treeRoot, index + 1, treeRoot);
        }
    }


    public String code(String phrase) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return ""; // Retorna vazio se a frase for inválida
        }

        phrase = phrase.toLowerCase();
        StringBuilder morsePhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);

            if (letter == ' ') {
                morsePhrase.append("/ "); // Espaço entre palavras
            } else {
                // Chama o "explorador" para encontrar o caminho da letra
                String letterCode = searchForLetter(letter, root);
                if (letterCode != null) {
                    morsePhrase.append(letterCode).append(" "); // Adiciona o código e um espaço
                }
            }
        }

        return morsePhrase.toString().trim(); // Remove o último espaço
    }

    /**
     * Este é o nosso "explorador". Ele procura UMA letra e retorna o caminho.
     * @param letterToFind A letra que estamos procurando (o tesouro).
     * @param currentNode Onde o explorador está agora.
     * @return O caminho (código morse) ou null se não encontrar.
     */
    private String searchForLetter(char letterToFind, Node currentNode) {
        // CASO 1: Beco sem saída. Se o lugar atual é nulo, o tesouro não está aqui.
        if (currentNode == null) {
            return null;
        }

        // CASO 2: BINGO! Achamos o tesouro. A jornada a partir daqui está completa.
        // Retornamos "" (vazio) para indicar sucesso. Quem nos chamou adicionará o '.' ou '-'.
        if (currentNode.element == letterToFind) {
            return "";
        }

        // TENTATIVA 1: Procurar no corredor da ESQUERDA.
        String pathFromLeft = searchForLetter(letterToFind, currentNode.left);
        if (pathFromLeft != null) {
            // SUCESSO! Se achamos pela esquerda, adicionamos um PONTO ao caminho que recebemos.
            return "." + pathFromLeft;
        }

        // TENTATIVA 2: Se não achou na esquerda, procurar no corredor da DIREITA.
        String pathFromRight = searchForLetter(letterToFind, currentNode.right);
        if (pathFromRight != null) {
            // SUCESSO! Se achamos pela direita, adicionamos um TRAÇO ao caminho que recebemos.
            return "-" + pathFromRight;
        }

        // FRACASSO TOTAL: Se não achou nem na esquerda nem na direita, o tesouro não está neste sub-mapa.
        return null;
    }


}






