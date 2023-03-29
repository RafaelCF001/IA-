package dotsminimax;

import java.util.ArrayList;

public class Jogada {
	private int linha;
    private int coluna;
    private int player;

    public Jogada(int linha, int coluna, int player) {
        this.linha = linha;
        this.coluna = coluna;
        this.player = player;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    public boolean feitaPonto(ArrayList<Jogada> jogadas) {
        int linha = this.linha;
        int coluna = this.coluna;
        int jogador = this.player;
        int[][] tabuleiro = new int[8][8];
        for (Jogada jogada : jogadas) {
            tabuleiro[jogada.linha][jogada.coluna] = jogada.player;
        }
        int pontoInicial = jogador == 1 ? 0 : 7;
        int direcao = jogador == 1 ? 1 : -1;
        boolean fezPonto = false;
        if (linha == pontoInicial && tabuleiro[linha + direcao][coluna] != jogador) {
            if (tabuleiro[linha + direcao][coluna] != 0 && tabuleiro[linha + 2*direcao][coluna] == jogador) {
                fezPonto = true;
            }
        }
        return fezPonto;
    }

}
