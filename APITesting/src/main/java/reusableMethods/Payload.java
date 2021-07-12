package reusableMethods;

import java.util.HashMap;

public class Payload {

	public  static Object postBody()
	{
		HashMap<String,String> hs=new HashMap<String,String>();
		
		hs.put("username", "testerAssessment");
		hs.put("score", "20");
		return hs;
	}
	
	
	public  static Object putMessageBody()
	{
		HashMap<String,String> hs=new HashMap<String,String>();
		
		hs.put("username", "testerAssessment");
		hs.put("score", "200");
		return hs;
	}
}
