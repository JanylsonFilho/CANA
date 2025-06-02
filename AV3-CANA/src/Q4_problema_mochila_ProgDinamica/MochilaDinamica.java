package Q4_problema_mochila_ProgDinamica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MochilaDinamica {
    // Método principal de seleção com programação dinâmica
    public static List<String> selecionarItens(int capacidadeMochila, List<Item> itens) {
        int n = itens.size();

        // Matriz dp[i][w] armazena o valor máximo possível com os i primeiros itens e capacidade w
        int[][] dp = new int[n + 1][capacidadeMochila + 1];

        // Preenchimento da tabela DP
        for (int i = 1; i <= n; i++) {
            Item itemAtual = itens.get(i - 1);
            for (int w = 1; w <= capacidadeMochila; w++) {
                if (itemAtual.peso <= w) {
                    // Caso o item caiba, escolhe o máximo entre pegar ou não pegar
                    dp[i][w] = Math.max(
                            dp[i - 1][w], // não pegar o item
                            itemAtual.valor + dp[i - 1][w - itemAtual.peso] // pegar o item
                    );
                } else {
                    // Item não cabe, herda o valor da linha de cima
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Lista para armazenar os nomes dos itens selecionados
        List<String> selecionados = new ArrayList<>();
        int w = capacidadeMochila;

        // Backtracking para descobrir quais itens foram escolhidos
        // Recuperar os itens escolhidos com exibição de cada escolha
        System.out.println("\nItens selecionados (com rastreamento de escolhas):");
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = itens.get(i - 1);
                selecionados.add(item.nome);
                System.out.println("Item selecionado: " + item.nome +
                        " (Peso: " + item.peso + "kg, Valor: R$" + item.valor + ")");
                w -= item.peso;
            }
        }


        // Exibe o valor total máximo alcançado na mochila
        System.out.println("\nValor total máximo na mochila: R$" + dp[n][capacidadeMochila]);

        return selecionados;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itens = new ArrayList<>();

        // Entrada da capacidade da mochila
        System.out.print("Digite a capacidade da mochila (em kg): ");
        int capacidade = scanner.nextInt();

        // Entrada da quantidade de itens
        System.out.print("Digite a quantidade de itens: ");
        int quantidade = scanner.nextInt();

        // Entrada dos dados de cada item
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Nome: ");
            scanner.nextLine(); // limpar o buffer do scanner
            String nome = scanner.nextLine();
            System.out.print("Peso (em kg): ");
            int peso = scanner.nextInt();
            System.out.print("Valor (em R$): ");
            int valor = scanner.nextInt();

            itens.add(new Item(nome, peso, valor)); // adiciona o item à lista
        }

        // Chama o método para resolver a mochila e imprime os itens selecionados
        List<String> resultado = selecionarItens(capacidade, itens);

        System.out.println("\nItens selecionados:");
        for (String nome : resultado) {
            System.out.println("- " + nome);
        }
    }
}
