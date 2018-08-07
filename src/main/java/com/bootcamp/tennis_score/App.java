package com.bootcamp.tennis_score;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    		Tennis.calc("ABABAB");
    	
    		String input = "ABABABAAB";
		Tournament t = new Tournament('A','B');

		for(int itr = 0; itr < input.length(); itr++){
			t.updatePoints(input.charAt(itr));
		}
		t.printScore();
    }
}
