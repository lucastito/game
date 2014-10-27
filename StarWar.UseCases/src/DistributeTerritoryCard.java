import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DistributeTerritoryCard {

	public void distributeTerritories(Player player1, Player player2,
			IPlanetRepository pr) {
		Set<Planet> planets = new HashSet<Planet>(pr.getPlanets().values());
		int sizePlanets = planets.size();
		Set<Planet> player1sPlanet = new HashSet<Planet>();
		Set<Planet> player2sPlanet = new HashSet<Planet>();
		verifyAndDistributeForRace(player1.getRace(), player1sPlanet, planets,
				pr);
		verifyAndDistributeForRace(player2.getRace(), player2sPlanet, planets,
				pr);
		int cont = sizePlanets;
Iterator<Planet> iterator = planets.iterator();
		while (cont > 0) {
			if (player1sPlanet.size() < sizePlanets / 2) {
				player1sPlanet.add(iterator.next());
iterator.remove();
				cont--;
			}
			if (player2sPlanet.size() < sizePlanets / 2) {
				player2sPlanet.add(iterator.next());
iterator.remove();
				cont--;
			}
		}
		player1.setTerritories(player1sPlanet);
		player2.setTerritories(player2sPlanet);
	}

	private void verifyAndDistributeForRace(PlayerRace playerRace,
			Set<Planet> pl, Set<Planet> planets, IPlanetRepository pr) {
		switch (playerRace) {
		case PADAWAN:
			pl.add(pr.getPlanetByName("Coruscant"));
			planets.remove(pr.getPlanetByName("Coruscant"));
			pl.add(pr.getPlanetByName("Sarapin"));
			planets.remove(pr.getPlanetByName("Sarapin"));
			pl.add(pr.getPlanetByName("Ilum"));
			planets.remove(pr.getPlanetByName("Ilum"));
			pl.add(pr.getPlanetByName("Eredenn Prime"));
			planets.remove(pr.getPlanetByName("Eredenn Prime"));
		case SITH:
			pl.add(pr.getPlanetByName("Thule"));
			planets.remove(pr.getPlanetByName("Thule"));
			pl.add(pr.getPlanetByName("Raxus"));
			planets.remove(pr.getPlanetByName("Raxus"));
			pl.add(pr.getPlanetByName("Queita"));
			planets.remove(pr.getPlanetByName("Queita"));
		case CLONE:
			pl.add(pr.getPlanetByName("Kamino"));
			planets.remove(pr.getPlanetByName("Kamino"));
		case DROIDE:
			pl.add(pr.getPlanetByName("Geonosis"));
			planets.remove(pr.getPlanetByName("Geonosis"));
			pl.add(pr.getPlanetByName("Tatooine"));
			planets.remove(pr.getPlanetByName("Tatooine"));
			pl.add(pr.getPlanetByName("Mustafar"));
			planets.remove(pr.getPlanetByName("Mustafar"));
			pl.add(pr.getPlanetByName("Nivek"));
			planets.remove(pr.getPlanetByName("Nivek"));
			pl.add(pr.getPlanetByName("Hypori"));
			planets.remove(pr.getPlanetByName("Hypori"));
		case TRANDOSHAN:
			pl.add(pr.getPlanetByName("Trandosha"));
			planets.remove(pr.getPlanetByName("Trandosha"));
		case WOOKIEE:
			pl.add(pr.getPlanetByName("Kashyyyk"));
			planets.remove(pr.getPlanetByName("Kashyyyk"));
			pl.add(pr.getPlanetByName("Alaris Prime"));
			planets.remove(pr.getPlanetByName("Alaris Prime"));
		}
	}

	public void distributTerritoryCards() {

	}
}
