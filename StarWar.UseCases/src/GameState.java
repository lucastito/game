import java.util.ArrayList;
import java.util.List;

public class GameState implements GameStateInputPort
{
	IPlanetRepository planetRepository;
	public GameState(IPlanetRepository planetRepository)
	{
		this.planetRepository = planetRepository;
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
	
}