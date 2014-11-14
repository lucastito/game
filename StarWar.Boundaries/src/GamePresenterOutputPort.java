public interface GamePresenterOutputPort 
{
	void showReason(String reason);
	void show();
	void printDices(int[] attacker, int[] defender);
}
