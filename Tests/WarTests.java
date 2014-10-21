import static org.junit.Assert.*;

import org.junit.Test;


public class WarTests {

	@Test
	public void RollDice_SendingFiveAsAmountOfDice_MustReturnAnArrayOfLengthFive() 
	{
		int[] result = War.rollDice(5);
		assertEquals(5, result.length);
	}
	
	@Test
	public void RollDice_MustBeGreaterOrEqualsThanOne() 
	{
		int[] result = War.rollDice(1);
		assertTrue(result[0] >= 1);
	}
	
	@Test
	public void RollDice_MustBeLesserOrEqualsThanSix() 
	{
		int[] result = War.rollDice(1);
		assertTrue(result[0] <= 6);
	}
}
