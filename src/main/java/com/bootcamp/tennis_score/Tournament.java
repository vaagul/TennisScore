package com.bootcamp.tennis_score;


public class Tournament {

	private Player p1;
	private Player p2;

	Tournament(char p1Id,char p2Id){
		p1 = new Player(p1Id);
		p2 = new Player(p2Id);
	}

	private Player getWinner(char winner){
        if (winner == p1.getId()) return p1;
        else return p2;
    }

	private Player getLooser(char winner){
        if (winner != p1.getId()) return p1;
        else return p2;
    }

	private void updateSets(char winner){
		Player winnerPlayer = getWinner(winner);
		winnerPlayer.setSets(winnerPlayer.getSets()+1);
	}

	private void updateGames(char winner){
		Player winnerPlayer = getWinner(winner);
		winnerPlayer.setGames(winnerPlayer.getGames() + 1);

		if( Math.abs(p1.getGames()-p2.getGames()) >= 2 && winnerPlayer.getGames() >= 6 
				|| (winnerPlayer.getGames() == 7 && getLooser(winner).getGames() == 6)){
			updateSets( winnerPlayer.getId() );
			p1.setGames(0);
			p2.setGames(0);
		} 
		
		if (p1.getGames() == 6 && p2.getGames() == 6) {
			p1.setPoints(4);
			p2.setPoints(4);
		}
	}

	public void updatePoints(char winner){
		Player win = getWinner(winner);
		Player loos = getLooser(winner);

		if (win.getPoints() - loos.getPoints() >=1 && win.getPoints() >= 3){
			win.setPoints(0);
			loos.setPoints(0);
			updateGames(winner);
		} else {
			win.setPoints(((win.getPoints()) + 1));
		}
	}
	
	public void printScore(){
		System.out.println("player:    " + p1.getId() +"    " + p2.getId());
		System.out.println(String.format("sets:    %3d  %3d",p1.getSets(),p2.getSets()));
		System.out.println(String.format("games:   %3d  %3d",p1.getGames(),p2.getGames()));
		System.out.println(String.format("points:  %3d  %3d",p1.getPoints(),p2.getPoints()));
	}
	
	public Player getPlayerOne() {
		return this.p1;
	}
	
	public Player getPlayerTwo() {
		return this.p2;
	}
	
	public void runTournament(String s) {
		for(int itr = 0; itr < s.length(); itr++){
			updatePoints(s.charAt(itr));
		}
	}

}