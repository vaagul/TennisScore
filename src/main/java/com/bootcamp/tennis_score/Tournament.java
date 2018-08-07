package com.bootcamp.tennis_score;

import java.util.ArrayList;
import java.util.List;

class Tournament{
	private int sets;
	private int games;
	private int points;
	private char id;
	
	Tournament(char id){
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
}

public class Tournament {

	private Tournament p1;
	private Tournament p2;

	Tournament(char p1Id,char p2Id){
		p1 = new Tournament(p1Id);
		p2 = new Tournament(p2Id);
	}

	private Tournament getWinner(char winner){
        if (winner == p1.getId()) return p1;
        else return p2;
    }

	private Tournament getLooser(char winner){
        if (winner != p1.getId()) return p1;
        else return p2;
    }

	private void updateSets(char winner){

		Tournament winnerPlayer = getWinner(winner);
		winnerPlayer.setSets(winnerPlayer.getSets()+1);
	}

	private void updateGames(char winner){
		Tournament winnerPlayer = getWinner(winner);
		winnerPlayer.setGames(winnerPlayer.getGames() +1 );

		if( Math.abs(p1.getGames()-p2.getGames()) >= 2 && winnerPlayer.getGames() >= 6 ){
			updateSets( winnerPlayer.getId() );
			p1.setGames(0);
			p2.setGames(0);
		}

	}

	public void updatePoints(char winner){
		List<Integer> points = new ArrayList<Integer>();
        points.add(0); //0
        points.add(15); //1
        points.add(30); //2
        points.add(40); //3
        points.add(50); //4

        Tournament win = getWinner(winner);
        Tournament loos = getLooser(winner);

//        if (win.getPoints() <= 30){
//
//            win.setPoints(points.get(points.indexOf(win.getPoints()) + 1));
//
//        } else if (win.getPoints() == 40 && loos.getPoints() <= 30){
//
//            win.setPoints(0);
//            loos.setPoints(0);
//            updateGames(winner);
//
//        } else if (win.getPoints() == 30 && loos.getPoints() == 40){
//
//            win.setPoints(40);
//
//        } else if(win.getPoints() == 40 && loos.getPoints() == 40){
//
//            win.setPoints(50);
//
//        } else if(win.getPoints() == 50 && loos.getPoints() == 40){
//
//            win.setPoints(0);
//            loos.setPoints(0);
//            updateGames(winner);
//
//        } else if(win.getPoints() == 40 && loos.getPoints() == 50){
//
//            win.setPoints(40);
//            loos.setPoints(40);
//
//        }

        if (win.getPoints() - loos.getPoints() >=10 && win.getPoints() >= 40){
            win.setPoints(0);
            loos.setPoints(0);
            updateGames(winner);
        } else if (win.getPoints() <= 30) {
            win.setPoints(points.get(points.indexOf(win.getPoints()) + 1));
        } else if (loos.getPoints() == 40){
            win.setPoints(50);
        } else {
            loos.setPoints(40);
        }

	}

	public void printScore(){
		System.out.println("player:    " + p1.getId() +"    " + p2.getId());
		System.out.println(String.format("sets:    %3d  %3d",p1.getSets(),p2.getSets()));
		System.out.println(String.format("games:   %3d  %3d",p1.getGames(),p2.getGames()));
		System.out.println(String.format("points:  %3d  %3d",p1.getPoints(),p2.getPoints()));
	}

	public static void main(String args[]){
		String input = "ABABABAAB";
		Tournament t = new Tournament('A','B');

		for(int itr = 0; itr < input.length(); itr++){
			t.updatePoints(input.charAt(itr));
		}
		t.printScore();
	}

}