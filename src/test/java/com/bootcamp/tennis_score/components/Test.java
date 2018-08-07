package com.bootcamp.tennis_score.components;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/*
	 * Points for a round
	 * Score for a game -> rounds
	 * Score for set -> games
	 */

	private final Integer[] roundForA = {1, 0};
	private final Integer[] roundForB = {0, 1};
	
	@org.junit.Test
	public void testScoreForRound() {
		assertEquals(roundForA, getScoreForRound('A'));
		assertEquals(roundForB, getScoreForRound('B'));
	}
	
	@org.junit.Test
	public void testGameForScore_SimpleA() {
		List<Integer[]> expected = new ArrayList<>();
		expected.add(roundForA);
		assertEquals(expected, decorateString("A"));
	}
	
	@org.junit.Test
	public void testGameForScore_SimpleB() {
		List<Integer[]> expected = new ArrayList<>();
		expected.add(roundForB);
		assertEquals(expected, decorateString("B"));
	}
	
	@org.junit.Test
	public void testGameForScore_Long() {
		List<Integer[]> expected = new ArrayList<>();
		expected.add(roundForB);
		expected.add(roundForA);
		assertEquals(expected, decorateString("BA"));
	}
	
	@org.junit.Test
	public void testSumOverPair() {
		Integer[] sum = {1, 1};
		assertEquals(sum, addPair(roundForA, roundForB));
	}
	
	@org.junit.Test
	public void test() {
		List<Integer[]> t = splitOverConstraint(decorateString("ABABABAA"), 4, 2);
		for (Integer[] d : t) {
			System.out.println(d[0] + " - " + d[1]);
		}
	}
	
	private Integer[] getScoreForRound(Character r) {
		if (r.equals('A')) {
			return roundForA;
		} else {
			return roundForB;
		}
	}
	
	private List<Integer[]> decorateString(String s) {
		List<Integer[]> result = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			result.add(getScoreForRound(s.charAt(i)));
		}
		return result;
	}
	
	private Integer[] addPair(Integer[] a, Integer[] b) {
		Integer[] c = new Integer[2];
		c[0] = a[0] + b[0];
		c[1] = a[1] + b[1];
		return c;
	}
	
	private List<Integer[]> splitOverConstraint(List<Integer[]> m, int cons1, int cons2) {
		Integer[] accum = initAccum(0, 0);
		List<Integer[]> result = new ArrayList<>();
		for (Integer[] r : m) {
			accum = addPair(accum, r);
			if (accum[0] >= cons1 || accum[1] >= cons1) {
				int diff = Math.abs(accum[0] - accum[1]);
				if (diff >= cons2) {
					result.add(getWinner(accum));
					accum = initAccum(0, 0);
				}
			}
			System.out.println(accum[0] + " - " + accum[1]);
		}
		
		return result;
	}
	
	private Integer[] initAccum(int a, int b) {
		Integer[] accum = {a, b};
		return accum;
	}
	
	private Integer[] getWinner(Integer[] r) {
		if (r[0] > r[1]) {
			return roundForA;
		} else {
			return roundForB;
		}
	}
 
}
