import java.util.Scanner;

public class Matriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] nomes = new String[3];
        
        double[][] notas = new double[3][2];
        
        System.out.println("Digite o nome e as notas dos alunos:");

        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome do Aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
            
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print((j + 1) + "ª nota" + " de " + nomes[i] + ": ");            
                notas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }

        System.out.println("\nNomes e Notas dos Alunos:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Aluno: " + nomes[i] + " - Notas: ");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print(notas[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
