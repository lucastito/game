import java.util.Map;

public class War {

	private static War instance;
	
	private Board board; 
	private Map<Integer, Player> players;
	
	private War() 
	{		

	}

	public static War getInstance() {
		if (instance == null)
			instance = new War();
		return instance;
	}
	
	public String getPlayerNameById(int id)
	{
		return players.get(id).getName();
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public int[] rollDice(int amountOfDice){
		int[] diceResults = new int[amountOfDice];
		for(int i = 0; i< amountOfDice; i++){
			diceResults[i] = (int)(1+ 6*Math.random());
		}
		return diceResults;
	}
}

