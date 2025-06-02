package Q5_problema_mochila_ProgDinamica_ilimitada;

import java.util.*;
public class MochilaDinamicaIlimitada {
    // Método que resolve a mochila ilimitada e mostra as escolhas feitas
    public static Map<String, Integer> selecionarItens(int capacidade, List<Item> itens) {
        int[] dp = new int[capacidade + 1]; // dp[w] = maior valor para capacidade w
        String[] escolhas = new String[capacidade + 1]; // rastreia itens escolhidos por capacidade

        Arrays.fill(escolhas, ""); // inicia todas as strings como vazias

        // Loop principal da DP (ordem por capacidade)
        for (int w = 0; w <= capacidade; w++) {
            for (Item item : itens) {
                if (item.peso <= w) {
                    // tenta pegar o item novamente (porque pode repetir)
                    int novoValor = dp[w - item.peso] + item.valor;
                    if (novoValor > dp[w]) {
                        dp[w] = novoValor;
                        escolhas[w] = escolhas[w - item.peso] + item.nome + ",";
                    }
                }
            }
        }

        // Exibe valor máximo total obtido
        System.out.println("\nValor total máximo na mochila: R$" + dp[capacidade]);
        System.out.println("Itens escolhidos (com repetição):");

        // Conta quantas vezes cada item foi escolhido
        Map<String, Integer> contagem = new LinkedHashMap<>();
        if (!escolhas[capacidade].isEmpty()) {
            String[] selecionados = escolhas[capacidade].split(",");
            for (String nome : selecionados) {
                if (nome.isEmpty()) continue;
                contagem.put(nome, contagem.getOrDefault(nome, 0) + 1);
            }
        }

        // Exibe os itens e quantas vezes cada um foi selecionado
        for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
            System.out.println("- " + entry.getKey() + " x" + entry.getValue());
        }

        return contagem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> itens = new ArrayList<>();

        // Entrada da capacidade total da mochila
        System.out.print("Digite a capacidade da mochila (em kg): ");
        int capacidade = scanner.nextInt();

        // Entrada da quantidade de itens disponíveis
        System.out.print("Digite a quantidade de itens: ");
        int quantidade = scanner.nextInt();

        // Entrada dos dados de cada item
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Nome: ");
            scanner.nextLine(); // limpa buffer do teclado
            String nome = scanner.nextLine();
            System.out.print("Peso (em kg): ");
            int peso = scanner.nextInt();
            System.out.print("Valor (em R$): ");
            int valor = scanner.nextInt();

            itens.add(new Item(nome, peso, valor));
        }

        // Chamada do algoritmo
        selecionarItens(capacidade, itens);
    }
}
