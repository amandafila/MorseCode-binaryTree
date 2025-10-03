import TreeStructure.Node;
import TreeStructure.Tree;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree morseTree = new Tree();
        boolean treeFilled = false;
        int entrada;

        do {
            System.out.println("\n### Menu ###");
            System.out.println("1 - Preencher árvore automaticamente");
            System.out.println("2 - Inserir elemento");
            System.out.println("3 - Codificar frase");
            System.out.println("4 - Decodificar código Morse");
            System.out.println("0 - Sair e mostrar árvore");
            System.out.print("Escolha uma opção: ");
            entrada = sc.nextInt();
            sc.nextLine();

            switch (entrada) {
                case 1:
                    if (!treeFilled) {
                        morseTree.fillTree(morseTree);
                        treeFilled = true;
                        System.out.println("Árvore preenchida com o alfabeto Morse padrão.");
                        System.out.println("AVISO: A inserção manual de elementos foi desativada. Reinicie para criar sua própria árvore.");
                    } else {
                        System.out.println("A árvore já foi preenchida. Para inserir seu próprio código, reinicie o programa.");
                    }
                    break;
                case 2:
                    if (!treeFilled) {
                        System.out.print("Digite a letra: ");
                        char letter = sc.nextLine().charAt(0);
                        System.out.print("Digite o código Morse ('.' para esquerda, '-' para direita): ");
                        String code = sc.nextLine();
                        morseTree.insert(code, letter);
                        System.out.println("Elemento inserido com sucesso!");
                    } else {
                        System.out.println("A inserção manual está desativada pois a árvore foi preenchida automaticamente.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a frase a ser codificada: ");
                    String phraseToCode = sc.nextLine();
                    String codedPhrase = morseTree.code(phraseToCode);
                    System.out.println("Frase codificada: " + codedPhrase);
                    break;
                case 4:
                    System.out.print("Digite o código Morse a ser decodificado (use '/' para espaço entre palavras): ");
                    String codeToDecode = sc.nextLine();
                    String decodedPhrase = morseTree.decode(codeToDecode);
                    System.out.println("Código decodificado: " + decodedPhrase);
                    break;
                case 0:
                    System.out.println("Saindo e exibindo a árvore...");
                    TreeDisplay.setRoot(morseTree.getRoot());
                    javafx.application.Application.launch(TreeDisplay.class, args);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (entrada != 0);

        sc.close();
    }
}