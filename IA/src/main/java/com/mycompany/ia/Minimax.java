package com.mycompany.ia;

import java.util.ArrayList;
import java.util.List;

public class Minimax {

	Tabuleiro game;
	int plys;

	//Constructor for class, initialized with current state of board after Player 1 makes a move, and the plys AI can search ahead
	Minimax (Tabuleiro game, int plys) {
		this.game = game;
		this.plys = plys;
		this.game.aimove = true;

	}

	//Move is called from main to initiate AI Move
	public Tabuleiro move(String modo) {
    Jogada move = null;
    Jogada current = new Jogada(game);

    for (int depthLimit = 1; depthLimit <= plys; depthLimit++) {
        Jogada minimax = search(current, 0, depthLimit, modo);
        if (minimax != null) {
            move = getMove(minimax);
            break;
        }
    }

    if (move == null) {
        move = getHighestImmediateScoreMove(current, plys,modo);
    }

    return move.board;
}


        // Method to get the move with the highest immediate score
		public Jogada getHighestImmediateScoreMove(Jogada current, int plys,String modo) {
			
			Jogada bestMove = search(current, 0, plys,modo);
			return bestMove;
		}
		

	//Recursive Minimax Search, returns Node at max depth
	public Jogada search (Jogada current, int depth, int plys,String modo) {

		//Checks if we are at the max depth/ply, or if board is complete
		if (depth >plys || current.board.totallines == current.board.maxlines) {
			return current;
		}

		boolean ai = false;

		//At every other depth moves alternate between Player and AI
		if (depth % 2 == 0) {
			ai = false;
		}

		//Gets successors of current node (possible moves)
		List<Jogada> children = getSuccessors(current, ai);
		Jogada tmp = null;

		//If its AI's depth/move, find the max node based on the difference in scores
		if (current.board.isAIMove()) {
			Integer value = Integer.MIN_VALUE;

			for (Jogada child : children) {
				//Runs evaluation function

				//Recurses down tree until max depth is reached for a child, then does comparisons
				Jogada x = search(child, depth + 1, plys,modo);
				// Inside the search method, in the AI's depth/move part
				if (x != null && x.board.difference > value) {
					tmp = x;
					value = x.board.difference;
					// If the AI finds a winning state, stop searching
					if (value >= 1000000) {
						break;
					}
				}

				// Inside the search method, in the Player's depth/move part
				if (x != null && x.board.difference < value) {
					tmp = x;
					value = x.board.difference;
					// If the AI finds a state where the opponent wins, stop searching
					if (value <= -1000000) {
						break;
					}
				}

			}
			return tmp;
		}

		//If its Player's depth/move, find the min node based on the difference in scores
		else {

			Integer value = Integer.MAX_VALUE;

			for (Jogada child : children) {
				if(modo.equals("Heuristica")){
					child.board.evaluate();
				}
				else {
				child.board.evaluate();
				}
				Jogada x = search(child, depth + 1, plys,modo);
				
				if (x != null && x.board.difference < value) {
					tmp = x;
					value = x.board.difference;
				}
			}
			return tmp;
		}

	}

	//Starts with the Node returned by Search and traverses up the tree by pais, stopping before the "root" to give us the move to make
	public Jogada getMove (Jogada current) {

		Jogada tmp = current;

		while (tmp != null&&tmp.pai != null &&tmp.pai.pai != null) {
			tmp = tmp.pai;
		}

		return tmp;
	}
        public int[] findAIMove(Tabuleiro oldBoard, Tabuleiro newBoard) {
            int[][] oldState = oldBoard.gettabuleiro();
            int[][] newState = newBoard.gettabuleiro();

            for (int i = 0; i < oldState.length; i++) {
                for (int j = 0; j < oldState[i].length; j++) {
                    if (oldState[i][j] != newState[i][j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return null; // This should not happen if the AI has made a move
        }


	//Gets List of successors of a Node
	public List<Jogada> getSuccessors(Jogada state, boolean value) {

		List<Jogada> children = new ArrayList<>();
		Tabuleiro x = state.board;
		int rows = x.rows;
		int cols = x.cols;

		int[][] board = x.gettabuleiro();

		//Iterates over every position in current board
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j++) {

				//If row is even and column is odd, and is "empty line"
				if ((i % 2 == 0 && j % 2 != 0) && board[i][j] == 7) {
					int[][] temp = copyArray(board, rows, cols);

					//Changes "empty line" to "h line"
					temp[i][j] = 9;
					Tabuleiro tmp = new Tabuleiro(temp, x.rows, x.cols, x.ponto1, x.ponto2, true, x.totallines, x.maxlines);
					tmp.updatescore(i, j, "h");
					tmp.totallines++;
					Jogada child = new Jogada(tmp);
					child.setpai(state);
					children.add(child);
				}
				//If row is odd and column is even, and is "empty line"
				else if ((i % 2 != 0 && j % 2 == 0) && board[i][j] == 7) {
					int[][] temp = copyArray(board, rows, cols);

					//Changes "empty line" to "v"
					temp[i][j] = 11;
					Tabuleiro tmp = new Tabuleiro(temp, x.rows, x.cols, x.ponto1, x.ponto2, true, x.totallines, x.maxlines);
					tmp.updatescore(i, j, "v");
					tmp.totallines++;
					Jogada child = new Jogada(tmp);
					child.setpai(state);
					children.add(child);
				}
			}
		}

		return children;
	}

	//Function to make a copy of a 2D Array
	public int[][] copyArray (int[][] state, int rows, int cols) {

		int[][] temp = new int[rows][cols];

		for (int i = 0; i < rows; i ++) {
			for(int j = 0; j < cols; j++) {
				temp[i][j] = state[i][j];
			}
		}

		return temp;

	}

}