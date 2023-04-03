package com.mycompany.ia;

import java.util.Random;

public class Main {
        public int contador = 1;
        public int[] jogadas;
	public   int plys, rows, cols, maxlines, totallines, p1score, p2score;
	public  int[][] tabuleiro;
	public  Tabuleiro game;
        public String direction;
        
        public void iniciaTabuleiro(){

		rows = 2;

		cols = 2;

		rows = rows * 2 + 1;
		cols = cols * 2 + 1;

		maxlines = (rows * cols) / 2;
		totallines = 0;


		tabuleiro = new int[rows][cols];

		// gerando tabuleiro
		for (int i = 0; i < rows; i++ ) {
			for (int j = 0; j < cols; j ++) {

				if (i % 2 != 0 && j % 2 != 0) {
					tabuleiro[i][j] = -1;
				}
				else if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
					tabuleiro[i][j] = 1;
				}
			}
		}

		p1score = 0;
		p2score = 0;
		game = new Tabuleiro(tabuleiro, rows, cols, p1score, p2score, false, totallines, maxlines);

		direction = "";
		tabuleiro[0][1] = 9;

        }
        
	public int[] main (String modo, String nivel, int linha, int coluna) {
            jogadas = new int[12];
             contador++;
             if(contador > 11){
                System.out.println("ACabou");
            }
            plys = Integer.parseInt(nivel);

           

            game.aimove = false;

            game.tabuleiro();

            int row = 0;
            int col = 0;
            row = linha; //qual o botao apertado? 
            col = coluna;// qual o botao apertado? 



            if (row % 2 == 0) {
                    game.gettabuleiro()[row][col] = 9;
                    direction = "h";
            }

            else if (row % 2 != 0) {
                    game.gettabuleiro()[row][col] = 11;
                    direction = "v";
            }

            game.totallines++;

            game.updatescore(row, col, direction);
            
            if(game.ponto1 > p1score){
                p1score = game.ponto1;
                int[] var = {0,0}; 
                return var;
            }
            
            
            Minimax ai = new Minimax(game,plys);
            Tabuleiro novogame = ai.move(modo);
             game.tabuleiro();
            int[] aiMove = ai.findAIMove(game, novogame);
            System.out.println("AI move: " + aiMove[0] + " " + aiMove[1]);
            contador++;
            jogadas[0] = aiMove[0];
            jogadas[1] = aiMove[1];
            int i = 2;
           game = novogame;
            while(game.ponto2 > p2score|| contador > 11){
                game.totallines++;
                contador++;
                System.out.println("Contador " + contador);
                if(contador > 12){
                    break;
                }
                p2score = game.ponto2;
                 ai = new Minimax(game,plys);
                 novogame = ai.move(modo);
                 
                aiMove = ai.findAIMove(game, novogame);
                System.out.println("AI move: " + aiMove[0] + " " + aiMove[1]);
                game = novogame;
                jogadas[i] = aiMove[0];
                jogadas[i+1] = aiMove[1];
                i = i+ 2;
                game.tabuleiro();
                System.out.println("P2 ponto");
                
            }
            System.out.println("Total linha " + game.totallines + " Max linha " + game.maxlines);
            if(jogadas[3]!= 0 &&  jogadas[4]!= 0){
                

                return jogadas;
            }
            
           System.out.println("AI move: " + aiMove[0] + " " + aiMove[1]); 
           return aiMove;
            
	}

}