package dotsminimax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) {
	
	    int[][] tabuleiro = {
	            {0, 1, 0, 2, 0},
	            {0, 0, 0, 0, 0},
	            {0, 0, 0, 0, 0},
	            {0, 0, 0, 0, 0},
	            {0, 0, 0, 0, 0}
	    };
	    ArrayList<Jogada> jogadas = new ArrayList<>();
	    Tabuleiro tab = new Tabuleiro(jogadas);
	    Jogada jogada1 = new Jogada(0,1);
	    Jogada jogada2 = new Jogada(0,3);
	    tab.jogadas.add(jogada1);
	    tab.jogadas.add(jogada2);
	    
	    tab.gerarFilhos(1);

	    System.out.println("Quantidade de filhos gerados: " + tab.filhos.size());
	    System.out.println("Filho: " + tab.filhos.get(0).filhos.size());
	
}
}
