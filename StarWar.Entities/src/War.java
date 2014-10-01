public class War {

	private static War instance;
	
	private Board board; 

	private War() {

	}

	public static War getInstance() {
		if (instance == null)
			instance = new War();
		return instance;
	}
	
	public Board getBoard(){
		return this.board;
	}

}
