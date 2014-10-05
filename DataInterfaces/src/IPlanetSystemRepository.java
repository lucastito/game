import java.util.Map;


public interface IPlanetSystemRepository 
{
	void addPlanetSystem(PlanetSystem planetSystem);
	PlanetSystem getPlanetSystemByName(String name);
	Map<String, PlanetSystem> getPlanetSystems();
}
