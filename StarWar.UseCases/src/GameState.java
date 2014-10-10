import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameState implements GameStateInputPort
{
	IPlanetRepository planetRepository;
	private List<Integer> playingIdsOrder;
	
	public GameState(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
		
		playingIdsOrder = new LinkedList<Integer>();
		
//		decidir a ordem dos jogadores pelo dado
//		adicionar ao playingIdsOrder
		
//		para propůsito de teste apenas;
		playingIdsOrder.add(0);
		playingIdsOrder.add(1);
	}
	
	public BoardDTO getBoard() 
	{
		return new BoardDTO();
	}

	@Override
	public List<TerritoryDTO> getAllPlanets() 
	{
		List<TerritoryDTO> territories = new ArrayList<TerritoryDTO>();
		for(Planet planet : planetRepository.getPlanets().values())
		{
			TerritoryDTO territory = new TerritoryDTO();
			territory.setId(planet.getId());
			territory.setName(planet.getName());
			territory.setxAxisCoordinate(planet.getXAxisCoordinate());
			territory.setyAxisCoordinate(planet.getYAxisCoordinate());
			territory.setImagePath(planet.getImagePath());
			territories.add(territory);
		}
		return territories;
	}
	
	public void nextPlayer()
	{
		playingIdsOrder.add(playingIdsOrder.remove(0));
	}
	
	public int currentPlayerId()
	{
		return playingIdsOrder.get(0);
	}
}
