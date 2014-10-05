import java.util.List;
import java.util.Map;


public interface IPlanetRepository 
{
	Map<String, Planet> getPlanets();
	Planet getPlanetByName(String name);
	List<Planet> getNeighborPlanets(String planetName);
}
