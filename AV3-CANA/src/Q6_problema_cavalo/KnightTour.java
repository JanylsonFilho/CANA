package Q6_problema_cavalo;

public class KnightTour {


    public int tamanhoTabuleiro = 8;

    // Possíveis movimentos horizontais do cavalo
    public int[] movimentoX = {2, 1, -1, -2, -2, -1, 1, 2};

    // Possíveis movimentos verticais do cavalo
    public int[] movimentoY = {1, 2, 2, 1, -1, -2, -2, -1};

    // Função principal que tenta resolver o problema a partir da posição (x, y)
    public boolean resolver(int[][] tabuleiro, int x, int y, int contagemMovimentos) {
        // Se o número de movimentos atingir o total de casas do tabuleiro, a solução foi encontrada
        if (contagemMovimentos == tamanhoTabuleiro * tamanhoTabuleiro) {
            return true;
        }

        // Tenta todos os 8 movimentos possíveis do cavalo
        for (int i = 0; i < 8; i++) {
            int proximoX = x + movimentoX[i]; // Calcula o próximo X
            int proximoY = y + movimentoY[i]; // Calcula o próximo Y

            // Verifica se a próxima posição é válida e ainda não visitada
            if (estaSeguro(tabuleiro, proximoX, proximoY)) {
                // Marca o número do movimento atual na posição
                tabuleiro[proximoX][proximoY] = contagemMovimentos;

                // Chama recursivamente para o próximo movimento
                if (resolver(tabuleiro, proximoX, proximoY, contagemMovimentos + 1)) {
                    return true;
                } else {
                    // Se não for possível avançar, desfaz o movimento (backtracking)
                    tabuleiro[proximoX][proximoY] = -1;
                }
            }
        }

        // Nenhum movimento válido encontrado, retorna false para retroceder
        return false;
    }

    // Imprime o tabuleiro com a ordem dos movimentos do cavalo
    public void imprimirTabuleiro(int[][] tabuleiro) {
        System.out.println("Solução do problema da caminhada do cavalo:");
        for (int[] linha : tabuleiro) {
            for (int valor : linha) {
                // Imprime cada valor com largura fixa de 2 dígitos
                System.out.printf("%2d ", valor);
            }
            System.out.println();
        }
    }

    // Verifica se a posição está dentro dos limites e ainda não foi visitada
    public boolean estaSeguro(int[][] tabuleiro, int x, int y) {
        return (x >= 0 && x < tamanhoTabuleiro &&
                y >= 0 && y < tamanhoTabuleiro &&
                tabuleiro[x][y] == -1);
    }
}

