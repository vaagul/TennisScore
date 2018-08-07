package Test;

import java.util.Arrays;

public class Tennis {
   public static void calc(String s)
   {
	   
	   int i;
	   int[] bool =new int[2];
	   int[] points=new int[]{0,0};
	   int[] games=new int[]{0,0};
	   int[] sets=new int[]{0,0};
	   for(i=0;i<s.length();i++)
	   {
		       bool=convertToBoolArray(s.charAt(i));
			   points=updatePoints(points,bool);
			   int game=checkGame(points);
			   if(game>0)
			   {
				   games=updateGames(games,game);
				   Arrays.fill(points, 0);
			   }
			   int set=checkSet(games);
			   if(set>0)
			   {
				   sets=updateSets(sets,set);
				   Arrays.fill(games, 0);
			   }	  
	   }
	   System.out.println(sets[0]+" "+sets[1]);
	   System.out.println(games[0]+" "+games[1]);
	   printPoints(points);
   }
   
   public static void printPoints (int[] p) {
	   Integer[] scores = {0, 15, 30, 40};
	   if (p[0] >= 4 && p[1] >= 4) {
		   if (p[0] == p[1]) {
			   System.out.println("D D");
		   } else {
			   if (p[0] > p[1]) {
				   System.out.println("A  -");
			   } else {
				   System.out.println("-  A");
			   }
		   }
	   } else {
		   System.out.println(scores[p[0]-1] + " " + scores[p[1]-1]);
	   }
   }
   public static int[] updatePoints(int[] points,int bool[])
   {
	  points[0]=points[0]+bool[0];
	  points[1]=points[1]+bool[1]; 
	  return points;
   }
   public static int[] updateGames(int[] games,int g)
   {
	   if(g==1)
		   games[0]=games[0]+1;
	   else
		   games[1]=games[1]+1;
	   return games;
   }
   public static int[] updateSets(int[] sets,int set)
   {
	   if(set==1)
		   sets[0]=sets[0]+1;
	   else
		   sets[1]=sets[1]+1;
	   return sets;
   }
   public static int[] convertToBoolArray(char ch)
   {
	   int[] bool =new int[2];
	   if(ch=='A');
   	   {
   		   bool[0]=1;
   		   bool[1]=0;
   	   }
   	   if(ch=='B')
   	   {
   		   bool[0]=0;
   		   bool[1]=1;
   	   }
	   return bool;
   }
   public static int checkSet(int[] games)
   {
	   if(Math.abs(games[0]-games[1])>2 && Math.max(games[0], games[1])>5)
	   {
		   if(games[0]>games[1])
		   return 1;
	   else
		   return 2;
	   }
	   return 0;
   }
   public static int checkGame(int points[])
   {
	   if(Math.abs(points[0]-points[1])>=2 && Math.max(points[0], points[1])>3)
	   {
		   if(points[0]>points[1])
			   return 1;
		   else
			   return 2;
	   }
	   else
		   return 0;
   }
   
}
