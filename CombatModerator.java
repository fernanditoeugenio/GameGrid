/*
 * 		Title:
 * 		Date:
 * 		
 */

import java.util.*;

// Class declaration for CombatModerator 
public class CombatModerator {
	
	
	public static String resolveCombat(Warrior w1, int a1, Warrior w2, int b1)
	{
            Random randomGenerator = new Random();
            int randomInt; 

	     if (b1 < 3) {
	    	 randomInt = randomGenerator.nextInt(998);
	    	 randomInt = randomInt % 3;
	    	 if(randomInt == 1) {
	    		 w2.decreaseHealth(10); 
	    		 return "\n\nAttack connects, defender loses 10 points.\n";
		     
	    	 }
	    	 return "Attack defended, no health lost.";

	     }
	     else
        {
	    	 randomInt = randomGenerator.nextInt(999);
	    	 randomInt = randomInt % 4;
	    	 if(randomInt == 1) {
	    		 w2.decreaseHealth(15); 
	    		 return "\n\nCounterAttack fails, defender loses 15 points.\n";
	    	 } 
	    	 else if(randomInt == 2){
	    		 w2.decreaseHealth(10); 
	    		 return "\n\nAttack Hits, defender loses 10 points.\n";
	    	 } 
	    	 else if(randomInt == 3)
	    	 {
	    		 w1.decreaseHealth(10); 
	    		 return "\n\nCounterAttack Succeeds, attacker loses 10 points.\n";
	    	 }
	    	 else {
	    		 return "\n\nBoth Attack fails, no points lost.\n";
	    	 }
        }
	}
}