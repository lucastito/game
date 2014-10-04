import java.util.List;

public class PlanetSystem 
{
	private String name;
	private List<Planet> planets;
	private List<Border> internalBorders;	
	
	public void addPlanet(Planet planet) 
	{
		planets.add(planet);
	}
	
	public void addBorder(Border border)
	{
		internalBorders.add(border);
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
	
	public List<Border> getBorders()
	{
		return internalBorders;
	}
}