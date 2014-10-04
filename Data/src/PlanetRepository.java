import java.util.HashMap;
import java.util.Map;

public class PlanetRepository implements IPlanetRepository
{
	private HashMap<String, Planet> planets;
	
	public PlanetRepository()
	{
		initializePlanets();
	}	
	
	public  void addPlanet(Planet planet){
		planets.put(planet.getName(), planet);
	}
	
	public Map<String, Planet> getPlanets() {
		return planets;
	}
	
	public Planet getPlanetByName(String name) {
		return planets.get(name);
	}

	private void initializePlanets() {
		planets = new HashMap<String, Planet>();
		Planet planet;
		planet = new Planet((short) 1, "Trandosha", (short)20, (short)20, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 2, "Muunilist", (short)90, (short)15, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 3, "Bakura", (short)160, (short)30, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 4, "Calamari", (short)18, (short)90, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 5, "Naboo", (short)100, (short)100, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 6, "Dantooine", (short)60, (short)170, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 7, "Ilum", (short)650, (short)25, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 8, "Sarapin", (short)580, (short)110, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 9, "Eredeen Prime", (short)710, (short)100, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 10, "Coruscant", (short)650, (short)290, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 11, "Yavin IV", (short)1115, (short)10, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 12, "Kamino", (short)1270, (short)20, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 13, "Corellia", (short)1200, (short)60, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 14, "Nelvaan", (short)1125, (short)90, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 15, "Rhen Var", (short)1265, (short)120, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 16, "Ando", (short)1195, (short)155, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 17, "Tynna", (short)130, (short)350, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 18, "Sy Myrth", (short)1130, (short)300, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 19, "Geonosis", (short)30, (short)500, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 20, "Mustafar", (short)5, (short)580, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 21, "Yag'Dhul", (short)85, (short)570, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 22, "Hypori", (short)180, (short)575, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 23, "Nivek", (short)50, (short) 650, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 24, "Tatooine", (short)140, (short)645, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 25, "Pengalan IV", (short)700, (short)460, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 26, "Raxus", (short)560, (short)550, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 27, "Queita", (short)730, (short)580, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 28, "Thule", (short)620, (short)630, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 29, "Elrood", (short)1105, (short)540, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 30, "Danjar", (short)1175, (short)550, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 31, "Tantra", (short)1235, (short)520, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 32, "Sluis", (short)1085, (short)630, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 33, "Kashyyyk", (short)1180, (short)650, "image/imgicon.png");
		addPlanet(planet);
		
		planet = new Planet((short) 34, "Alaris Prime", (short)1270, (short)590, "image/imgicon.png");
		addPlanet(planet);
	}
}
