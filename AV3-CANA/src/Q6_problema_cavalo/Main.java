package Q6_problema_cavalo;

public class Main {
    public static void main(String[] args) {

        KnightTour cavalo = new KnightTour();

        // Cria o tabuleiro e inicializa com -1 (não visitado)
        int[][] tabuleiro = new int[cavalo.tamanhoTabuleiro][cavalo.tamanhoTabuleiro];
        for (int i = 0; i < cavalo.tamanhoTabuleiro; i++) {
            for (int j = 0; j < cavalo.tamanhoTabuleiro; j++) {
                tabuleiro[i][j] = -1;
            }
        }

        // Define posição inicial (0,0) e marca como primeiro movimento (0)
        int inicioX = 0, inicioY = 0;
        tabuleiro[inicioX][inicioY] = 0;

        // Chama o método recursivo para tentar resolver o passeio do cavalo
        if (cavalo.resolver(tabuleiro, inicioX, inicioY, 1)) {
            // Se encontrou solução, imprime o tabuleiro
            cavalo.imprimirTabuleiro(tabuleiro);
        } else {
            // Se não encontrou solução, imprime mensagem de erro
            System.out.println("Não foi possível encontrar uma solução :)");
        }
    }
}
