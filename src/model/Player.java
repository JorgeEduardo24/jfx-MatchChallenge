package model;

import java.io.Serializable;

public class Player implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int score = 0;
	
	private Player left;
	private Player right;
	private Player up;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getLeft() {
		return left;
	}

	public void setLeft(Player left) {
		this.left = left;
	}

	public Player getRight() {
		return right;
	}

	public void setRight(Player right) {
		this.right = right;
	}

	public Player getUp() {
		return up;
	}

	public void setUp(Player up) {
		this.up = up;
	}
	
	
	@Override
	public String toString() {
		return getName();
	}
	
}
