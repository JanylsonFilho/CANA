package Q1_problema_8_damas;

public class OitoDamas {

    // Método principal que inicia o processo de resolução com N fixado
    public void resolver8Damas() {
        int N = 8; // Tamanho fixo do tabuleiro
        int[][] tabuleiro = new int[N][N];

        // Inicializa o tabuleiro com zeros (sem rainhas)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = 0;
            }
        }

        // Inicia o algoritmo de backtracking
        if (resolver(tabuleiro, 0, N)) {
            System.out.println("Solução encontrada!");
            imprimirTabuleiro(tabuleiro, N);
            imprimirPosicoesRainhas(tabuleiro, N);
        } else {
            System.out.println("Não há solução para 8 damas.");
        }
    }

    // Algoritmo de backtracking
    private boolean resolver(int[][] tabuleiro, int linha, int N) {
        if (linha == N) {
            return true; // Solução completa
        }

        for (int coluna = 0; coluna < N; coluna++) {
            if (podeColocarRainha(tabuleiro, linha, coluna, N)) {
                tabuleiro[linha][coluna] = 1;

                if (resolver(tabuleiro, linha + 1, N)) {
                    return true;
                }

                // Backtracking: remove a rainha e exibe mensagem
                tabuleiro[linha][coluna] = 0;
                System.out.println("Backtrack: removendo rainha da linha " + (linha + 1) + ", coluna " + (coluna + 1));
            }
        }

        return false; // Nenhuma posição válida
    }

    // Verifica se a posição é segura para colocar rainha
    private boolean podeColocarRainha(int[][] tabuleiro, int linha, int coluna, int N) {
        for (int i = 0; i < linha; i++) {
            if (tabuleiro[i][coluna] == 1) return false;
        }

        for (int i = linha - 1, j = coluna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) return false;
        }

        for (int i = linha - 1, j = coluna + 1; i >= 0 && j < N; i--, j++) {
            if (tabuleiro[i][j] == 1) return false;
        }

        return true;
    }

    // Imprime o tabuleiro com Q e .
    private void imprimirTabuleiro(int[][] tabuleiro, int N) {
        System.out.println("\nTabuleiro final:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tabuleiro[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    // Imprime as posições das rainhas
    private void imprimirPosicoesRainhas(int[][] tabuleiro, int N) {
        System.out.println("\nPosições das rainhas (linha, coluna):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tabuleiro[i][j] == 1) {
                    System.out.println("Rainha na linha " + (i + 1) + ", coluna " + (j + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        OitoDamas problema = new OitoDamas();
        problema.resolver8Damas();
    }
}
