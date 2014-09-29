package Domain;

public class PlanetSystem {
	private short Id;
	private Planet[] Planets;
	private Border[] InternalBorders;

	public short getId() {
		return Id;
	}

	public Planet[] getPlanets() {
		return Planets;
	}

	public Border[] getInternalBorders() {
		return InternalBorders;
	}

	public void setId(short id) {
		Id = id;
	}

	public void setPlanets(Planet[] planets) {
		Planets = planets;
	}

	public void setInternalBorders(Border[] internalBorders) {
		InternalBorders = internalBorders;
	}
}