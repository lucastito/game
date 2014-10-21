public class War
{
	private static War instance;

	public static War getInstance() 
	{
		if (instance == null)
			instance = new War();
		return instance;
	}
	
	public static int[] rollDice(int amountOfDice)
	{
		int[] diceResults = new int[amountOfDice];
		for(int i = 0; i < amountOfDice; i++){
			diceResults[i] = (int)(1 + 6*Math.random());
		}
		return diceResults;
	}
}

