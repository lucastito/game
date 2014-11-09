import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DistributeTerritoryCard {

	public static void distributeTerritories(IPlayerRepository playerRepository, IPlanetRepository planetRepository) {
		int numberOfPlanets = planetRepository.getPlanets().size();
		int numberOfPlayers = playerRepository.getAllPlayers().size();
		List<Planet> notAddedTerritories = new ArrayList<Planet>(); 
		notAddedTerritories.addAll(planetRepository.getPlanets().values());
		
		for (Player player : playerRepository.getAllPlayers())
		{
			List<Planet> fixedTerritories = distributeTerritoryForRace(player.getRace(), planetRepository); 
			for (Planet territory : fixedTerritories)
			{
				notAddedTerritories.remove(territory);
				playerRepository.getPlayerByName(player.getName()).addTerritory(territory);
				playerRepository.addPlayerPiece(player.getName(), territory.getName(), 1);
			}
		}
		
		while (notAddedTerritories.size() > 0) {
			for (Player player : playerRepository.getAllPlayers())
			{
				if (player.getTerritories().size() < numberOfPlanets / numberOfPlayers) 
				{
					Planet territory = notAddedTerritories.get(0);
					playerRepository.getPlayerByName(player.getName()).addTerritory(territory);
					playerRepository.addPlayerPiece(player.getName(), territory.getName(), 1);
					notAddedTerritories.remove(0);
				}
			}
		}
	}

	private static List<Planet> distributeTerritoryForRace(PlayerRace playerRace, IPlanetRepository planetRepository) 
	{
		List<Planet> planets = new ArrayList<Planet>();
		
		switch (playerRace) 
		{
			case PADAWAN:
				planets.add(planetRepository.getPlanetByName("Coruscant"));
				planets.add(planetRepository.getPlanetByName("Sarapin"));
				planets.add(planetRepository.getPlanetByName("Ilum"));
				planets.add(planetRepository.getPlanetByName("Eredenn Prime"));
				break;
			case SITH:
				planets.add(planetRepository.getPlanetByName("Thule"));
				planets.add(planetRepository.getPlanetByName("Raxus"));
				planets.add(planetRepository.getPlanetByName("Queita"));
				break;
			case CLONE:
				planets.add(planetRepository.getPlanetByName("Kamino"));
				break;
			case DROIDE:
				planets.add(planetRepository.getPlanetByName("Geonosis"));
				planets.add(planetRepository.getPlanetByName("Tatooine"));
				planets.add(planetRepository.getPlanetByName("Mustafar"));
				planets.add(planetRepository.getPlanetByName("Nivek"));
				planets.add(planetRepository.getPlanetByName("Hypori"));
				break;
			case TRANDOSHAN:
				planets.add(planetRepository.getPlanetByName("Trandosha"));
				break;
			case WOOKIEE:
				planets.add(planetRepository.getPlanetByName("Kashyyyk"));
				planets.add(planetRepository.getPlanetByName("Alaris Prime"));
				break;
		}
		return planets;
	}

	public static void distributTerritoryCards(Player player, ITerritoryCardRepository itcr) {
		Set<Planet> territories = player.getTerritories();
		Set<TerritoryCard> territoryCards = new HashSet<TerritoryCard>();
		Iterator<Planet> iterator = territories.iterator();
		while (iterator.hasNext()){
			territoryCards.add(itcr.getTerritoryCardByName(iterator.next().getName()));
		}
		player.setTerritoryCards(territoryCards);
	}
}
