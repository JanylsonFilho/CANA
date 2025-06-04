package Q7_problema_soma_subconjuntos_forcaBruta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetSumZero {

    public static boolean encontrou = false; // Flag para saber se já achamos algum subconjunto

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite o tamanho do vetor: ");
        int n = scanner.nextInt();
        int[] numeros = new int[n];

        System.out.println("Digite os " + n + " números (positivos ou negativos):");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\nSubconjuntos analisados:");
        encontrarSubconjuntosSomaZero(numeros, 0, new ArrayList<>(), 0);

        if (!encontrou) {
            System.out.println("\n Nenhum subconjunto com soma zero foi encontrado.");
        } else {
            System.out.println("\n Pelo menos um subconjunto com soma zero foi encontrado.");
        }

        scanner.close();
    }

    // Função recursiva que gera todos os subconjuntos e verifica se algum soma zero
    public static void encontrarSubconjuntosSomaZero(int[] nums, int index, List<Integer> subconjunto, int somaAtual) {
        // Exibe passo a passo (exceto subconjunto vazio)
        if (!subconjunto.isEmpty()) {
            System.out.print("Subconjunto: " + subconjunto + " → Soma = " + somaAtual);
            if (somaAtual == 0) {
                System.out.print(" - A soma é igual a zero.");
                encontrou = true;
            } else {
                System.out.print(" - A soma não é igual a zero.");
            }
            System.out.println();
        }

        // Caso base: chegou ao fim
        if (index == nums.length) {
            return;
        }

        // Inclui o elemento atual no subconjunto
        subconjunto.add(nums[index]);
        encontrarSubconjuntosSomaZero(nums, index + 1, subconjunto, somaAtual + nums[index]);

        // Exclui o último elemento (backtrack) e tenta sem ele
        subconjunto.remove(subconjunto.size() - 1);
        encontrarSubconjuntosSomaZero(nums, index + 1, subconjunto, somaAtual);
    }
}
