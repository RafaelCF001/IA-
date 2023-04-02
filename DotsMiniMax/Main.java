import java.util.Scanner;
import java.util.Random;

public class Main {
	public  static int plys, rows, cols, maxlines, totallines, p1score, p2score;
	public static int[][] tabuleiro;
	public static Tabuleiro game;
	public static void main (String[] args) {

		plys = 10;

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
					tabuleiro[i][j] = new Random().nextInt(5 - 1 + 1) + 1;
				}
				else if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
					tabuleiro[i][j] = 7;
				}
			}
		}

		p1score = 0;
		p2score = 0;
		game = new Tabuleiro(tabuleiro, rows, cols, p1score, p2score, false, totallines, maxlines);

		String direction = "";
		tabuleiro[0][1] = 9;


		//Main while loop to play the game
		while (game.totallines < game.maxlines) {
			Scanner input = new Scanner(System.in);
			game.aimove = false;

			System.out.println();
			System.out.println("Move: Player 1");
			game.tabuleiro();

			int row = 0;
			int col = 0;
			System.out.println("Choose row to place line in");
			row = input.nextInt();
			System.out.println("Choose col to place line in");
			col = input.nextInt();

			//Making sure user is choosing an "empty line"
			while (game.gettabuleiro()[row][col] != 7) {
				System.out.println("Try again.");
				System.out.println("Choose row to place line in");
				row = input.nextInt();
				System.out.println("Choose col to place line in");
				col = input.nextInt();
			}

			//If the row of line they are placing is even, then it must be a horizontal line
			if (row % 2 == 0) {
				game.gettabuleiro()[row][col] = 9;
				direction = "horizontal";
			}

			//If the row of line they are placing is odd, then it must be a vertical line
			else if (row % 2 != 0) {
				game.gettabuleiro()[row][col] = 11;
				direction = "vertical";
			}

			game.totallines++;

			game.updatescore(row, col, direction);

			//Making sure Player 1 didn't just make the last move, and if not then AI can go. Player 1 goes 1st
			if (game.totallines < game.maxlines) {
				Minimax ai = new Minimax(game, plys);
				game = ai.move();
			}

		}

		System.out.println("Game Over");
		game.tabuleiro();

		System.out.println("Player 1 Score: " + game.ponto1);
		System.out.println("AI Score: " + game.ponto2);

		if (game.ponto1 > game.ponto2) {
			System.out.println("Player 1 Wins.");
		}

		else if (game.ponto1 < game.ponto2) {
			System.out.println("AI Wins.");
		}

		else {
			System.out.println("Draw.");
		}

	}

}