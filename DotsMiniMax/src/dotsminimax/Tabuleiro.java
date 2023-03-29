package dotsminimax;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	ArrayList<Jogada> jogadas;
    private ArrayList<Tabuleiro> filhos;
    private int pontuacao;

    public Tabuleiro() {
        this.jogadas = new ArrayList<>();
        this.filhos = new ArrayList<>();
        this.pontuacao = 0; 
    }

    public Tabuleiro(ArrayList<Jogada> jogadas, int pontos) {
        this.jogadas = jogadas;
        this.filhos = new ArrayList<>();
        this.pontuacao = pontos;
    }

    public void gerarFilhos(int jogador) {
        if (jogoAcabou()) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!posicaoOcupada(i, j)) {
                    if (posicaoValida(i, j)) {
                        Jogada novaJogada = new Jogada(i, j, jogador);

                        ArrayList<Jogada> novaLista = new ArrayList<>(jogadas);
                        novaLista.add(novaJogada);

                        Tabuleiro novoTabuleiro = new Tabuleiro(novaLista, pontuacao);
                        int novaPontuacao = pontuacao;

                        // Verifica se houve pontuação
                        if (novaJogada.feitaPonto(novaLista)) {
                            novaPontuacao++;
                        }

                        novoTabuleiro.gerarFilhos(jogador == 1 ? 2 : 1);
                        filhos.add(novoTabuleiro);
                    }
                }
            }
        }
    }
    public int minimax(int depth, boolean isMax, int alpha, int beta) {
        if (jogoAcabou() || depth == 0) {
            return pontuacao;
        }
        System.out.println(isMax);
        if (isMax) {
            int maxEval = Integer.MIN_VALUE;
            for (Tabuleiro filho : filhos) {
                int eval = filho.minimax(depth - 1, false, alpha, beta);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (Tabuleiro filho : filhos) {
                int eval = filho.minimax(depth - 1, true, alpha, beta);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }
   // get the current Tabuleiro given the tabuleiro in the arraylist
    public void getTabuleiroFilho(){
        for(Jogada jogada : jogadas){
            System.out.println(jogada.getLinha() + " " + jogada.getColuna());
        }
    }
    public Jogada melhorMovimento(int jogador, int depth) {
        
        int melhorJogada = -1;
        int melhorPontuacao = jogador == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
    
        for (int i = 0; i < filhos.size(); i++) {
            Tabuleiro filho = filhos.get(i);
            int pontuacaoAtual = filho.minimax(depth - 1, jogador == 2, alpha, beta);
    
            if (jogador == 1 && pontuacaoAtual > melhorPontuacao) {
                melhorPontuacao = pontuacaoAtual;
                melhorJogada = i;
                alpha = Math.max(alpha, melhorPontuacao);
            } else if (jogador == 2 && pontuacaoAtual < melhorPontuacao) {
                melhorPontuacao = pontuacaoAtual;
                melhorJogada = i;
                beta = Math.min(beta, melhorPontuacao);
            }
    
            if (alpha >= beta) {
                break;
            }
        }
        System.out.println("melhor jogada " +melhorJogada);
        return jogadas.get(melhorJogada);
    }
    

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList<Tabuleiro> getFilhos() {
        return filhos;
    }

    public void setFilhos(ArrayList<Tabuleiro> filhos) {
        this.filhos = filhos;
    }

    public ArrayList<Jogada> getJogadas() {
        return jogadas;
    }
    private int getMax(List<Integer> valores) {
        int max = Integer.MIN_VALUE;
        for (int valor : valores) {
            if (valor > max){
                max = valor;
            }
        }
        return max;
    }

    private int getMin(List<Integer> valores) {
        int min = Integer.MAX_VALUE;
        for (int valor : valores) {
            if (valor < min) {
                min = valor;
            }
        }
        return min;
    }
    boolean jogoAcabou() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!posicaoOcupada(i, j) && posicaoValida(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean posicaoOcupada(int linha, int coluna) {
        for (Jogada jogada : jogadas) {
            if (jogada.getLinha() == linha && jogada.getColuna() == coluna) {
                return true;
            }
        }
        return false;
    }

    boolean posicaoValida(int i, int j) {
    	if (i == 1 && (j == 0 || j == 2 || j == 4)) {
            return false;
        }
        if (i == 2 && (j == 0 || j == 2 || j == 4)) {
            return false;
        }
        if (i == 4 && (j == 0 || j == 2 || j == 4)) {
            return false;
        }
        if ((i == 1 && j == 1) || (i == 1 && j == 3) || (i == 3 && j == 1) || (i == 3 && j == 3)) {
            return false;
        }
        return true;

    }
    private ArrayList<Jogada> copiarListaJogadas() {
        ArrayList<Jogada> copia = new ArrayList<>();
        for (Jogada jogada : jogadas) {
            copia.add(new Jogada(jogada.getLinha(), jogada.getColuna(),1));
        }
        return copia;
    }

    
}

