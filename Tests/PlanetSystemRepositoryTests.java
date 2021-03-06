import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlanetSystemRepositoryTests 
{
	PlanetSystemRepository planetSystemRepository;
	PlanetRepository planetRepository;
	@Before
	public void setUp() throws Exception 
	{
		planetRepository = new PlanetRepository();
		planetSystemRepository = new PlanetSystemRepository(planetRepository);
	}

	@Test
	public void AddPlanetSystem()
	{
		PlanetSystem planetSystem = new PlanetSystem();
		planetSystem.setName("Via L�ctea");
		planetSystem.addPlanet(new Planet((short) 1, "Earth",(short) 3123, (short) 4234, "path"));
		planetSystemRepository.addPlanetSystem(planetSystem);
		
		PlanetSystem result = planetSystemRepository.getPlanetSystemByName("Via L�ctea");
		
		assertEquals("Via L�ctea", result.getName());
		assertEquals(1, result.getPlanets().size());
	}
	
	@Test
	public void GetPlanetSystemByName_GetsPanet()
	{
		PlanetSystem result = planetSystemRepository.getPlanetSystemByName("Imperial Remnant");
		
		assertEquals("Imperial Remnant", result.getName());
		assertEquals(6, result.getPlanets().size());
	}
	
	@Test
	public void GetPlanetSystemByName_SendingNullPLanetName_ReturnsNull()
	{
		PlanetSystem result = planetSystemRepository.getPlanetSystemByName(null);
		assertEquals(null, result);
	}
	
	@Test
	public void GetPlanetSystemByName_SendingEmptyPLanetName_ReturnsNull()
	{
		PlanetSystem result = planetSystemRepository.getPlanetSystemByName("");		
		assertEquals(null, result);;
	}
	
	@Test
	public void GetPlanetSystemByName_SendingWrongPLanetName_ReturnsNull()
	{
		PlanetSystem result = planetSystemRepository.getPlanetSystemByName("Aldebaran");		
		assertEquals(null, result);;
	}

}
