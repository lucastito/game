
public class BoardRepository implements IBoardRepository
{
	IPlanetSystemRepository planetSystemRepository;
	
	public BoardRepository(IPlanetSystemRepository planetSystemRepository)
	{		
		this.planetSystemRepository = planetSystemRepository;
	}
	
}