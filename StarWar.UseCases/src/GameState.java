import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameState implements GameStateInputPort
{
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;
	private List<String> playerNamesOrder;
	private PlayerStep playerStep;
	
	public GameState()
	{
		playerNamesOrder = new LinkedList<String>();
		playerStep = new PlayerStep();
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
	
	public void nextPlayerStep()
	{
		if (playerStep.getCurrentPhase() == PlayerStep.END_OF_TURN)
		{
			//troca o jogador
			playerNamesOrder.add(playerNamesOrder.remove(0));
			playerStep = new PlayerStep();
		}
		else
		{
			//troca de fase
			playerStep.nextStep();
		}			
	}
	
	public String currentPlayerName()
	{
		return playerNamesOrder.get(0);
	}
	
	public int currentPlayerStep()
	{
		return playerStep.getCurrentPhase();
	}
	
	@Override
	public boolean isPieceFromCurrentPlayer(String playerName) 
	{
		if (playerName.equals(currentPlayerName()))
			return true;
		
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
	}
}
