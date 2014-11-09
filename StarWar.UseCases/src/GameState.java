import java.util.ArrayList;
import java.util.List;

public class GameState implements GameStateInputPort
{
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;
	private List<Player> players;
	private PlayerStep playerStep;
	private int currentRound = 0;
	private Player currentPlayer;
	private int currentPlayerPositionInList = 0;
	
	public GameState()
	{		
		playerStep = new PlayerStep();
		currentRound++;			
	}

	public List<TerritoryDTO> getAllPlanets() 
	{
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet planet : planetRepository.getPlanets().values())
		{
			TerritoryDTO territory = Mapper.mapTerritoryDTO(planet);
			territories.add(territory);
		}
		return territories;
	}
	
	public List<PieceDTO> getAllPieces() 
	{
		List<PieceDTO> pieces = new ArrayList<PieceDTO>();
		for(Piece piece : playerRepository.getAllPieces())
		{
			PieceDTO pieceDTO = Mapper.mapPieceDTO(piece);
			pieces.add(pieceDTO);
		}
		return pieces;
	}
	
	public boolean nextPlayerStep()
	{
		int allPiecesCount = playerRepository.getAllPieces().size();
		if (allPiecesCount <= 0)
			return false;
		if (playerStep.getCurrentPhase() == PlayerStep.END_OF_TURN)
		{
			//troca o jogador
			if (currentPlayerPositionInList + 1 < players.size())
				currentPlayerPositionInList++;
			else
			{
				currentPlayerPositionInList = 0;
				currentRound++;				
			}
			int pieceCount = playerRepository.getPlayerByName(players.get(currentPlayerPositionInList).getName()).getPieces().size();
			if (pieceCount >= allPiecesCount)
				return false;
			if(pieceCount > 0)	
			{
				currentPlayer = players.get(currentPlayerPositionInList);
				playerStep = new PlayerStep();
			}
			else
				if (currentPlayerPositionInList + 1 < players.size())
					currentPlayerPositionInList++;
				else
				{
					currentPlayerPositionInList = 0;
				}
				nextPlayerStep();
		}
		else
		{
			//troca de fase
			playerStep.nextStep();
		}
		return true;
	}
	
	public String currentPlayerName()
	{
		return currentPlayer.getName();
	}
	
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public int currentPlayerStep()
	{
		return playerStep.getCurrentPhase();
	}
	
	@Override
	public boolean isPieceFromCurrentPlayer(int pieceId) 
	{
		for(Piece piece : currentPlayer.getPieces())
		{
			if (pieceId == piece.getId())
				return true;
		}
		
		return false;
	}

	@Override
	public boolean isRedeployPhase() 
	{
		if (playerStep.getCurrentPhase() == PlayerStep.REDEPLOY_ARMY_PHASE)
			return true;
		return false;
	}

	@Override
	public boolean isAttackPhase() 
	{
		if (playerStep.getCurrentPhase() == PlayerStep.ATTACK_ENEMIES_PHASE)
			return true;
		return false;
	}
	
	public void setPlanetRepository(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
	}
	
	public void setPlayerRepository(IPlayerRepository playerRepository)
	{
		this.playerRepository = playerRepository;		
		players = playerRepository.getAllPlayers();
	}

	public int getCurrentRound() 
	{
		return currentRound;
	}
}
