public class ObjectiveCard extends Card {
	Planet[] planetsToConquer;
	short planetsToChoose;

	public ObjectiveCard(Planet[] planetsToConquer, short planetsToChoose) {
		this.planetsToConquer = planetsToConquer;
		this.planetsToChoose = planetsToChoose;
	}
}