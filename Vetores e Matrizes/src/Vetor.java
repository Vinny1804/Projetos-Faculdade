import java.util.Scanner;

public class Vetor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] nomes = new String[3];
        System.out.println("Digite até 3 nomes:");

        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }
        System.out.println("\nNomes inseridos:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
        scanner.close();
    }
}
