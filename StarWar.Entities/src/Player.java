import java.util.HashSet;
import java.util.Set;

public class Player {
	private String name;
	private Set<Planet> territories;
	private Set<Piece> pieces;
	private Set<TerritoryCard> territoryCards;
	private PlayerRace race;

	public Player(PlayerRace race, String name) {
		this.race = race;
		this.name = name;
		pieces = new HashSet<Piece>();
		territories = new HashSet<Planet>();
	}

	public Set<Planet> getTerritories() {
		return territories;
	}

	public void setTerritories(Set<Planet> territories) {
		this.territories = territories;
	}

	public void addTerritory(Planet territory) {
		this.territories.add(territory);
		territory.setOwnerName(this.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}

	public PlayerRace getRace() {
		return race;
	}

	public void setTerritoryCards(Set<TerritoryCard> territoryCards) {
		this.territoryCards = territoryCards;
	}

}
