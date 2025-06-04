package Q8_problema_somaSubconjuntos_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSumBacktracking {

    public static boolean encontrou = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do vetor
        System.out.print("Digite o tamanho do vetor: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Digite os " + n + " números (positivos ou negativos):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("\nSubconjuntos analisados (com backtracking):");
        buscarComBacktracking(nums, 0, new ArrayList<>(), 0);

        if (!encontrou) {
            System.out.println("\n Nenhum subconjunto com soma zero foi encontrado.");
        } else {
            System.out.println("\n Pelo menos um subconjunto com soma zero foi encontrado.");
        }

        scanner.close();
    }

    public static void buscarComBacktracking(int[] nums, int index, List<Integer> subconjunto, int somaAtual) {
        // Exibe o subconjunto atual (exceto vazio)
        if (!subconjunto.isEmpty()) {
            System.out.print("Subconjunto: " + subconjunto + " → Soma = " + somaAtual);
            if (somaAtual == 0) {
                System.out.print(" - A soma é igual a zero");
                encontrou = true;
            } else {
                System.out.print(" - A soma não é igual a zero");
            }
            System.out.println();
        }

        // Interrompe se soma já for 0 e encontrou uma solução
        if (somaAtual == 0 && !subconjunto.isEmpty()) {
            return;
        }

        // Fim do vetor
        if (index == nums.length) return;

        // Inclui o elemento atual
        subconjunto.add(nums[index]);
        buscarComBacktracking(nums, index + 1, subconjunto, somaAtual + nums[index]);

        // Remove o elemento (backtracking)
        subconjunto.remove(subconjunto.size() - 1);
        buscarComBacktracking(nums, index + 1, subconjunto, somaAtual);
    }
}
