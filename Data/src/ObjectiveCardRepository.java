public class ObjectiveCardRepository {
	private Card padawansObjectiveCard;
	private Card sithsObjectiveCard;
	private Card clonesObjectiveCard;
	private Card droidesObjectiveCard;
	private Card trandoshansObjectiveCard;
	private Card wookieesObjectiveCard;

	public ObjectiveCardRepository(PlanetRepository pr) {
		Planet[] padawansPlanets = { pr.getPlanetByName("Thule"),
				pr.getPlanetByName("Raxus"), pr.getPlanetByName("Queita"),
				pr.getPlanetByName("Coruscant"), pr.getPlanetByName("Sarapin"),
				pr.getPlanetByName("Ilum"), pr.getPlanetByName("Eredenn Prime") };
		padawansObjectiveCard = new ObjectiveCard(padawansPlanets, (short) 19);
		Planet[] sithsPlanets = { pr.getPlanetByName("Thule"),
				pr.getPlanetByName("Raxus"), pr.getPlanetByName("Queita"),
				pr.getPlanetByName("Coruscant"), pr.getPlanetByName("Sarapin"),
				pr.getPlanetByName("Ilum"), pr.getPlanetByName("Eredenn Prime") };
		sithsObjectiveCard = new ObjectiveCard(sithsPlanets, (short) 19);
		Planet[] clonesPlanets = { pr.getPlanetByName("Geonosis"),
				pr.getPlanetByName("Tatooine"), pr.getPlanetByName("Mustafar"),
				pr.getPlanetByName("Nivek"), pr.getPlanetByName("Hypori"),
				pr.getPlanetByName("Kamino") };
		clonesObjectiveCard = new ObjectiveCard(clonesPlanets, (short) 20);
		Planet[] droidesPlanets = { pr.getPlanetByName("Geonosis"),
				pr.getPlanetByName("Tatooine"), pr.getPlanetByName("Mustafar"),
				pr.getPlanetByName("Nivek"), pr.getPlanetByName("Hypori"),
				pr.getPlanetByName("Kamino") };
		droidesObjectiveCard = new ObjectiveCard(droidesPlanets, (short) 20);
		Planet[] trandoshansPlanets = { pr.getPlanetByName("Trandosha"),
				pr.getPlanetByName("Kashyyyk"),
				pr.getPlanetByName("Alaris Prime") };
		trandoshansObjectiveCard = new ObjectiveCard(trandoshansPlanets,
				(short) 23);
		Planet[] wookieesPlanets = { pr.getPlanetByName("Trandosha"),
				pr.getPlanetByName("Kashyyyk"),
				pr.getPlanetByName("Alaris Prime") };
		wookieesObjectiveCard = new ObjectiveCard(wookieesPlanets, (short) 23);
	}

	public Card getObjectiveCard(Piece owner) {
		short id = owner.getId();
		switch (id) {
		case 1:
			return padawansObjectiveCard;
		case 2:
			return sithsObjectiveCard;
		case 3:
			return clonesObjectiveCard;
		case 4:
			return droidesObjectiveCard;
		case 5:
			return trandoshansObjectiveCard;
		case 6:
			return wookieesObjectiveCard;
		}
		return null;
	}

}