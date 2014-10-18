public class ObjectiveCard extends Card {
	
	/* public class Player {
	
	public static final int PADAWAN = 0;
	public static final int SITH = 1;
	public static final int CLONE = 2;
	public static final int DROIDE = 3;
	public static final int WOOKIEE = 4;
	public static final int TRANDOSHAN = 5;
	*/
	
	public static final String PADAWAN_OBJECTIVE_DESCRIPTION = "Conquistar Thule, Raxus, Queita e mais 19 planetas a escolha do jogador. Proteger Coruscant, Sarapin, Ilum e Eredenn Prime.";
	public static final String SITH_OBJECTIVE_DESCRIPTION = "Conquistar Coruscant, Sarapin, Ilum, Eredenn Prime e 18 planetas a escolha do jogador. Proteger Thule, Raxus e Queita.";
	public static final String CLONE_OBJECTIVE_DESCRIPTION = "Conquistar Geonosis, Tatooine, Mustafar, Nivek, Hypori e mais 17 planetas a escolha do jogador. Proteger Kamino.";
	public static final String DROIDE_OBJECTIVE_DESCRIPTION = "Conquistar Kamino e 21 planetas a escolha do jogador. Proteger Geonosis, Tatooine, Mustafar, Nivek e Hypori.";
	public static final String WOOKIEE_OBJECTIVE_DESCRIPTION = "Conquistar Trandosha e mais 21 planetas a escolha do jogador. Proteger Kashyyyk e Alaris Prime";
	public static final String TRANDOSHAN_OBJECTIVE_DESCRIPTION = "Conquistar Kashyyyk, Alaris Prime e mais 20 planetas a escolha do jogador. Proteger Trandosha";
	
	private PlayerRace characterObjective;//Referente ao tipo de personagem, de acordo com as constantes do tipo personagem em Player acima
	private String name;
	private String description;
	
	
	public ObjectiveCard(PlayerRace characterObjective){//Construtor com os objetivos fixos de cada personagem
		setCharacterObjective(characterObjective);
		switch(characterObjective){
		case PADAWAN: 
			setName("OBJETIVO PADAWAN");
			setDescription(PADAWAN_OBJECTIVE_DESCRIPTION);
			break;
		case SITH:
			setName("OBJETIVO SITH");
			setDescription(SITH_OBJECTIVE_DESCRIPTION);
			break;
		case CLONE:
			setName("OBJETIVO CLONE");
			setDescription(CLONE_OBJECTIVE_DESCRIPTION);
			break;
		case DROIDE:
			setName("OBJETIVO DROIDE");
			setDescription(DROIDE_OBJECTIVE_DESCRIPTION);
			break;
		case WOOKIEE:
			setName("OBJETIVO WOOKIEE");
			setDescription(WOOKIEE_OBJECTIVE_DESCRIPTION);
			break;
		case TRANDOSHAN:
			setName("OBJETIVO TRANDOSHAN");
			setDescription(TRANDOSHAN_OBJECTIVE_DESCRIPTION);
			break;
		default:
			setName("");
			setDescription("");
			break;
		}
		
	}
	
	public ObjectiveCard(PlayerRace characterObjective, String name, String description){//Construtor com Nome e Descricao customizada
		setCharacterObjective(characterObjective);
		setName(name);
		setDescription(description);
	}

	public PlayerRace getCharacterObjective() {
		return characterObjective;
	}

	public void setCharacterObjective(PlayerRace characterObjective) {
		this.characterObjective = characterObjective;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
