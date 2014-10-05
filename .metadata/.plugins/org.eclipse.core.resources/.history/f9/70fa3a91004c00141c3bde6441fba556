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
		
		planetSystem.addInternalBorder(new Border("Trandosha", "Naboo"));
		planetSystem.addInternalBorder(new Border("Trandosha", "Calamari"));
		planetSystem.addInternalBorder(new Border("Trandosha", "Muunilist"));
		planetSystem.addInternalBorder(new Border("Naboo", "Bakura"));
		planetSystem.addInternalBorder(new Border("Calamari", "Dantooine"));
		planetSystem.addInternalBorder(new Border("Muunilist", "Dantooine"));
		
		planetSystem.addExternalBorder(new Border("Naboo", "Nivek"));
		planetSystem.addExternalBorder(new Border("Bakura", "Sarapin"));
		planetSystem.addExternalBorder(new Border("Calamari", "Rhen Var"));
		planetSystem.addExternalBorder(new Border("Muunilist", "Coruscant"));
		planetSystem.addExternalBorder(new Border("Dantooine", "Tynna"));
		
		addPlanetSystem(planetSystem);

		planetSystem = new PlanetSystem();
		planetSystem.setName("The Centrality");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ilum"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sarapin"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Eredeen Prime"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Coruscant"));
		
		planetSystem.addInternalBorder(new Border("Ilum", "Sarapin"));
		planetSystem.addInternalBorder(new Border("Ilum", "Eredeen Prime"));
		planetSystem.addInternalBorder(new Border("Sarapin", "Eredeen Prime"));
		planetSystem.addInternalBorder(new Border("Sarapin", "Coruscant"));
		planetSystem.addInternalBorder(new Border("Eredeen Prime", "Coruscant"));
		
		planetSystem.addExternalBorder(new Border("Sarapin", "Bakura"));
		planetSystem.addExternalBorder(new Border("Eredeen Prime", "Nelvaan"));
		planetSystem.addExternalBorder(new Border("Coruscant", "Yag'Dhul"));
		planetSystem.addExternalBorder(new Border("Coruscant", "Pengalan IV"));
		planetSystem.addExternalBorder(new Border("Coruscant", "Muunilist"));
		planetSystem.addExternalBorder(new Border("Coruscant", "Ando"));
		planetSystem.addExternalBorder(new Border("Coruscant", "Elrood"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Pyria System");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yavin IV"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kamino"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Corellia"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nelvaan"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Rhen Var"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Ando"));
		
		planetSystem.addInternalBorder(new Border("Yavin IV", "Corellia"));
		planetSystem.addInternalBorder(new Border("Yavin IV", "Nelvaan"));
		planetSystem.addInternalBorder(new Border("Kamino", "Corellia"));
		planetSystem.addInternalBorder(new Border("Kamino", "Ando"));
		planetSystem.addInternalBorder(new Border("Corellia", "Nelvaan"));
		planetSystem.addInternalBorder(new Border("Corellia", "Rhen Var"));
		planetSystem.addInternalBorder(new Border("Nelvaan", "Ando"));
		planetSystem.addInternalBorder(new Border("Rhen Var", "Ando"));
		
		planetSystem.addExternalBorder(new Border("Corellia", "Kashyyyk"));
		planetSystem.addExternalBorder(new Border("Nelvaan", "Eredeen Prime"));
		planetSystem.addExternalBorder(new Border("Rhen Var", "Calamari"));
		planetSystem.addExternalBorder(new Border("Ando", "Coruscant"));
		planetSystem.addExternalBorder(new Border("Ando", "Sy Myrth"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Tynna Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tynna"));
		
		planetSystem.addExternalBorder(new Border("Tynna", "Dantooine"));
		planetSystem.addExternalBorder(new Border("Tynna", "Geonosis"));
	
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Sy Myrth Sector");		
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sy Myrth"));
	
		planetSystem.addExternalBorder(new Border("Sy Myrth", "Ando"));
		planetSystem.addExternalBorder(new Border("Sy Myrth", "Danjar"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Core Worlds");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Geonosis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Mustafar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Yag'Dhul"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Hypori"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Nivek"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tatooine"));
		
		planetSystem.addInternalBorder(new Border("Geonosis", "Mustafar"));
		planetSystem.addInternalBorder(new Border("Geonosis", "Yag'Dhul"));
		planetSystem.addInternalBorder(new Border("Mustafar", "Nivek"));
		planetSystem.addInternalBorder(new Border("Yag'Dhul", "Hypori"));
		planetSystem.addInternalBorder(new Border("Yag'Dhul", "Tatooine"));
		planetSystem.addInternalBorder(new Border("Hypori", "Tatooine"));
		planetSystem.addInternalBorder(new Border("Nivek", "Tatooine"));
		
		planetSystem.addExternalBorder(new Border("Geonosis", "Tynna"));
		planetSystem.addExternalBorder(new Border("Mustafar", "Alaris Prime"));
		planetSystem.addExternalBorder(new Border("Yag'Dhul", "Coruscant"));
		planetSystem.addExternalBorder(new Border("Hypori", "Thule"));		
		planetSystem.addExternalBorder(new Border("Nivek", "Naboo"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Pengalan IV Sector");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Pengalan IV"));
		
		planetSystem.addExternalBorder(new Border("Pengalan IV", "Coruscant"));
		planetSystem.addExternalBorder(new Border("Pengalan IV", "Thule"));
		planetSystem.addExternalBorder(new Border("Pengalan IV", "Queita"));
		planetSystem.addExternalBorder(new Border("Pengalan IV", "Raxus"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Outer Rim");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Thule"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Queita"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Raxus"));
		
		planetSystem.addInternalBorder(new Border("Thule", "Queita"));
		planetSystem.addInternalBorder(new Border("Thule", "Raxus"));
		
		planetSystem.addExternalBorder(new Border("Thule", "Hypori"));
		planetSystem.addExternalBorder(new Border("Thule", "Pengalan IV"));
		planetSystem.addExternalBorder(new Border("Queita", "Pengalan IV"));
		planetSystem.addExternalBorder(new Border("Queita", "Elrood"));
		planetSystem.addExternalBorder(new Border("Raxus", "Pengalan IV"));
		
		addPlanetSystem(planetSystem);
		
		planetSystem = new PlanetSystem();
		planetSystem.setName("Chorious Systems");
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Elrood"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Danjar"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Tantra"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Sluis"));
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Kashyyyk"));	
		planetSystem.addPlanet(_planetRepository.getPlanetByName("Alaris Prime"));
	
		planetSystem.addInternalBorder(new Border("Elrood", "Danjar"));
		planetSystem.addInternalBorder(new Border("Elrood", "Tantra"));
		planetSystem.addInternalBorder(new Border("Danjar", "Tantra"));
		planetSystem.addInternalBorder(new Border("Danjar", "Sluis"));
		planetSystem.addInternalBorder(new Border("Danjar", "Kashyyyk"));
		planetSystem.addInternalBorder(new Border("Tantra", "Alaris Prime"));
		planetSystem.addInternalBorder(new Border("Sluis", "Kashyyyk"));
		planetSystem.addInternalBorder(new Border("Kashyyyk", "Alaris Prime"));
		
		planetSystem.addExternalBorder(new Border("Elrood", "Coruscant"));
		planetSystem.addExternalBorder(new Border("Elrood", "Queita"));
		planetSystem.addExternalBorder(new Border("Danjar", "Sy Myrth"));
		planetSystem.addExternalBorder(new Border("Kashyyyk", "Corellia"));
		planetSystem.addExternalBorder(new Border("Alaris Prime", "Mustafar"));
		
		addPlanetSystem(planetSystem);
	}	
}
