package com.mycompany.ia;
import java.util.ArrayList;

//Each node represents a state and its attributes are stored here
public class Jogada {

	Tabuleiro board;
	Jogada pai;
	int depth;
	ArrayList<Jogada> children;
	int score;
	//Constructor for Node, initialized with the board
	Jogada (Tabuleiro board) {
		this.board = board;
	}

	//Sets the pai for current node
	public void setpai (Jogada pai) {
        this.pai = pai;
    }

	//Adds a child of current node
	public void addChild(Jogada current) {
    	this.children.add(current);
    }

}
