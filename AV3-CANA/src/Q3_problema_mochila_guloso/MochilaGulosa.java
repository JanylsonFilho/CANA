package Q3_problema_mochila_guloso;

import java.util.*;
public class MochilaGulosa {

    public static List<String> selecionarItens(int capacidade, List<Item> itens) {
        // Ordena os itens por valor/peso em ordem decrescente
        itens.sort((a, b) -> Double.compare(
                (double) b.valor / b.peso,
                (double) a.valor / a.peso
        ));

        List<String> selecionados = new ArrayList<>();
        int pesoAtual = 0;
        int valorTotal = 0;

        System.out.println("\nProcesso de seleção dos itens:");

        for (Item item : itens) {
            System.out.println("Analisando: " + item.nome + " (Peso: " + item.peso + " kg, Valor: R$" + item.valor + ")");
            if (pesoAtual + item.peso <= capacidade) {
                selecionados.add(item.nome);
                pesoAtual += item.peso;
                valorTotal += item.valor;
                System.out.println("Selecionado! Peso atual: " + pesoAtual + " kg | Valor total: R$" + valorTotal);
            } else {
                System.out.println("Não cabe na mochila.");
            }
        }

        System.out.println("\nValor total carregado: R$" + valorTotal);
        return selecionados;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a capacidade da mochila (em kg): ");
        int capacidade = sc.nextInt();

        System.out.print("Digite a quantidade de itens: ");
        int qtd = sc.nextInt();

        List<Item> itens = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nItem " + (i + 1) + ":");

            sc.nextLine(); // limpa buffer
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Peso (kg): ");
            int peso = sc.nextInt();

            System.out.print("Valor (R$): ");
            int valor = sc.nextInt();

            itens.add(new Item(nome, peso, valor));
        }

        List<String> resultado = selecionarItens(capacidade, itens);

        System.out.println("\nItens selecionados para a mochila:");
        resultado.forEach(System.out::println);


    }
}
