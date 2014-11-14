import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AI {
	private static Player player;

	public static void deploy(IPlanetRepository planetRepository,
			TroopsDistribution distribution, int numberOfUnits) {
		Planet[] planetsToConquer = player.getObjectiveCard()
				.getPlanetsToConquer();
		Planet[] planetsToDefend = player.getObjectiveCard()
				.getPlanetsToDefend();
		HashSet<Planet> nearbyPlanets = new HashSet<Planet>();
		for (int i = 0; i < planetsToConquer.length; i++) {
			List<Border> list = planetsToConquer[i].getBorders();
			for (int j = 0; j < list.size(); j++) {
				nearbyPlanets.add(planetRepository.getPlanetByName(list.get(j)
						.getNeighborPlanetName()));
			}
		}
		while (numberOfUnits > 0) {
			for (int i = 0; i < planetsToDefend.length; i++) {
				if (planetsToDefend[i].getOwnerName().equalsIgnoreCase(
						player.getName())) {
					distribution.distributeTroops(1, player.getName(),
							planetsToDefend[i].getName());
					numberOfUnits--;
				}
			}
			Iterator<Planet> iterator = nearbyPlanets.iterator();
			while (iterator.hasNext()) {
				Planet planet = iterator.next();
				if (planet.getOwnerName().equalsIgnoreCase(player.getName())) {
					distribution.distributeTroops(1, player.getName(),
							planet.getName());
					numberOfUnits--;
				}
			}
		}
	}

	public static void attack(IPlanetRepository planetRepository,
			Attack attack, IPlayerRepository playerRepository) {
		Map<Planet, Integer> piecesByPlanet = myPlanetsAndMyUnits();
		Iterator<Map.Entry<Planet, Integer>> entryIterator = piecesByPlanet
				.entrySet().iterator();
		Integer maximusValue = 0;
		Planet planetKey = null;
		Integer maximusValueTemporary;
		while (entryIterator.hasNext()) {
			Entry<Planet, Integer> entry = entryIterator.next();
			maximusValueTemporary = entry.getValue();
			if (maximusValueTemporary.compareTo(maximusValue) > 0) {
				maximusValue = maximusValueTemporary;
				planetKey = entry.getKey();
			}
		}
		List<Planet> nearbyPlanets = new ArrayList<Planet>();
		List<Border> list = planetKey.getBorders();
		for (int j = 0; j < list.size(); j++) {
			nearbyPlanets.add(planetRepository.getPlanetByName(list.get(j)
					.getNeighborPlanetName()));
		}
		for (int k = 0; k < nearbyPlanets.size(); k++) {
			Planet p = nearbyPlanets.get(k);
			if (!p.getOwnerName().equalsIgnoreCase(player.getName())
					&& maximusValue.compareTo(attack
							.quantityBYPlanetName(playerRepository
									.getAllPlayers().get(1).getPieces(),
									p.getName())) < 0) {
				nearbyPlanets.remove(p);
			}
		}
		if (!nearbyPlanets.isEmpty()) {
			boolean conquer = false;
			while (attack.quantityBYPlanetName(player.getPieces(),
					planetKey.getName()) > 1
					&& !conquer) 
			{
					attack.attack(planetKey.getName(), nearbyPlanets.get(0)
							.getName());
			}
		}
	}

	public static void redeploy() {

	}

	public static void pickUpCard() {
		CardsAchievement.giveTerritoryCard(player);
	}

	public static void setPlayer(Player ai) {
		player = ai;
	}

	private static Map<Planet, Integer> myPlanetsAndMyUnits() {
		Map<Planet, Integer> myPlanetsAndMyUnits = new HashMap<Planet, Integer>();
		Iterator<Planet> planetIterator = player.getTerritories().iterator();
		Set<Piece> pieces = player.getPieces();
		Iterator<Piece> pieceIterator;
		int quantityPieces;
		
		while (planetIterator.hasNext())
		{
			Planet planet = planetIterator.next();
			pieceIterator = pieces.iterator();
			quantityPieces = 0;
			while (pieceIterator.hasNext())
			{
				Piece piece = pieceIterator.next();
				if(piece.getTerritoryName().equalsIgnoreCase(planet.getName()))
				{
					quantityPieces++;
					pieceIterator.remove();
				}
			}
			myPlanetsAndMyUnits.put(planet, quantityPieces);
		}
		return myPlanetsAndMyUnits;
	}
}
