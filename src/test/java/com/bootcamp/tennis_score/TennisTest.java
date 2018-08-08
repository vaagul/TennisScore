package com.bootcamp.tennis_score;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TennisTest {
	private Tournament tournament;
	
	private final int LUV = 0;
	private final int FIFTEEN = 1;
	private final int THIRTY = 2;
	private final int FOURTY = 3;
	private final int DISADV = 4;
	private final int DEUCE = 4;
	private final int ADV = 4;
	
	@Before
	public void setup() {
		tournament = new Tournament('A', 'B');
	}
	
	@Test
	public void testOnlyOneRoundforA() {
		tournamentTest("A", FIFTEEN, 0, 0, LUV, 0, 0);
	}
	
	@Test
	public void testOnlyOneRoundforB() {
		tournamentTest("B", LUV, 0, 0, FIFTEEN, 0, 0);
	}
	
	@Test
	public void testAWins() {
		tournamentTest("AAAA", LUV, 1, 0, LUV, 0, 0);
	}
	
	@Test
	public void testBWins() {
		tournamentTest("BBBB", LUV, 0, 0, LUV, 1, 0);
	}
	
	@Test
	public void testPartialGame() {
		tournamentTest("BBB", LUV, 0, 0, FOURTY, 0, 0);
	}
	
	@Test
	public void testGameWithAdvantage() {
		tournamentTest("ABABABA", ADV, 0, 0, FOURTY, 0, 0);
	}
	
	@Test
	public void testLongGame() {
		tournamentTest("ABABABABABABAB", 7, 0, 0, 7, 0, 0);
	}
	
	@Test
	public void testOneFullGameAndPartial() {
		tournamentTest("ABABAAB", LUV, 1, 0, FIFTEEN, 0, 0);
	}
	
	@Test
	public void testTwoFullGames() {
		tournamentTest("AAAABBBB", LUV, 1, 0, LUV, 1, 0);
	}
	
	@Test
	public void testTwoFullGamesWithPartail() {
		tournamentTest("AAAABBBBA", FIFTEEN, 1, 0, LUV, 1, 0);
	}
	
	@Test
	public void testOneSet() {
		tournamentTest("AAAAAAAAAAAAAAAAAAAAAAAA", LUV, 0, 1, LUV, 0, 0);
	}
	
	@Test
	public void testOneSetWithPartail() {
		tournamentTest("AAAAAAAAAAAAAAAAAAAAAAAABB", LUV, 0, 1, THIRTY, 0, 0);
	}
	
	@Test
	public void testTwoSet() {
		tournamentTest("AAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBB", LUV, 0, 1, LUV, 0, 1);
	}

	@Test
	public void testTieBreakerGame() {
		tournamentTest("AAAABBBBAAAABBBBAAAABBBBAAAABBBBAAAABBBBAAAABBBBAA", 0, 0, 1, 0, 0, 0);
	}
 	
	private void assertPlayer(Player p, int points, int games, int sets) {
		assertEquals(points, p.getPoints());
		assertEquals(games, p.getGames());
		assertEquals(sets, p.getSets());
	}
	
	private void tournamentTest(String match, int pt1, int g1, int s1, int pt2, int g2, int s2) {
		tournament.runTournament(match);
		Player p1 = tournament.getPlayerOne();
		Player p2 = tournament.getPlayerTwo();
		assertPlayer(p1, pt1, g1, s1);
		assertPlayer(p2, pt2, g2, s2);
	}
	
}
