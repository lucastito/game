import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerStepTests 
{
	@Test
	public void FirstStep_MustBe_RECEIVE_ARMY_PHASE() 
	{
		PlayerStep playerStep = new PlayerStep();
		assertEquals(PlayerStep.RECEIVE_ARMY_PHASE, playerStep.getCurrentPhase());
	}
	
	@Test
	public void SecondStep_MustBe_ATTACK_ENEMIES_PHASE() 
	{
		PlayerStep playerStep = new PlayerStep();
		playerStep.nextStep();
		assertEquals(PlayerStep.ATTACK_ENEMIES_PHASE, playerStep.getCurrentPhase());
	}
	
	@Test
	public void ThirdStep_MustBe_REDEPLOY_ARMY_PHASE() 
	{
		PlayerStep playerStep = new PlayerStep();
		playerStep.nextStep();
		playerStep.nextStep();
		assertEquals(PlayerStep.REDEPLOY_ARMY_PHASE, playerStep.getCurrentPhase());
	}
	
	@Test
	public void FourthStep_MustBe_RECEIVE_CARD_PHASE() 
	{
		PlayerStep playerStep = new PlayerStep();
		playerStep.nextStep();
		playerStep.nextStep();
		playerStep.nextStep();
		assertEquals(PlayerStep.RECEIVE_CARD_PHASE, playerStep.getCurrentPhase());
	}
	
	@Test
	public void FifthStep_MustBe_END_OF_TURN() 
	{
		PlayerStep playerStep = new PlayerStep();
		playerStep.nextStep();
		playerStep.nextStep();
		playerStep.nextStep();
		playerStep.nextStep();
		assertEquals(PlayerStep.END_OF_TURN, playerStep.getCurrentPhase());
	}
}
