package Q9_casa_praia_algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasaDePraia {

    // ==============================
    // ETAPA 2 – LÓGICA GULOSA
    // ==============================

    public static List<String> selecionarArquivos(int capacidadePendrive , List<Arquivo> arquivos) {

        // 2.1 Ordena os arquivos pela eficiência (páginas / peso) do maior para o menor
        arquivos.sort((a, b) -> Double.compare(
                (double) b.paginas / b.peso,
                (double) a.paginas / a.peso
        ));

        // 2.2 Inicializa lista dos arquivos selecionados e o peso atual utilizado
        List<String> selecionados = new ArrayList<>();
        int pesoAtual = 0;

        System.out.println("\n Passo a passo da seleção:");

        // 2.3 Percorre os arquivos ordenados e seleciona os que couberem no pendrive
        for (Arquivo arquivo : arquivos) {
            System.out.println("Analisando : " + arquivo.nome +
                    " Páginas: " + arquivo.paginas + " Peso: " + arquivo.peso + ") ");
            if (pesoAtual + arquivo.peso <= capacidadePendrive) {
                // Seleciona o arquivo e atualiza o peso
                selecionados.add(arquivo.nome);
                pesoAtual += arquivo.peso;
                System.out.println("Selecionado! Peso total atual: " + pesoAtual + " MB");

            } else {
                // Se não couber, ignora
                System.out.println("Não cabe no pendrive");
            }
        }

        // 2.4 Retorna a lista com os nomes dos arquivos escolhidos
        return selecionados;
    }

    // ==============================
    // ETAPA 1 – ENTRADA DE DADOS
    // ==============================

    public static void main(String[] args) {
        Scanner dado = new Scanner(System.in);

        // 1.1 Entrada da capacidade do pendrive
        System.out.println("Digite a capacidade do pendrive (em MB): ");
        int capacidadePendrive = dado.nextInt();

        // 1.2 Entrada da quantidade de arquivos
        System.out.println("Digite a quantidade de arquivos: ");
        int quantidadeArquivos = dado.nextInt();

        // 1.3 Criação da lista que armazenará os arquivos
        List<Arquivo> arquivos = new ArrayList<>();

        // 1.4 Entrada dos dados de cada arquivo
        for (int i = 0; i < quantidadeArquivos; i++) {
            System.out.println("Digite os dados do arquivo " + (i + 1) + " :");

            // Entrada do nome
            System.out.println("Nome: ");
            dado.nextLine(); // limpa o buffer do nextInt
            String nome = dado.nextLine();

            // Entrada do número de páginas
            System.out.println("Número de páginas: ");
            int paginas = dado.nextInt();

            // Entrada do peso em MB
            System.out.println("Peso (em MB): ");
            int peso = dado.nextInt();

            // Adiciona o novo arquivo à lista
            arquivos.add(new Arquivo(nome, paginas, peso));

            // ⚠️ ERRO DE LÓGICA AQUI ⚠️
            // A seleção está sendo chamada dentro do loop. Isso deve ocorrer APÓS o preenchimento completo da lista.
            List<String> resultado = selecionarArquivos(capacidadePendrive, arquivos);

            // Exibe os arquivos selecionados
            System.out.println("\nArquivos selecionados:");
            resultado.forEach(System.out::println);
        }
    }
}
