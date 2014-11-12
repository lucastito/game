import java.util.Iterator;

public class CardsAchievement {

	public void giveTerritoryCard(Player player) {
		War war = War.getInstance();
		if (war.getTerritoryWon()) {
			Iterator<TerritoryCard> iterator = war.getTerritoryCards()
					.iterator();
			TerritoryCard tc = iterator.next();
			player.addTerritoryCards(tc);
			war.getTerritoryCards().remove(tc);
		}
	}

}