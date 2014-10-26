public class ObjectiveCardRepository implements IObjectiveCardRepository{
	private ObjectiveCard padawansObjectiveCard;
	private ObjectiveCard sithsObjectiveCard;
	private ObjectiveCard clonesObjectiveCard;
	private ObjectiveCard droidesObjectiveCard;
	private ObjectiveCard trandoshansObjectiveCard;
	private ObjectiveCard wookieesObjectiveCard;

	public ObjectiveCardRepository(PlanetRepository pr) 
	{
		Planet[] padawansPlanets = { pr.getPlanetByName("Thule"),
				pr.getPlanetByName("Raxus"), pr.getPlanetByName("Queita"),
				pr.getPlanetByName("Coruscant"), pr.getPlanetByName("Sarapin"),
				pr.getPlanetByName("Ilum"), pr.getPlanetByName("Eredenn Prime") };
		padawansObjectiveCard = new ObjectiveCard((short) 1,
				"Padawan's objective card", padawansPlanets, (short) 19,
				"image/Padawan.png", "image/Verse.png");
		
		Planet[] sithsPlanets = { pr.getPlanetByName("Thule"),
				pr.getPlanetByName("Raxus"), pr.getPlanetByName("Queita"),
				pr.getPlanetByName("Coruscant"), pr.getPlanetByName("Sarapin"),
				pr.getPlanetByName("Ilum"), pr.getPlanetByName("Eredenn Prime") };
		sithsObjectiveCard = new ObjectiveCard((short) 2,
				"Sith's objective card", sithsPlanets, (short) 19,
				"image/Sith.png", "image/Verse.png");
		
		Planet[] clonesPlanets = { pr.getPlanetByName("Geonosis"),
				pr.getPlanetByName("Tatooine"), pr.getPlanetByName("Mustafar"),
				pr.getPlanetByName("Nivek"), pr.getPlanetByName("Hypori"),
				pr.getPlanetByName("Kamino") };
		clonesObjectiveCard = new ObjectiveCard((short) 3,
				"Clone's objective card", clonesPlanets, (short) 20,
				"image/Clone.png", "image/Verse.png");
		
		Planet[] droidesPlanets = { pr.getPlanetByName("Geonosis"),
				pr.getPlanetByName("Tatooine"), pr.getPlanetByName("Mustafar"),
				pr.getPlanetByName("Nivek"), pr.getPlanetByName("Hypori"),
				pr.getPlanetByName("Kamino") };
		droidesObjectiveCard = new ObjectiveCard((short) 4,
				"Droide's objective card", droidesPlanets, (short) 20,
				"image/Droide.png", "image/Verse.png");
		
		Planet[] trandoshansPlanets = { pr.getPlanetByName("Trandosha"),
				pr.getPlanetByName("Kashyyyk"),
				pr.getPlanetByName("Alaris Prime") };
		trandoshansObjectiveCard = new ObjectiveCard((short) 5,
				"Trandoshan's objective card", trandoshansPlanets, (short) 23,
				"image/Trandoshan.png", "image/Verse.png");
		
		Planet[] wookieesPlanets = { pr.getPlanetByName("Trandosha"),
				pr.getPlanetByName("Kashyyyk"),
				pr.getPlanetByName("Alaris Prime") };
		wookieesObjectiveCard = new ObjectiveCard((short) 6,
				"Wookiee's objetive card", wookieesPlanets, (short) 23,
				"image/Wookiee.png", "image/Verse.png");
	}

	public ObjectiveCard getObjectiveCard(Player owner) {
		switch (owner.getRace()) 
		{
			case PADAWAN:
				return padawansObjectiveCard;
			case SITH:
				return sithsObjectiveCard;
			case CLONE:
				return clonesObjectiveCard;
			case DROIDE:
				return droidesObjectiveCard;
			case TRANDOSHAN:
				return trandoshansObjectiveCard;
			case WOOKIEE:
				return wookieesObjectiveCard;
			}
		return null;
	}

}
