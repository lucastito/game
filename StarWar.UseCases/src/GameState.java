import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameState implements GameStateInputPort
{
	IPlanetRepository planetRepository;
	IPlayerRepository playerRepository;
	private List<Integer> playingIdsOrder;
	private PlayerStep playerStep;
	
	public GameState()
	{
		playingIdsOrder = new LinkedList<Integer>();
		playerStep = new PlayerStep();
		
//		decidir a ordem dos jogadores pelo dado
//		adicionar ao playingIdsOrder
		
//		para propósito de teste apenas;
		playingIdsOrder.add(0);
		playingIdsOrder.add(1);
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
			playingIdsOrder.add(playingIdsOrder.remove(0));
			playerStep = new PlayerStep();
		}
		else
		{
			//troca de fase
			playerStep.nextStep();
		}
			
	}
	
	public int currentPlayerId()
	{
		return playingIdsOrder.get(0);
	}
	
	public int currentPlayerStep()
	{
		return playerStep.getCurrentPhase();
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
