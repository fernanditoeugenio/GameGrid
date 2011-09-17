

	/**
	 * @param args
	 */
import java.io.*;

	public class WarriorTest
	{


	
		public static void main(String[] args) {

			int a1, b1;
			String s;
			Warrior w1 = new Warrior("San Diego",100,"Sunny","duumy path");
			Warrior w2 = new Warrior("New York",100,"Hey!","dummy path");
			
			do{
			s = BattleProtocol.showAttackOps();
			a1 = 0;
			System.out.println(s);
			BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
				try{
					a1 = Integer.parseInt(dataIn.readLine());

				}catch( IOException e ){
					System.out.println("Error in getting input");
				}
			if(a1 < 1 || a1 > 3) {
				System.out.println("\n\nHey you chose and invalid option, do it again!\n\n");
			}
			
			System.out.println("\n\nYou entered: " + a1);
			s = BattleProtocol.showDefendOps();
			b1 = 0;
			System.out.println(s);
				try{
					b1 = Integer.parseInt(dataIn.readLine());

				}catch( IOException e ){
					System.out.println("Error in getting input");
				}
			if(b1 < 1 || b1 > 3) {
				System.out.println("\n\nHey you chose and invalid option, do it again!\n\n");
			}
			System.out.println("\n\nYou entered: " + b1);
			System.out.println(CombatModerator.resolveCombat(w1, a1, w2, b1));
			System.out.println(w1.toString());
			System.out.println(w2.toString());
			}
			while(w1.isAlive() && w2.isAlive());
		}
		
		System.out.println("\n\n\Game Has Ended.  Good Bye.");
		
}
