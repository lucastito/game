import java.util.ArrayList;
import java.util.List;

public class Player {
	private short id;
	private String name;
	private List<Planet> territories;
	private List<Piece> pieces;
	private PlayerRace race;

	public Player(short id, String name) {
		this.id = id;
		this.name = name;
		pieces = new ArrayList<Piece>();
		territories = new ArrayList<Planet>();
	}

	public List<Planet> getTerritories() {
		return territories;
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

	public List<Piece> getPieces() {
		return pieces;
	}

	public void addPiece(Piece piece) {
		this.pieces.add(piece);
	}

	public PlayerRace getRace() {
		return race;
	}

	public void setRace(PlayerRace race) {
		this.race = race;
	}

	public short getId() {
		return id;
	}
}
