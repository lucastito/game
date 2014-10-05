import java.util.HashMap;


public class BoardRepository implements IBoardRepository
{
	IPlanetSystemRepository planetSystemRepository;
	private HashMap<String, PlanetSystem> planetSystems;
	
	public BoardRepository(IPlanetSystemRepository planetSystemRepository)
	{		
		this.planetSystemRepository = planetSystemRepository;
		//planetSystem.addPlanet(_planetRepository.getPlanetByName("Trandosha"));
	}
	
	public void addPlanetSystem(PlanetSystem planetSystem)
	{
		planetSystems.put(planetSystem.getName(), planetSystem);
	}
}
