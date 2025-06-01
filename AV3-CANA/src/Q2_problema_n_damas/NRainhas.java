package Q2_problema_n_damas;



import java.util.Scanner;

public class NRainhas {

    // Método principal que inicia o processo de resolução
    public void Nrainhas(int N) {
        int[][] tabuleiro = new int[N][N];

        // Inicializa o tabuleiro com zeros (sem rainhas)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        // Inicia o algoritmo de backtracking a partir da linha 0
        if (resolver(tabuleiro, 0, N)) {
            System.out.println("Solução encontrada!");
            imprimirTabuleiro(tabuleiro, N);         // Mostra o tabuleiro final
            imprimirPosicoesRainhas(tabuleiro, N);   // Mostra as posições de cada rainha
        } else {
            System.out.println("Não há solução para " + N + " rainhas.");
        }
    }


    private boolean resolver(int[][] tabuleiro, int linha, int N) {
        // Caso base: se colocamos rainhas em todas as linhas, achamos uma solução
        if (linha == N) {
            return true;
        }

        // Tenta colocar a rainha em cada coluna da linha atual
        for (int coluna = 0; coluna < N; coluna++) {
            // Verifica se é seguro colocar uma rainha nessa posição
            if (podeColocarRainha(tabuleiro, linha, coluna, N)) {
                tabuleiro[linha][coluna] = 1; // Coloca a rainha

                // Chama recursivamente para a próxima linha
                if (resolver(tabuleiro, linha + 1, N)) {
                    return true;
                }

                // Se não funcionar, remove a rainha (backtracking)
                tabuleiro[linha][coluna] = 0;
            }
        }

        // Nenhuma posição segura encontrada nessa linha
        return false;
    }


    private boolean podeColocarRainha(int[][] tabuleiro, int linha, int coluna, int N) {
        // Verifica se há rainha na mesma coluna acima
        for (int i = 0; i < linha; i++) {
            if (tabuleiro[i][coluna] == 1) {
                return false;
            }
        }

        // Verifica diagonal superior à esquerda
        for (int i = linha - 1, j = coluna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        // Verifica diagonal superior à direita
        for (int i = linha - 1, j = coluna + 1; i >= 0 && j < N; i--, j++) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        // Nenhuma ameaça detectada
        return true;
    }


    private void imprimirTabuleiro(int[][] tabuleiro, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tabuleiro[i][j] == 1) {
                    System.out.print("Q "); // Q = rainha
                } else {
                    System.out.print(". "); // . = espaço vazio
                }
            }
            System.out.println(); // nova linha
        }
    }

    private void imprimirPosicoesRainhas(int[][] tabuleiro, int N) {
        System.out.println("Posições das rainhas (linha, coluna):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tabuleiro[i][j] == 1) {
                    System.out.println("Rainha na linha " + (i + 1) + ", coluna " + (j + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        NRainhas problema = new NRainhas(); // Cria instância da classe
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o tamanho do tabuleiro:");
        int t = sc.nextInt(); // Ex: 8

        problema.Nrainhas(t);

        sc.close();
    }
}
