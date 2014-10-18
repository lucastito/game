import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class PlanetRepositoryTests 
{
	PlanetRepository planetRepository;
	
	@Before
	public void setUp() throws Exception 
	{
		planetRepository = new PlanetRepository();
	}

	@Test
	public void GetNeighborPlanets_MustReturnAllNeighborsList() 
	{
		List<Planet> results = planetRepository.getNeighborPlanets("Naboo");
		List<String> resultsName = new ArrayList<String>();
		
		for(Planet result : results)
		{
			resultsName.add(result.getName());
		}
		
		assertEquals(true, resultsName.contains("Trandosha"));
		assertEquals(true, resultsName.contains("Bakura"));
		assertEquals(true, resultsName.contains("Nivek"));
	}
	
	@Test
	public void GetNeighborPlanets_SendingEmptyPlanetName_ReturnsNull()
	{
		List<Planet> results = planetRepository.getNeighborPlanets("");
		assertEquals(null, results);
	}
	
	@Test
	public void GetNeighborPlanets_SendingNullPlanetName_ReturnsNull()
	{
		List<Planet> results = planetRepository.getNeighborPlanets(null);
		assertEquals(null, results);
	}
	
	@Test
	public void GetNeighborPlanets_SendingWrongPlanetName_ReturnsNull()
	{
		List<Planet> results = planetRepository.getNeighborPlanets("Pluto");
		assertEquals(null, results);
	}
	
	@Test
	public void AddPlanet()
	{
		planetRepository.addPlanet(new Planet((short)1000, "Venus", (short) 1, (short) 2, "local"));
		
		Planet result = planetRepository.getPlanetByName("Venus");
		
		assertEquals(1000, result.getId());
		assertEquals("Venus", result.getName());
		assertEquals(1, result.getXAxisCoordinate());
		assertEquals(2, result.getYAxisCoordinate());
		assertEquals("local", result.getImagePath());
	}
	
	@Test
	public void GetPlanetByName_GetsPlanet()
	{
		Planet result = planetRepository.getPlanetByName("Coruscant");
		
		assertEquals(10, result.getId());
		assertEquals("Coruscant", result.getName());
		assertEquals(650, result.getXAxisCoordinate());
		assertEquals(290, result.getYAxisCoordinate());
		assertEquals("image/coruscant.png", result.getImagePath());
	}
	
	@Test
	public void GetPlanetByName_SendingNullPLanetName_ReturnsNull()
	{
		Planet result = planetRepository.getPlanetByName(null);
		assertEquals(null, result);
	}
	
	@Test
	public void GetPlanetByName_SendingEmptyPLanetName_ReturnsNull()
	{
		Planet result = planetRepository.getPlanetByName("");		
		assertEquals(null, result);;
	}
	
	@Test
	public void GetPlanetByName_SendingWrongPLanetName_ReturnsNull()
	{
		Planet result = planetRepository.getPlanetByName("Earth");		
		assertEquals(null, result);;
	}
	
	@Test
	public void SetPlanetOwner_SetsPlanetOwner()
	{
		planetRepository.setPlanetOwner("Trandosha", "Leo");
		Planet result = planetRepository.getPlanetByName("Trandosha");
		
		assertEquals("Leo", result.getOwnerName());
	}
}

