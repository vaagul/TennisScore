package com.bootcamp.tennis_score;

import java.util.ArrayList;
import java.util.List;

public class Player{
	private int sets;
	private int games;
	private int points;
	private char id;
	
	Player(char id){
		this.id = id;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}
	
	public String getPointsToString (Player p){
		List<String> points = new ArrayList<String>();
		points.add("0");
		points.add("15");
		points.add("30");
		points.add("40");
		points.add("DisA.");
		points.add("-");
		points.add("Adv.");

		return points.get( this.getPoints()>3 ?
				(this.getPoints()-p.getPoints() + 5) :
				this.getPoints());

	}
}