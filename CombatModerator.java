/*
 * 		Title:
 * 		Date:
 * 		
 */

import java.util.*;

/**
 *  Class declaration for CombatModerator 
 * @author feugenio
 *
 */
public class CombatModerator {


	private static Random randomGenerator;
	private static int randomInt;
	
	public CombatModerator()
	{
		randomGenerator = new Random();
		randomInt = -1;
		
	}
	/**
	 * Method that resolves combat between 2 warriors
	 * @param w1
	 * @param a1
	 * @param w2
	 * @param b1
	 * @return
	 */
	public static String resolveCombat(Warrior w1, int a1, Warrior w2, int b1)
	{
		if(a1 == 1 && b1 < 3)
		{
			return battle1(w1, w2);
		}
        else if(a1 == 2 && b1 < 3)
        {
        	return battle2(w1, w2);
        }
       else if(a1 < 3 && b1 == 3)
       {
    	   return battle2(w1, w2);
       }
		return battle3(w1, w2);
	}
	
	private static String battle1(Warrior w1, Warrior w2)
	{
		randomGenerator = new Random();
		randomInt = getRandomInt(3);
		
		if(randomInt == 0)
		{
				w2.decreaseHealth(10);
				return "\n\nAttack Hits, defender loses 10 points.";
		
		}
		return "\n\nAttack fails, no points lost.";
		
	}
	
	private static String battle2(Warrior w1, Warrior w2)
	{
		randomGenerator = new Random();
		randomInt = getRandomInt(4);
		if(randomInt == 0)
		{
			w2.decreaseHealth(10);
			return "\n\nAttack Hits Well, defender loses 10 points."; 
		
		}
		else if(randomInt == 1)
		{
			w2.decreaseHealth(5);
			return "\n\nAttack Hits Okay, defender loses 5 points."; 
		}	
		else if(randomInt == 2)
		{
			w1.decreaseHealth(5);
			return "\n\nAttack Fails and defender hits, attacker loses 5 points."; 
		}
		return "\n\nAttack fails, no points lost.";
	}
	
	private static String battle3(Warrior w1, Warrior w2)
	{
		randomGenerator = new Random();
		randomInt =getRandomInt(5);
		if(randomInt == 0)
		{
			w2.decreaseHealth(15);
			return "\n\nAttack Hits Very Well, defender loses 10 points."; 
		
		}
		else if(randomInt == 1 && randomInt == 2)
		{
			w2.decreaseHealth(5);
			return "\n\nAttack Hits Okay, defender loses 5 points."; 
		}	
		else if(randomInt == 4)
		{
			w1.decreaseHealth(5);
			w2.decreaseHealth(5);
			return "\n\nBoth Warrios Hitand each lose 5 points.";
		}
		w1.decreaseHealth(10);
		return "\n\nAttack fails and defender scores hit, attacker loses 10 pts.";
	}
	
	private static int getRandomInt(int size)
	{
		return randomGenerator.nextInt(10000) % size;	
	}
}