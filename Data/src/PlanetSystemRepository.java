import java.util.HashMap;

public class PlanetSystemRepository 
{
	private IPlanetRepository _planetRepository;
	private HashMap<String, PlanetSystem> planetSystems;
	
	public PlanetSystemRepository(IPlanetRepository planetRepository) 
	{
		_planetRepository = planetRepository;
		
		initializePlanetSystems();
	}
	

	public void addPlanetSystem(PlanetSystem planetSystem)
	{
		planetSystems.put(planetSystem.getName(), planetSystem);
	}
	
	private void initializePlanetSystems() 
	{
		PlanetSystem planetSystem = new PlanetSystem();
		planetSystem.setName("Imperial Remnant");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Trandosha"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Naboo"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Bakura"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Calamari"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Muunilist"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Dantooine"));
		
		planetSystem.addBorder(new Border("Trandosha", "Naboo"));
		planetSystem.addBorder(new Border("Trandosha", "Calamari"));
		planetSystem.addBorder(new Border("Trandosha", "Muunilist"));
		planetSystem.addBorder(new Border("Naboo", "Bakura"));
		planetSystem.addBorder(new Border("Calamari", "Dantooine"));
		planetSystem.addBorder(new Border("Muunilist", "Dantooine"));
		
		addPlanetSystem(planetSystem);

		planetSystem = new PlanetSystem();
		planetSystem.setName("The Centrality");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ilum"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sarapin"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Eredeen Prime"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Coruscant"));
		
		planetSystem.addBorder(new Border("Ilum", "Sarapin"));
		planetSystem.addBorder(new Border("Ilum", "Eredeen Prime"));
		planetSystem.addBorder(new Border("Sarapin", "Eredeen Prime"));
		planetSystem.addBorder(new Border("Sarapin", "Coruscant"));
		planetSystem.addBorder(new Border("Eredeen Prime", "Coruscant"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Pyria System");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yavin IV"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kamino"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Corellia"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nelvaan"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Rhen Var"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ando"));
		
		planetSystem.addBorder(new Border("Yavin IV", "Corellia"));
		planetSystem.addBorder(new Border("Yavin IV", "Nelvaan"));
		planetSystem.addBorder(new Border("Kamino", "Corellia"));
		planetSystem.addBorder(new Border("Kamino", "Ando"));
		planetSystem.addBorder(new Border("Corellia", "Nelvaan"));
		planetSystem.addBorder(new Border("Corellia", "Rhen Var"));
		planetSystem.addBorder(new Border("Nelvaan", "Ando"));
		planetSystem.addBorder(new Border("Rhen Var", "Ando"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Tynna Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tynna"));
	
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Sy Myrth Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sy Myrth Sector"));
	
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Core Worlds");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Geonosis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Mustafar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yag'Dhul"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Hypori"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nivek"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tatooine"));
		
		planetSystem.addBorder(new Border("Geonosis", "Mustafar"));
		planetSystem.addBorder(new Border("Geonosis", "Yag'Dhul"));
		planetSystem.addBorder(new Border("Mustafar", "Nivek"));
		planetSystem.addBorder(new Border("Yag'Dhul", "Hypori"));
		planetSystem.addBorder(new Border("Yag'Dhul", "Tatooine"));
		planetSystem.addBorder(new Border("Hypori", "Tatooine"));
		planetSystem.addBorder(new Border("Nivek", "Tatooine"));
		
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
		
		planetSystem.addBorder(new Border("Thule", "Queita"));
		planetSystem.addBorder(new Border("Thule", "Raxus"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Chorious Systems");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Elrood"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Danjar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tantra"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sluis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kashyyyk"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Alaris Prime"));
	
		planetSystem.addBorder(new Border("Elrood", "Danjar"));
		planetSystem.addBorder(new Border("Elrood", "Tantra"));
		planetSystem.addBorder(new Border("Danjar", "Tantra"));
		planetSystem.addBorder(new Border("Danjar", "Sluis"));
		planetSystem.addBorder(new Border("Danjar", "Kashyyyk"));
		planetSystem.addBorder(new Border("Tantra", "Alaris Prime"));
		planetSystem.addBorder(new Border("Sluis", "Kashyyyk"));
		planetSystem.addBorder(new Border("Kashyyyk", "Alaris Prime"));
		
		addPlanetSystem(planetSystem);
	}	
}
