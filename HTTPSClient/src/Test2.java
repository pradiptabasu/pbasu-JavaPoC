
public class Test2 {

	public static String getShiftedString(String s, int leftShifts, int rightShifts)
	{
		String result="";
		int finalLeftShifts;
		int finalRightShifts;
		
		if(leftShifts > s.length())
		{
			leftShifts = (leftShifts % s.length());
		}
		if(rightShifts > s.length())
		{
			rightShifts = (rightShifts % s.length());
		}
		
		if( (leftShifts - rightShifts) == 0)
		{
			result = s;
		}
		else if((leftShifts - rightShifts) > 0)
		{
			finalLeftShifts = leftShifts - rightShifts;
			result = s.substring(finalLeftShifts) + s.substring(0, finalLeftShifts); 
		}
		else if((rightShifts - leftShifts) > 0)
		{
			finalRightShifts = rightShifts - leftShifts;
			result = s.substring(s.length() - finalRightShifts) + s.substring(0, s.length() - finalRightShifts); 
		}
		return result;		
	}
	
	public static void controlSwapOnT(String s)
	{
		if(s.contains("t"))
		{
			String[] parts = s.split(" ");
			
			for(String temp : parts)
			{
				if (temp.contains("t"))
				{
					System.out.println(swapOnT(temp));
				}
			}
		}
		else
		{
			System.out.println("None");
		}

	}
	
	public static String swapOnT(String s)
	{
		String result = "";
		
		if (s.contains("t"))
		{
			if (s.length() %2 != 0)
			{
				result = s.substring((s.length() / 2) +1) + s.charAt((s.length()/2)) + s.substring(0, (s.length()/2)); 
			}
			else
			{
				result = s.substring((s.length()/2)) + s.substring(0, (s.length()/2)); 
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getShiftedString("abcd",1,2));
		System.out.println(getShiftedString("a",0,1));
		System.out.println(getShiftedString("abcdef",0,0));
		System.out.println(getShiftedString("abcdef",8,0));
		System.out.println(8%6);
		
		System.out.println(swapOnT("first"));
		System.out.println(swapOnT("time"));
		System.out.println(swapOnT("t"));
		
		controlSwapOnT("How are you?");
		System.out.println("\n\n");
		controlSwapOnT("letter t interests me");
		System.out.println("\n\n");
		controlSwapOnT("opentext internship program");
		System.out.println("\n\n");
		controlSwapOnT("get it right first time");
	}

}

