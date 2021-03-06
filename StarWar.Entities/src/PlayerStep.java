public class PlayerStep
{	
	public static final int RECEIVE_ARMY_PHASE = 0;
	public static final int ATTACK_ENEMIES_PHASE = 1;
	public static final int REDEPLOY_ARMY_PHASE = 2;
	public static final int RECEIVE_CARD_PHASE = 3;
	public static final int END_OF_TURN = 4;
	
	public PlayerStep()
	{
		currentPhase = RECEIVE_ARMY_PHASE;
	}
	
	private int currentPhase;
	
	public void nextStep()
	{
		switch (currentPhase)
		{
			case RECEIVE_ARMY_PHASE:
				currentPhase = ATTACK_ENEMIES_PHASE;
			break;
			
			case ATTACK_ENEMIES_PHASE:
				currentPhase = REDEPLOY_ARMY_PHASE;
			break;
			
			case REDEPLOY_ARMY_PHASE:
				currentPhase = RECEIVE_CARD_PHASE;
			break;
			
			case RECEIVE_CARD_PHASE:
				currentPhase = END_OF_TURN;
			break;	
		}
	}
	
	public int getCurrentPhase()
	{
		return currentPhase;
	}
}
