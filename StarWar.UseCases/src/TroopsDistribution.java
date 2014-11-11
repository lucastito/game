public class TroopsDistribution implements TroopsDistributionBoundary
{
	GamePresenterOutputPort gameScreen;
	IPlayerRepository playerRepository;
	IPlanetRepository planetRepository;
	GameStateInputPort gameState;
	
	public TroopsDistribution(GamePresenterOutputPort presenter, IPlanetRepository planetRepository, IPlayerRepository playerRepository, GameStateInputPort gameState)
	{
		this.gameScreen = presenter;
		this.planetRepository = planetRepository;
		this.playerRepository = playerRepository;
		this.gameState = gameState;
	}
	
	public void distributeTroops(int numberOfPieces, String playerName, String planetName) 
	{
		Player player = playerRepository.getPlayerByName(playerName);
		Planet planet = planetRepository.getPlanetByName(planetName);
		
		int numberOfUnitsToDistribute = gameState.getUnitsToDistribute();
		
		if (!planet.getOwnerName().equals(playerName))
		{
			gameScreen.showReason("Player does not own this territory.");
			return;
		}
		
		if (numberOfPieces > numberOfUnitsToDistribute)
		{
			gameScreen.showReason("Number of pieces exceeds number of units to distribute.");
			return;
		}
		else
		{
			playerRepository.addPlayerPiece(playerName, planetName, numberOfPieces);
			gameState.removeUnitsToDistribute(numberOfPieces);
		}		
		
		if (playerNeedsToExchangeCards(player))
		{
			gameScreen.showReason("Player Has Five Territory Cards.");
			return;
		}
		
		if (playerHasConqueredPlanetarySystem(player))
		{
			gameScreen.showReason(("Player Conquered Planetary Systems."));
			return;
		}
		
		gameScreen.show();
	}

	private boolean playerHasConqueredPlanetarySystem(Player player) 
	{
		return false;
	}

	private boolean playerNeedsToExchangeCards(Player player) 
	{
		return false;
	}
}
