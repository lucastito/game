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

	private void initializePlanets() {
		planets = new HashMap<String, Planet>();
		Planet planet;

		planet = new Planet((short) 1, "Trandosha", (short)20, (short)20, "image/imgicon.png");
		planet.addInternalBorder(new Border("Trandosha", "Naboo"));
		planet.addInternalBorder(new Border("Trandosha", "Calamari"));
		planet.addInternalBorder(new Border("Trandosha", "Muunilinst"));		
		addPlanet(planet);
		
		planet = new Planet((short) 2, "Naboo", (short)90, (short)15, "image/imgicon.png");
		planet.addInternalBorder(new Border("Naboo", "Trandosha"));
		planet.addInternalBorder(new Border("Naboo", "Bakura"));
		planet.addExternalBorder(new Border("Naboo", "Nivek"));
		addPlanet(planet);
		
		planet = new Planet((short) 3, "Bakura", (short)160, (short)30, "image/bakura.png");
		planet.addInternalBorder(new Border("Bakura", "Naboo"));
		planet.addExternalBorder(new Border("Bakura", "Sarapin"));
		addPlanet(planet);
		
		planet = new Planet((short) 4, "Calamari", (short)18, (short)90, "image/calamari.png");
		planet.addInternalBorder(new Border("Calamari", "Trandosha"));
		planet.addInternalBorder(new Border("Calamari", "Datooine"));
		planet.addExternalBorder(new Border("Calamari", "Rhen Var"));
		addPlanet(planet);
		
		planet = new Planet((short) 5, "Muunilinst", (short)100, (short)100, "image/imgicon.png");
		planet.addInternalBorder(new Border("Muunilinst", "Trandosha"));
		planet.addInternalBorder(new Border("Muunilinst", "Datooine"));
		planet.addExternalBorder(new Border("Muunilinst", "Coruscant"));
		addPlanet(planet);
		
		planet = new Planet((short) 6, "Dantooine", (short)60, (short)170, "image/imgicon.png");
		planet.addInternalBorder(new Border("Dantooine", "Muunilinst"));
		planet.addInternalBorder(new Border("Dantooine", "Calamari"));
		planet.addExternalBorder(new Border("Dantooine", "Tynna"));
		addPlanet(planet);		
		
		planet = new Planet((short) 7, "Ilum", (short)650, (short)25, "image/ilum.png");
		planet.addInternalBorder(new Border("Ilum", "Sarapin"));
		planet.addInternalBorder(new Border("Ilum", "Eredeen Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 8, "Sarapin", (short)580, (short)110, "image/imgicon.png");
		planet.addInternalBorder(new Border("Sarapin", "Eredeen Prime"));
		planet.addInternalBorder(new Border("Sarapin", "Ilum"));
		planet.addInternalBorder(new Border("Sarapin", "Coruscant"));
		planet.addExternalBorder(new Border("Sarapin", "Bakura"));
		addPlanet(planet);
		
		planet = new Planet((short) 9, "Eredeen Prime", (short)710, (short)100, "image/imgicon.png");
		planet.addInternalBorder(new Border("Eredeen Prime", "Coruscant"));
		planet.addInternalBorder(new Border("Eredeen Prime", "Ilum"));
		planet.addInternalBorder(new Border("Eredeen Prime", "Sarapin"));
		planet.addExternalBorder(new Border("Eredeen Prime", "Nelvaan"));
		addPlanet(planet);
		
		planet = new Planet((short) 10, "Coruscant", (short)650, (short)290, "image/coruscant.png");
		planet.addInternalBorder(new Border("Coruscant", "Eredeen Prime"));
		planet.addExternalBorder(new Border("Coruscant", "Yag'Dhul"));
		planet.addExternalBorder(new Border("Coruscant", "Pengalan IV"));
		planet.addExternalBorder(new Border("Coruscant", "Muunilinst"));
		planet.addExternalBorder(new Border("Coruscant", "Ando"));
		planet.addExternalBorder(new Border("Coruscant", "Elrood"));
		addPlanet(planet);
		
		planet = new Planet((short) 11, "Yavin IV", (short)1115, (short)10, "image/imgicon.png");
		planet.addInternalBorder(new Border("Yavin IV", "Corellia"));
		planet.addInternalBorder(new Border("Yavin IV", "Nelvaan"));
		addPlanet(planet);
		
		planet = new Planet((short) 12, "Kamino", (short)1270, (short)20, "image/imgicon.png");
		planet.addInternalBorder(new Border("Kamino", "Corellia"));
		planet.addInternalBorder(new Border("Kamino", "Ando"));
		addPlanet(planet);
		
		planet = new Planet((short) 13, "Corellia", (short)1200, (short)60, "image/imgicon.png");
		planet.addInternalBorder(new Border("Corellia", "Yavin IV"));
		planet.addInternalBorder(new Border("Corellia", "Kamino"));
		planet.addInternalBorder(new Border("Corellia", "Nelvaan"));
		planet.addInternalBorder(new Border("Corellia", "Rhen Var"));
		planet.addExternalBorder(new Border("Corellia", "Kashyyyk"));
		addPlanet(planet);
		
		planet = new Planet((short) 14, "Nelvaan", (short)1125, (short)90, "image/imgicon.png");
		planet.addInternalBorder(new Border("Nelvaan", "Yavin IV"));
		planet.addInternalBorder(new Border("Nelvaan", "Corellia"));
		planet.addInternalBorder(new Border("Nelvaan", "Ando"));
		planet.addExternalBorder(new Border("Nelvaan", "Eredeen Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 15, "Rhen Var", (short)1265, (short)120, "image/imgicon.png");
		planet.addInternalBorder(new Border("Rhen Var", "Corellia"));
		planet.addInternalBorder(new Border("Rhen Var", "Ando"));
		planet.addExternalBorder(new Border("Rhen Var", "Calamari"));
		addPlanet(planet);
		
		planet = new Planet((short) 16, "Ando", (short)1195, (short)155, "image/imgicon.png");
		planet.addInternalBorder(new Border("Ando", "Kamino"));
		planet.addInternalBorder(new Border("Ando", "Rhen Var"));
		planet.addInternalBorder(new Border("Ando", "Nelvaan"));
		planet.addExternalBorder(new Border("Ando", "Coruscant"));
		planet.addExternalBorder(new Border("Ando", "Sy Myrth"));
		addPlanet(planet);
		
		planet = new Planet((short) 17, "Tynna", (short)130, (short)350, "image/imgicon.png");
		planet.addExternalBorder(new Border("Tynna", "Dantooine"));
		planet.addExternalBorder(new Border("Tynna", "Geonosis"));
		addPlanet(planet);
		
		planet = new Planet((short) 18, "Sy Myrth", (short)1130, (short)300, "image/imgicon.png");
		planet.addExternalBorder(new Border("Sy Myrth", "Ando"));
		planet.addExternalBorder(new Border("Sy Myrth", "Danjar"));
		addPlanet(planet);
		
		planet = new Planet((short) 19, "Geonosis", (short)30, (short)500, "image/imgicon.png");
		planet.addInternalBorder(new Border("Geonosis", "Mustafar"));
		planet.addInternalBorder(new Border("Geonosis", "Yag'Dhul"));
		planet.addExternalBorder(new Border("Geonosis", "Tynna"));
		addPlanet(planet);
		
		planet = new Planet((short) 20, "Mustafar", (short)5, (short)580, "image/imgicon.png");
		planet.addInternalBorder(new Border("Mustafar", "Nivek"));
		planet.addInternalBorder(new Border("Mustafar", "Geonosis"));
		planet.addExternalBorder(new Border("Mustafar", "Alaris Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 21, "Yag'Dhul", (short)85, (short)570, "image/imgicon.png");
		planet.addInternalBorder(new Border("Yag'Dhul", "Hypori"));
		planet.addInternalBorder(new Border("Yag'Dhul", "Tatooine"));
		planet.addInternalBorder(new Border("Yag'Dhul", "Geonosis"));
		planet.addExternalBorder(new Border("Yag'Dhul", "Coruscant"));
		addPlanet(planet);
		
		planet = new Planet((short) 22, "Hypori", (short)180, (short)575, "image/imgicon.png");
		planet.addInternalBorder(new Border("Hypori", "Tatooine"));
		planet.addInternalBorder(new Border("Nivek", "Mustafar"));
		planet.addExternalBorder(new Border("Hypori", "Thule"));		
		addPlanet(planet);
		
		planet = new Planet((short) 23, "Nivek", (short)50, (short) 650, "image/imgicon.png");
		planet.addInternalBorder(new Border("Nivek", "Tatooine"));
		planet.addExternalBorder(new Border("Nivek", "Naboo"));
		addPlanet(planet);
		
		planet = new Planet((short) 24, "Tatooine", (short)140, (short)645, "image/imgicon.png");
		planet.addInternalBorder(new Border("Tatooine", "Yag'Dhul"));
		planet.addInternalBorder(new Border("Tatooine", "Hypori"));
		planet.addInternalBorder(new Border("Tatooine", "Nivek"));
		addPlanet(planet);
		
		planet = new Planet((short) 25, "Pengalan IV", (short)700, (short)460, "image/imgicon.png");
		planet.addExternalBorder(new Border("Pengalan IV", "Coruscant"));
		planet.addExternalBorder(new Border("Pengalan IV", "Thule"));
		planet.addExternalBorder(new Border("Pengalan IV", "Queita"));
		planet.addExternalBorder(new Border("Pengalan IV", "Raxus"));
		addPlanet(planet);
		
		planet = new Planet((short) 26,"Thule", (short)620, (short)630, "image/imgicon.png");
		planet.addInternalBorder(new Border("Thule", "Queita"));
		planet.addInternalBorder(new Border("Thule", "Raxus"));	
		planet.addExternalBorder(new Border("Thule", "Hypori"));
		planet.addExternalBorder(new Border("Thule", "Pengalan IV"));
		addPlanet(planet);
		
		planet = new Planet((short) 27, "Queita", (short)730, (short)580, "image/imgicon.png");
		planet.addInternalBorder(new Border("Queita", "Thule"));
		planet.addExternalBorder(new Border("Queita", "Pengalan IV"));
		planet.addExternalBorder(new Border("Queita", "Elrood"));
		addPlanet(planet);
		
		planet = new Planet((short) 28, "Raxus", (short)560, (short)550, "image/imgicon.png");
		planet.addInternalBorder(new Border("Raxus", "Thule"));
		planet.addExternalBorder(new Border("Raxus", "Pengalan IV"));
		addPlanet(planet);		

		planet = new Planet((short) 29, "Elrood", (short)1105, (short)540, "image/imgicon.png");
		planet.addInternalBorder(new Border("Elrood", "Danjar"));
		planet.addInternalBorder(new Border("Elrood", "Sluis"));
		planet.addExternalBorder(new Border("Elrood", "Coruscant"));
		planet.addExternalBorder(new Border("Elrood", "Queita"));
		addPlanet(planet);		
		
		planet = new Planet((short) 30, "Danjar", (short)1175, (short)550, "image/imgicon.png");
		planet.addInternalBorder(new Border("Danjar", "Tantra"));
		planet.addInternalBorder(new Border("Danjar", "Sluis"));
		planet.addInternalBorder(new Border("Danjar", "Kashyyyk"));
		planet.addInternalBorder(new Border("Danjar", "Elrood"));
		planet.addExternalBorder(new Border("Danjar", "Sy Myrth"));
		addPlanet(planet);
		
		planet = new Planet((short) 31, "Tantra", (short)1235, (short)520, "image/imgicon.png");
		planet.addInternalBorder(new Border("Tantra", "Alaris Prime"));
		planet.addInternalBorder(new Border("Tantra", "Danjar"));
		addPlanet(planet);
		
		planet = new Planet((short) 32, "Sluis", (short)1085, (short)630, "image/imgicon.png");
		planet.addInternalBorder(new Border("Sluis", "Elrood"));
		planet.addInternalBorder(new Border("Sluis", "Danjar"));
		planet.addInternalBorder(new Border("Sluis", "Alaris Prime"));
		addPlanet(planet);
		
		planet = new Planet((short) 33, "Kashyyyk", (short)1180, (short)650, "image/imgicon.png");
		planet.addInternalBorder(new Border("Kashyyyk", "Danjar"));
		planet.addInternalBorder(new Border("Kashyyyk", "Sluis"));
		planet.addInternalBorder(new Border("Kashyyyk", "Alaris Prime"));
		planet.addExternalBorder(new Border("Kashyyyk", "Corellia"));
		addPlanet(planet);
		
		planet = new Planet((short) 34, "Alaris Prime", (short)1270, (short)590, "image/imgicon.png");
		planet.addInternalBorder(new Border("Alaris Prime", "Tantra"));
		planet.addInternalBorder(new Border("Alaris Prime", "Kashyyyk"));
		planet.addExternalBorder(new Border("Alaris Prime", "Mustafar"));
		addPlanet(planet);
	}
}
