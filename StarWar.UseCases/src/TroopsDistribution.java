


public class TroopsDistribution implements TroopsDistributionBoundary
{
	public int calculateNumberOfPiecesPlayerIsAllowedToDistribute(PlayerDTO player) 
	{
		throw new UnsupportedOperationException();
	}
	
	public int maxNumberOfUnitsAPlayerCanPutInATerritory(TerritoryDTO territory) 
	{
		throw new UnsupportedOperationException();
	}

	public BoardDTO distributeTroops(int numberOfPieces, PlayerDTO playerDTO, TerritoryDTO territory) 
	{
		Player player = Mapper.mapPlayer(playerDTO);
		Planet planet = Mapper.mapPlanet(territory);
		
		if (isFirstRound())
			return firstRoundDistribution(numberOfPieces, player, planet);
		
		if (playerNeedsToExchangeCards(player))
		{
			BoardDTO board = new BoardDTO();
			board.setReason("Player Has Five Territory Cards.");
			return board;
		}
		
		if (playerHasConqueredPlanetarySystem(player))
		{
			BoardDTO board = new BoardDTO();
			board.setReason("Player Conquerede Planetary Systems.");
			return board;
		}
		throw new UnsupportedOperationException();
	}

	private boolean playerHasConqueredPlanetarySystem(Player player) 
	{
		throw new UnsupportedOperationException();
	}

	private boolean playerNeedsToExchangeCards(Player player) 
	{
		throw new UnsupportedOperationException();
	}

	private BoardDTO firstRoundDistribution(int numberOfPieces, Player player, Planet planet) 
	{
		throw new UnsupportedOperationException();
	}

	private boolean isFirstRound() 
	{
		throw new UnsupportedOperationException();
	}

}
