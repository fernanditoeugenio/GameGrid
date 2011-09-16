/*
 * 
 */



public class BattleProtocol {


    // Default constructor
    public BattleProtocol()
    {
    }

    // This is the text field that return a String that lists the possible combat operations.
    public static String showAttackOps()
    {
        return "\nWelcome to Battle Warriors!\n\nPlease select an Attack Combat Operation\n1: Throw Disc\n2: Fire Phasers\n3: Kamikaze Attack\n\nPlease enter a number and then Enter: ";
    }

    public static String showDefendOps()
    {
        return "\nYou have been Attacked!\n\nPlease select a Defend Combat Operation\n1: Use Disc as Shield\n2: Dodge Attack\n3: Counter Attack\n\nPlease enter a number and then Enter: ";
    }
    
    public Boolean isValidAction( int action)
    {
    	if(action > 0 && action < 4)
    		return true;
    	else
    		return false;
    }
        
        

  
}




