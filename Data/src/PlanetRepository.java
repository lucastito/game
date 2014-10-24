import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetRepository implements IPlanetRepository
{
	private HashMap<String, Planet> planets;
	
	public PlanetRepository()
	{
		initializePlanets();
	}	
	
	public void addPlanet(Planet planet){
		planets.put(planet.getName(), planet);
	}
	
	public Map<String, Planet> getPlanets() {
		return planets;
	}
	
	public void setPlanetOwner(String planetName, String playerName) {
		getPlanetByName(planetName).setOwnerName(playerName);
	}
	
	public Planet getPlanetByName(String name) {
		if (name == null || name.isEmpty())
			return null;
		return planets.get(name);
	}
	
	public List<Planet> getNeighborPlanets(String planetName)
	{
		if (planetName == null || planetName.isEmpty())
			return null;
		
		Planet planet = getPlanetByName(planetName);
		
		if (planet == null)
			return null;
		
		List<Border> borders = planet.getBorders();
		List<Planet> neighborPlanets = new ArrayList<Planet>();
		for (Border b : borders)
		{
			neighborPlanets.add(getPlanetByName(b.getNeighborPlanetName()));
		}
		return neighborPlanets;
	}

	public boolean areNeighbors(String sourceTerritoryName, String targetTerritoryName)
	{
		if (sourceTerritoryName == null || sourceTerritoryName.isEmpty() || 
				targetTerritoryName == null || targetTerritoryName.isEmpty())
			return false;
		
		Planet sourceTerritory = getPlanetByName(sourceTerritoryName);		
		if (sourceTerritory == null)
			return false;
		
		List<Border> borders = sourceTerritory.getBorders();		
		for (Border b : borders)
		{
			if (b.getNeighborPlanetName().equals(targetTerritoryName))
				return true;
		}
		return false;
	}
		
//		{Trandosha, Muunlist, Bakura, Calamari, Naboo, 
//		Dantooine, Ilum, Sarapin, Eredenn_Prime, Coruscant, 
//		Yavin_IV, Kamino, Corellia, Nelvaan, Rhen_Var,
//		Ando, Tynna, Sy_Myrth, Geonosis, Mustafar,
//		Yag_Dhul, Hypori, Nivek, Tatooine, Pengalan_IV, 
//		Raxus, Queita, Thule, Elrood, Danjar, 
//		Tantra, Sluis, Kashyyyk, Alaris_Prime};
	
	
	private void initializePlanets() {
		planets = new HashMap<String, Planet>();
		Planet planet;
		

		planet = new Planet((short) 1, "Trandosha", (short)110, (short)10, "image/planets/Trandosha.png");
		planet.addInternalBorder(new Border("Trandosha", "Naboo"));
		planet.addInternalBorder(new Border("Trandosha", "Calamari"));
		planet.addInternalBorder(new Border("Trandosha", "Muunlist"));		
		addPlanet(planet);
		
		planet = new Planet((short) 2, "Muunlist", (short)210, (short)10, "image/planets/Muunlist.png");
		planet.addInternalBorder(new Border("Muunlist", "Trandosha"));
		planet.addInternalBorder(new Border("Muunlist", "Dantooine"));
		planet.addExternalBorder(new Border("Muunlist", "Coruscant"));
		addPlanet(planet);
		
		planet = new Planet((short) 3, "Bakura", (short)315, (short)30, "image/planets/Bakura.png");
		planet.addInternalBorder(new Border("Bakura", "Naboo"));
		planet.addExternalBorder(new Border("Bakura", "Sarapin"));
		addPlanet(planet);
		
		planet = new Planet((short) 4, "Calamari", (short)118, (short)110, "image/planets/Calamari.png");
		planet.addInternalBorder(new Border("Calamari", "Trandosha"));
		planet.addInternalBorder(new Border("Calamari", "Dantooine"));
		planet.addExternalBorder(new Border("Calamari", "Rhen Var"));
		addPlanet(planet);
		
		planet = new Planet((short) 5, "Naboo", (short)235, (short)105, "image/planets/Naboo.png");
		planet.addInternalBorder(new Border("Naboo", "Trandosha"));
		planet.addInternalBorder(new Border("Naboo", "Bakura"));
		planet.addExternalBorder(new Border("Naboo", "Nivek"));
		addPlanet(planet);
		
		planet = new Planet((short) 6, "Dantooine", (short)170, (short)193, "image/planets/Dantooine.png");
		planet.addInternalBorder(new Border("Dantooine", "Muunlist"));
		planet.addInternalBorder(new Border("Dantooine", "Calamari"));
		planet.addExternalBorder(new Border("Dantooine", "Tynna"));
		addPlanet(planet);		
		
		planet = new Planet((short) 7, "Ilum", (short)650, (short)25, "image/planets/Ilum.png");
		planet.addInternalBorder(new Border("Ilum", "Sarapin"));
		planet.addInternalBorder(new Border("Ilum", "Eredenn Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 8, "Sarapin", (short)580, (short)110, "image/planets/Sarapin.png");
		planet.addInternalBorder(new Border("Sarapin", "Eredenn Prime"));
		planet.addInternalBorder(new Border("Sarapin", "Ilum"));
		planet.addInternalBorder(new Border("Sarapin", "Coruscant"));
		planet.addExternalBorder(new Border("Sarapin", "Bakura"));
		addPlanet(planet);
		
		planet = new Planet((short) 9, "Eredenn Prime", (short)710, (short)100, "image/planets/Eredenn_Prime.png");
		planet.addInternalBorder(new Border("Eredenn Prime", "Coruscant"));
		planet.addInternalBorder(new Border("Eredenn Prime", "Ilum"));
		planet.addInternalBorder(new Border("Eredenn Prime", "Sarapin"));
		planet.addExternalBorder(new Border("Eredenn Prime", "Nelvaan"));
		addPlanet(planet);
		
		planet = new Planet((short) 10, "Coruscant", (short)650, (short)290, "image/planets/Coruscant.png");
		planet.addInternalBorder(new Border("Coruscant", "Eredenn Prime"));
		planet.addExternalBorder(new Border("Coruscant", "Yag'Dhul"));
		planet.addExternalBorder(new Border("Coruscant", "Pengalan IV"));
		planet.addExternalBorder(new Border("Coruscant", "Muunlist"));
		planet.addExternalBorder(new Border("Coruscant", "Ando"));
		planet.addExternalBorder(new Border("Coruscant", "Elrood"));
		addPlanet(planet);
		
		planet = new Planet((short) 11, "Yavin IV", (short)1015, (short)10, "image/planets/Yavin_IV.png");
		planet.addInternalBorder(new Border("Yavin IV", "Corellia"));
		planet.addInternalBorder(new Border("Yavin IV", "Nelvaan"));
		addPlanet(planet);
		
		planet = new Planet((short) 12, "Kamino", (short)1170, (short)20, "image/planets/Kamino.png");
		planet.addInternalBorder(new Border("Kamino", "Corellia"));
		planet.addInternalBorder(new Border("Kamino", "Ando"));
		addPlanet(planet);
		
		planet = new Planet((short) 13, "Corellia", (short)1100, (short)60, "image/planets/Corellia.png");
		planet.addInternalBorder(new Border("Corellia", "Yavin IV"));
		planet.addInternalBorder(new Border("Corellia", "Kamino"));
		planet.addInternalBorder(new Border("Corellia", "Nelvaan"));
		planet.addInternalBorder(new Border("Corellia", "Rhen Var"));
		planet.addExternalBorder(new Border("Corellia", "Kashyyyk"));
		addPlanet(planet);
		
		planet = new Planet((short) 14, "Nelvaan", (short)1025, (short)90, "image/planets/Nelvaan.png");
		planet.addInternalBorder(new Border("Nelvaan", "Yavin IV"));
		planet.addInternalBorder(new Border("Nelvaan", "Corellia"));
		planet.addInternalBorder(new Border("Nelvaan", "Ando"));
		planet.addExternalBorder(new Border("Nelvaan", "Eredenn Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 15, "Rhen Var", (short)1165, (short)120, "image/planets/Rhen_Var.png");
		planet.addInternalBorder(new Border("Rhen Var", "Corellia"));
		planet.addInternalBorder(new Border("Rhen Var", "Ando"));
		planet.addExternalBorder(new Border("Rhen Var", "Calamari"));
		addPlanet(planet);
		
		planet = new Planet((short) 16, "Ando", (short)1095, (short)155, "image/planets/Ando.png");
		planet.addInternalBorder(new Border("Ando", "Kamino"));
		planet.addInternalBorder(new Border("Ando", "Rhen Var"));
		planet.addInternalBorder(new Border("Ando", "Nelvaan"));
		planet.addExternalBorder(new Border("Ando", "Coruscant"));
		planet.addExternalBorder(new Border("Ando", "Sy Myrth"));
		addPlanet(planet);
		
		planet = new Planet((short) 17, "Tynna", (short)230, (short)350, "image/planets/Tynna.png");
		planet.addExternalBorder(new Border("Tynna", "Dantooine"));
		planet.addExternalBorder(new Border("Tynna", "Geonosis"));
		addPlanet(planet);
		
		planet = new Planet((short) 18, "Sy Myrth", (short)1030, (short)300, "image/planets/Sy_Myrth.png");
		planet.addExternalBorder(new Border("Sy Myrth", "Ando"));
		planet.addExternalBorder(new Border("Sy Myrth", "Danjar"));
		addPlanet(planet);
		
		planet = new Planet((short) 19, "Geonosis", (short)130, (short)500, "image/planets/Geonosis.png");
		planet.addInternalBorder(new Border("Geonosis", "Mustafar"));
		planet.addInternalBorder(new Border("Geonosis", "Yag'Dhul"));
		planet.addExternalBorder(new Border("Geonosis", "Tynna"));
		addPlanet(planet);
		
		planet = new Planet((short) 20, "Mustafar", (short)105, (short)580, "image/planets/Mustafar.png");
		planet.addInternalBorder(new Border("Mustafar", "Nivek"));
		planet.addInternalBorder(new Border("Mustafar", "Geonosis"));
		planet.addExternalBorder(new Border("Mustafar", "Alaris Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 21, "Yag'Dhul", (short)185, (short)570, "image/planets/Yag'Dhul.png");
		planet.addInternalBorder(new Border("Yag'Dhul", "Hypori"));
		planet.addInternalBorder(new Border("Yag'Dhul", "Tatooine"));
		planet.addInternalBorder(new Border("Yag'Dhul", "Geonosis"));
		planet.addExternalBorder(new Border("Yag'Dhul", "Coruscant"));
		addPlanet(planet);
		
		planet = new Planet((short) 22, "Hypori", (short)280, (short)575, "image/planets/Hypori.png");
		planet.addInternalBorder(new Border("Hypori", "Tatooine"));
		planet.addInternalBorder(new Border("Nivek", "Mustafar"));
		planet.addExternalBorder(new Border("Hypori", "Thule"));		
		addPlanet(planet);
		
		planet = new Planet((short) 23, "Nivek", (short)150, (short) 650, "image/planets/Nivek.png");
		planet.addInternalBorder(new Border("Nivek", "Tatooine"));
		planet.addExternalBorder(new Border("Nivek", "Naboo"));
		addPlanet(planet);
		
		planet = new Planet((short) 24, "Tatooine", (short)240, (short)645, "image/planets/Tatooine.png");
		planet.addInternalBorder(new Border("Tatooine", "Yag'Dhul"));
		planet.addInternalBorder(new Border("Tatooine", "Hypori"));
		planet.addInternalBorder(new Border("Tatooine", "Nivek"));
		addPlanet(planet);
		
		planet = new Planet((short) 25, "Pengalan IV", (short)700, (short)460, "image/planets/Pengalan_IV.png");
		planet.addExternalBorder(new Border("Pengalan IV", "Coruscant"));
		planet.addExternalBorder(new Border("Pengalan IV", "Thule"));
		planet.addExternalBorder(new Border("Pengalan IV", "Queita"));
		planet.addExternalBorder(new Border("Pengalan IV", "Raxus"));
		addPlanet(planet);
		
		planet = new Planet((short) 26, "Raxus", (short)620, (short)630, "image/planets/Raxus.png");
		planet.addInternalBorder(new Border("Raxus", "Thule"));
		planet.addExternalBorder(new Border("Raxus", "Pengalan IV"));
		addPlanet(planet);
		
		planet = new Planet((short) 27, "Queita", (short)730, (short)580, "image/planets/Queita.png");
		planet.addInternalBorder(new Border("Queita", "Thule"));
		planet.addExternalBorder(new Border("Queita", "Pengalan IV"));
		planet.addExternalBorder(new Border("Queita", "Elrood"));
		addPlanet(planet);
		
		planet = new Planet((short) 28, "Thule", (short)560, (short)550, "image/planets/Thule.png");
		planet.addInternalBorder(new Border("Thule", "Queita"));
		planet.addInternalBorder(new Border("Thule", "Raxus"));	
		planet.addExternalBorder(new Border("Thule", "Hypori"));
		planet.addExternalBorder(new Border("Thule", "Pengalan IV"));
		addPlanet(planet);		

		planet = new Planet((short) 29, "Elrood", (short)1005, (short)540, "image/planets/Elrood.png");
		planet.addInternalBorder(new Border("Elrood", "Danjar"));
		planet.addInternalBorder(new Border("Elrood", "Sluis"));
		planet.addExternalBorder(new Border("Elrood", "Coruscant"));
		planet.addExternalBorder(new Border("Elrood", "Queita"));
		addPlanet(planet);		
		
		planet = new Planet((short) 30, "Danjar", (short)1075, (short)550, "image/planets/Danjar.png");
		planet.addInternalBorder(new Border("Danjar", "Tantra"));
		planet.addInternalBorder(new Border("Danjar", "Sluis"));
		planet.addInternalBorder(new Border("Danjar", "Kashyyyk"));
		planet.addInternalBorder(new Border("Danjar", "Elrood"));
		planet.addExternalBorder(new Border("Danjar", "Sy Myrth"));
		addPlanet(planet);
		
		planet = new Planet((short) 31, "Tantra", (short)1135, (short)520, "image/planets/Tantra.png");
		planet.addInternalBorder(new Border("Tantra", "Alaris Prime"));
		planet.addInternalBorder(new Border("Tantra", "Danjar"));
		addPlanet(planet);
		
		planet = new Planet((short) 32, "Sluis", (short)985, (short)630, "image/planets/Sluis.png");
		planet.addInternalBorder(new Border("Sluis", "Elrood"));
		planet.addInternalBorder(new Border("Sluis", "Danjar"));
		planet.addInternalBorder(new Border("Sluis", "Alaris Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 33, "Kashyyyk", (short)1080, (short)650, "image/planets/Kashyyyk.png");
		planet.addInternalBorder(new Border("Kashyyyk", "Danjar"));
		planet.addInternalBorder(new Border("Kashyyyk", "Sluis"));
		planet.addInternalBorder(new Border("Kashyyyk", "Alaris Prime"));
		planet.addExternalBorder(new Border("Kashyyyk", "Corellia"));
		addPlanet(planet);
		
		planet = new Planet((short) 34, "Alaris Prime", (short)1170, (short)590, "image/planets/Alaris_Prime.png");
		planet.addInternalBorder(new Border("Alaris Prime", "Tantra"));
		planet.addInternalBorder(new Border("Alaris Prime", "Kashyyyk"));
		planet.addExternalBorder(new Border("Alaris Prime", "Mustafar"));
		addPlanet(planet);
	}
}
