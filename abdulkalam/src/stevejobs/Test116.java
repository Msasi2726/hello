package stevejobs;

import java.util.HashMap;
import java.util.Map;

public class Test116
{
	public static void main(String[] args)
	{
		//Create a hash map
		HashMap<Integer,String> hm=
				       new HashMap<Integer,String>();
		//Insert data as pairs into hash map
		hm.put(101,"kalam");
		hm.put(102,"kohli");
		//change value using key
		hm.replace(102,"virat kohli");
		//change key using key
		hm.put(103,hm.remove(102));
		//Get data from hash map
		for(Map.Entry e:hm.entrySet())
		{
			System.out.print(e.getKey());
			System.out.println(" "+e.getValue());
		}
	}
}




