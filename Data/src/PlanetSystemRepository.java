import java.util.HashMap;
import java.util.Map;

public class PlanetSystemRepository 
{
	private IPlanetRepository _planetRepository;
	private HashMap<String, PlanetSystem> planetSystems;
	
	public PlanetSystemRepository(IPlanetRepository planetRepository) 
	{
		_planetRepository = planetRepository;	
		planetSystems = new HashMap<String, PlanetSystem>();
		initializePlanetSystems();
	}	

	public void addPlanetSystem(PlanetSystem planetSystem)
	{
		planetSystems.put(planetSystem.getName(), planetSystem);
	}
	
	public Map<String, PlanetSystem> getPlanetSystems() {
		return planetSystems;
	}
	
	public PlanetSystem getPlanetSystemByName(String name) {
		if (name == null || name.isEmpty())
			return null;
		return planetSystems.get(name);
	}
	
	private void initializePlanetSystems() 
	{
		PlanetSystem planetSystem = new PlanetSystem();
		planetSystem.setName("Imperial Remnant");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Trandosha"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Naboo"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Bakura"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Calamari"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Muunilinst"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Dantooine"));
				
		addPlanetSystem(planetSystem);

		planetSystem = new PlanetSystem();
		planetSystem.setName("The Centrality");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ilum"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sarapin"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Eredeen Prime"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Coruscant"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Pyria System");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yavin IV"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kamino"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Corellia"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nelvaan"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Rhen Var"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ando"));		
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Tynna Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tynna"));		
	
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Sy Myrth Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sy Myrth"));		
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Core Worlds");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Geonosis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Mustafar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yag'Dhul"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Hypori"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nivek"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tatooine"));		
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Pengalan IV Sector");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Pengalan IV"));		
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Outer Rim");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Thule"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Queita"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Raxus"));		
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Chorious Systems");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Elrood"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Danjar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tantra"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sluis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kashyyyk"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Alaris Prime"));
		
		addPlanetSystem(planetSystem);
	}	
}
