import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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

	public static void attack() {

	}

	public static void redeploy() {

	}

	public static void pickUpCard() {
		 CardsAchievement.giveTerritoryCard(player);
	}

	public static void setPlayer(Player ai) {
		player = ai;
	}
}
