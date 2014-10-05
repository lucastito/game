import java.util.ArrayList;
import java.util.List;

public class PlanetSystem 
{
	private String name;
	private List<Planet> planets;
	
	public PlanetSystem()
	{
		planets = new ArrayList<Planet>();
	}
	
	public void addPlanet(Planet planet) 
	{
		planets.add(planet);
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public List<Planet> getPlanets() 
	{
		return planets;
	}	
}