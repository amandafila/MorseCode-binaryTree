import TreeStructure.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = 0;
        do{
            System.out.println("0 - Sair");
            System.out.println("1 - Preencher árvore automaticamente");
            System.out.println("2 - Inserir elemento");
            System.out.println("3 - Mostrar árvore");

            entrada = sc.nextInt();




        }while (entrada != 0);


    }
}