import java.util.Iterator;

public class CardsAchievement {

	public static void giveTerritoryCard(Player player) {
		War war = War.getInstance();
		if (war.territoryWon) {
			Iterator<TerritoryCard> iterator = war.getTerritoryCards()
					.iterator();
			TerritoryCard tc = iterator.next();
			player.addTerritoryCards(tc);
			war.getTerritoryCards().remove(tc);
		}
	}

}