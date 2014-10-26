import java.util.ArrayList;
import java.util.Collections;

public class RandomNumberGenerator 
{
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    private static int k=-1;
    private static boolean isFirstTimeCall = true;
    
    public static Integer generateRandomNumber()
    {
    	if (isFirstTimeCall)
    	{
    		for (int i=10000;i<99999;i++){
                arr.add(i);
            }
            Collections.shuffle(arr);
            isFirstTimeCall = false;
    	}
    	
        k++;
        if(k >= arr.size())
        {
            return -1;
        }
        else 
        	return (Integer) arr.get(k);
    }
}