import java.util.Set;

public class War {
	private static War instance;
	private boolean territoryWon;

	private Set<TerritoryCard> territoryCards;

	public static War getInstance() {
		if (instance == null)
			instance = new War();
		return instance;
	}

	public static int[] rollDice(int amountOfDice) {
		int[] diceResults = new int[amountOfDice];
		for (int i = 0; i < amountOfDice; i++) {
			diceResults[i] = (int) (1 + 6 * Math.random());
		}
		return diceResults;
	}	

	public Set<TerritoryCard> getTerritoryCards() {
		return territoryCards;
	}

	public void setTerritoryCards(Set<TerritoryCard> territoryCards) {
		this.territoryCards = territoryCards;
	}
	
	public boolean isTerritoryWon() {
		return territoryWon;
	}

	public void setTerritoryWon(boolean territoryWon) {
		this.territoryWon = territoryWon;
	}

}
