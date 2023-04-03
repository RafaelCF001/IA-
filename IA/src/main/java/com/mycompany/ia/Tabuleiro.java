package com.mycompany.ia;
public class Tabuleiro {

	int[][] tabuleiro;
	int rows,cols,maxlines,ponto1,ponto2,totallines,difference;
	boolean aimove;

	public void updateTotallines () {
		this.totallines++;
	}

	public
	Tabuleiro (int[][] tabuleiro, int rows, int cols, int ponto1, int ponto2, boolean aimove, int totallines, int maxlines) {
		this.rows = rows;
		this.cols = cols;
		this.ponto1 = ponto1;
		this.ponto2 = ponto2;
		this.aimove = aimove;
		this.tabuleiro = tabuleiro;
		this.totallines = totallines;
		this.maxlines = maxlines;
	}
	public int[][] gettabuleiro () {
		return this.tabuleiro;
	}

	public void updateponto1 (int score) {
		this.ponto1 += score;
	}

	public void updateponto2 (int score) {
		this.ponto2 += score;
	}

	public boolean isAIMove () {
		return this.aimove;
	}
	public boolean isAIWinner(){
		return this.ponto2>this.ponto1;
	}
	public boolean isOpponentWinner(){
		return this.ponto1>this.ponto2;
	}
	public void evaluate(String modo) {
		this.difference = ponto2 - ponto1;
	}
	public void evaluate() {
                if (isAIWinner()) {
                    this.difference = 1;
                } else if (isOpponentWinner()) {
                    this.difference = -1; 
                } else {
                   this.difference = 0;
                }
	}
	

	public void tabuleiro() {

		for (int i = 0; i < rows; i++ ) {
			for (int j = 0; j < cols; j ++) {
				if (tabuleiro[i][j] == 0) {
					System.out.print("." + " ");
				}
				else if (tabuleiro[i][j] ==  1){
					System.out.print(" " + " ");
				}
				else if (tabuleiro[i][j] == 2) {
					System.out.print("-" + " ");
				}
				else if (tabuleiro[i][j] == 3) {
					System.out.print("|" + " ");
				}
				else {
					System.out.print(tabuleiro[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void updatescore (int row, int col, String direction) {

		if (direction.equals("h")) {
			if (row < 1 || col < 1 || row >= rows || col >= cols) {
				return;
			}
			if (row == 0) {
				if (tabuleiro[row+1][col-1] == 3 && tabuleiro[row+1][col+1] == 3 && tabuleiro[row+2][col] == 2) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

			else if (row == rows - 1) {
				if (tabuleiro[row-1][col-1] == 3 && tabuleiro[row-1][col+1] == 3 && tabuleiro[row-2][col] == 2) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

			else {
				if (tabuleiro[row+1][col-1] == 3 && tabuleiro[row+1][col+1] == 3 && tabuleiro[row+2][col] == 2) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
				if (tabuleiro[row-1][col-1] == 3 && tabuleiro[row-1][col+1] == 3 && tabuleiro[row-2][col] == 2) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

		}

		else if (direction.equals("v")) {

			if (col == 0) {
				if (tabuleiro[row-1][col+1] == 2 && tabuleiro[row+1][col+1] == 2 && tabuleiro[row][col+2] == 3) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

			else if (col == cols - 1) {
				if (tabuleiro[row-1][col-1] == 2 && tabuleiro[row+1][col-1] == 2 && tabuleiro[row][col-2] == 3) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

			else {
				if (tabuleiro[row-1][col+1] == 2 && tabuleiro[row+1][col+1] == 2 && tabuleiro[row][col+2] == 3) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}

				if (tabuleiro[row-1][col-1] == 2 && tabuleiro[row+1][col-1] == 2 && tabuleiro[row][col-2] == 3) {
					if (aimove) {
						updateponto2(1);
					}
					else {
						updateponto1(1);
					}
				}
			}

		}
	}

}