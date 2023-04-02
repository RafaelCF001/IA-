//Each Board will hold information of the current tabuleiro
public class Tabuleiro {

	int[][] tabuleiro;
	int rows,cols,maxlines,ponto1,ponto2,totallines,difference;
	boolean aimove;

	//Constructor for Board
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

	//Returns the tabuleiro, as a 2D array
	public int[][] gettabuleiro () {
		return this.tabuleiro;
	}

	//Updates Player Score
	public void updateponto1 (int score) {
		this.ponto1 += score;
	}

	//Updates AI Score
	public void updateponto2 (int score) {
		this.ponto2 += score;
	}

	//Checks if current move is a move for AI
	public boolean isAIMove () {
		return this.aimove;
	}

	//Evaluates the current board
	public void evaluate () {
		this.difference = this.ponto2 - this.ponto1;
	}

	/* These numbers will be used to represent things in the array
	 * 0 = dot
	 * 7 = blank space
	 * 9 = horizontal line
	 * 11 = vertical line
	 */

	//Prints the board
	public void tabuleiro() {

		for (int i = 0; i < rows; i++ ) {
			for (int j = 0; j < cols; j ++) {
				if (tabuleiro[i][j] == 0) {
					System.out.print("." + " ");
				}
				else if (tabuleiro[i][j] == 7){
					System.out.print(" " + " ");
				}
				else if (tabuleiro[i][j] == 9) {
					System.out.print("-" + " ");
				}
				else if (tabuleiro[i][j] == 11) {
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

	//Runs through the board after a move has been and checks if score needs to be updated
	public void updatescore (int row, int col, String direction) {

		if (direction.equals("horizontal")) {
			if (row < 1 || col < 1 || row >= rows || col >= cols) {
				return;
			}
			//If horizontal line is placed anywhere at the top of the board, then it just has to check if a box has been made below
			if (row == 0) {
				if (tabuleiro[row+1][col-1] == 11 && tabuleiro[row+1][col+1] == 11 && tabuleiro[row+2][col] == 9) {
					if (aimove) {
						updateponto2(tabuleiro[row+1][col]);
					}
					else {
						updateponto1(tabuleiro[row+1][col]);
					}
				}
			}

			//If horizontal line is placed anywhere at the bottom of the board, then it just has to check if a box has been made above
			else if (row == rows - 1) {
				if (tabuleiro[row-1][col-1] == 11 && tabuleiro[row-1][col+1] == 11 && tabuleiro[row-2][col] == 9) {
					if (aimove) {
						updateponto2(tabuleiro[row-1][col]);
					}
					else {
						updateponto1(tabuleiro[row-1][col]);
					}
				}
			}

			//If horizontal line is placed anywhere else on the board, then it has to check if a box has been made above or below
			else {
				if (tabuleiro[row+1][col-1] == 11 && tabuleiro[row+1][col+1] == 11 && tabuleiro[row+2][col] == 9) {
					if (aimove) {
						updateponto2(tabuleiro[row+1][col]);
					}
					else {
						updateponto1(tabuleiro[row+1][col]);
					}
				}
				if (tabuleiro[row-1][col-1] == 11 && tabuleiro[row-1][col+1] == 11 && tabuleiro[row-2][col] == 9) {
					if (aimove) {
						updateponto2(tabuleiro[row-1][col]);
					}
					else {
						updateponto1(tabuleiro[row-1][col]);
					}
				}
			}

		}

		//If vertical line is placed anywhere at the very left of the board, then it just has to check if a box has been to the right
		else if (direction.equals("vertical")) {

			if (col == 0) {
				if (tabuleiro[row-1][col+1] == 9 && tabuleiro[row+1][col+1] == 9 && tabuleiro[row][col+2] == 11) {
					if (aimove) {
						updateponto2(tabuleiro[row][col+1]);
					}
					else {
						updateponto1(tabuleiro[row][col+1]);
					}
				}
			}

			//If vertical line is placed anywhere at the very right of the board, then it just has to check if a box has been to the left
			else if (col == cols - 1) {
				if (tabuleiro[row-1][col-1] == 9 && tabuleiro[row+1][col-1] == 9 && tabuleiro[row][col-2] == 11) {
					if (aimove) {
						updateponto2(tabuleiro[row][col-1]);
					}
					else {
						updateponto1(tabuleiro[row][col-1]);
					}
				}
			}

			//If vertical line is placed anywhere else on the board, then it has to check if a box has been to the right or left
			else {
				if (tabuleiro[row-1][col+1] == 9 && tabuleiro[row+1][col+1] == 9 && tabuleiro[row][col+2] == 11) {
					if (aimove) {
						updateponto2(tabuleiro[row][col+1]);
					}
					else {
						updateponto1(tabuleiro[row][col+1]);
					}
				}

				if (tabuleiro[row-1][col-1] == 9 && tabuleiro[row+1][col-1] == 9 && tabuleiro[row][col-2] == 11) {
					if (aimove) {
						updateponto2(tabuleiro[row][col-1]);
					}
					else {
						updateponto1(tabuleiro[row][col-1]);
					}
				}
			}

		}
	}

}