package Q10_caixeiro_viajante;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaixeiroViajante {

    // Número total de cidades fixado como 10
    private static final int NUM_CIDADES = 10;

    // Lista que irá armazenar as coordenadas (x, y) de cada cidade
    private static List<int[]> cidades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Etapa 1: Entrada manual das coordenadas das cidades
        gerarCidadesManualmente(scanner);

        // Mostra as cidades digitadas
        System.out.println("Cidades:");
        for (int i = 0; i < NUM_CIDADES; i++) {
            System.out.println("Cidade " + i + ": (" + cidades.get(i)[0] + ", " + cidades.get(i)[1] + ")");
        }

        // Cria uma lista com os índices de todas as cidades
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < NUM_CIDADES; i++) {
            indices.add(i);
        }

        double menorDistancia = Double.MAX_VALUE; // Armazena a menor distância encontrada
        List<Integer> melhorPercurso = null;      // Armazena o melhor percurso correspondente

        // Etapa 2: Gera todas as permutações possíveis das cidades
        List<List<Integer>> permutacoes = gerarPermutacoes(indices);

        // Etapa 3: Avalia a distância de cada permutação e salva a melhor
        for (List<Integer> percurso : permutacoes) {
            double distanciaTotal = calcularDistancia(percurso);
            if (distanciaTotal < menorDistancia) {
                menorDistancia = distanciaTotal;
                melhorPercurso = new ArrayList<>(percurso);
            }
        }

        // Etapa 4: Exibe o melhor percurso encontrado e sua distância
        System.out.println("\nMelhor percurso:");
        if (melhorPercurso != null) {
            for (int cidade : melhorPercurso) {
                System.out.print(cidade + " -> ");
            }
            // Retorna à cidade de origem
            System.out.println(melhorPercurso.get(0));
        }
        System.out.println("Menor distância: " + menorDistancia);

        scanner.close();
    }

    // Método para ler manualmente as coordenadas das cidades
    private static void gerarCidadesManualmente(Scanner scanner) {
        System.out.println("Digite as coordenadas (x, y) das " + NUM_CIDADES + " cidades:");
        for (int i = 0; i < NUM_CIDADES; i++) {
            System.out.print("Cidade " + i + " - Coordenada X: ");
            int x = scanner.nextInt();
            System.out.print("Cidade " + i + " - Coordenada Y: ");
            int y = scanner.nextInt();
            cidades.add(new int[]{x, y}); // Armazena como array [x, y]
        }
    }

    // Calcula a distância total de um percurso completo (ida + volta)
    private static double calcularDistancia(List<Integer> percurso) {
        double distanciaTotal = 0;

        // Soma a distância entre cada par de cidades consecutivas
        for (int i = 0; i < percurso.size() - 1; i++) {
            distanciaTotal += distancia(cidades.get(percurso.get(i)), cidades.get(percurso.get(i + 1)));
        }

        // Soma a distância de volta para a cidade inicial
        distanciaTotal += distancia(cidades.get(percurso.get(percurso.size() - 1)), cidades.get(percurso.get(0)));

        return distanciaTotal;
    }

    // Calcula a distância Euclidiana entre duas cidades
    private static double distancia(int[] cidade1, int[] cidade2) {
        return Math.sqrt(Math.pow(cidade1[0] - cidade2[0], 2) + Math.pow(cidade1[1] - cidade2[1], 2));
    }

    // Gera todas as permutações possíveis de uma lista de cidades
    private static List<List<Integer>> gerarPermutacoes(List<Integer> lista) {
        List<List<Integer>> permutacoes = new ArrayList<>();
        permutacoesHelper(lista, new ArrayList<>(), permutacoes);
        return permutacoes;
    }

    // Método recursivo auxiliar para gerar permutações de forma backtracking
    private static void permutacoesHelper(List<Integer> lista, List<Integer> parcial, List<List<Integer>> permutacoes) {
        if (lista.isEmpty()) {
            permutacoes.add(new ArrayList<>(parcial)); // Adiciona permutação completa
            return;
        }

        // Para cada elemento, gera uma nova ramificação de permutação
        for (int i = 0; i < lista.size(); i++) {
            List<Integer> novaLista = new ArrayList<>(lista);
            novaLista.remove(i); // Remove o elemento atual
            parcial.add(lista.get(i)); // Adiciona à permutação parcial

            // Chamada recursiva
            permutacoesHelper(novaLista, parcial, permutacoes);

            // Backtracking: remove o último adicionado para tentar outro caminho
            parcial.remove(parcial.size() - 1);
        }
    }
}

