import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test1 {

	public static int goodSegment(List<Integer> badNumbers, int l, int r) {
		int maxRangeCount = 0;

		Collections.sort(badNumbers);

		boolean flag = false;

		int start = l;
		
		for (int i = 0; i < badNumbers.size(); i++) {
			
			int tempBadNumber = badNumbers.get(i);

			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("low -------->>>>>>>   " + l);
			System.out.println("high -------->>>>>>>   " + r);
			System.out.println("tempBadNumber -------->>>>>>>   " + tempBadNumber);
			System.out.println("start -------->>>>>>>   " + start);
			//System.out.println(" -------->>>>>>>   " + );
			
			
			if (tempBadNumber >= l && tempBadNumber <= r) {
				System.out.println("IN NORMAL RANGE");
				System.out.println("IN NORMAL RANGE ----- current maxRangeCount ----->>>>> " + maxRangeCount);
				System.out.println("IN NORMAL RANGE ----- current range ----->>>>> " + (tempBadNumber - 1 - start + 1));
				if (maxRangeCount < tempBadNumber - 1 - start + 1) {
					maxRangeCount = tempBadNumber - 1 - start + 1;
					System.out.println("IN NORMAL RANGE ----- CHANGE IN maxRangeCount");
				}
				start = tempBadNumber + 1;
			} 
			else if(tempBadNumber < l)
			{
				System.out.println("IN LESS THAN RANGE");
			}
			else if(tempBadNumber > r)
			{
				System.out.println("IN GREATER THAN RANGE");
				System.out.println("IN GREATER THAN RANGE ----- current maxRangeCount ----->>>>> " + maxRangeCount);
				System.out.println("IN GREATER THAN RANGE ----- current range ----->>>>> " + (r - start + 1));
				if (maxRangeCount < r - start + 1) {
					maxRangeCount = r - start + 1;
					System.out.println("IN GREATER THAN RANGE ----- CHANGE IN maxRangeCount");
				}
				flag = true;
				break;
			}
			else {
				System.out.println("UNHANDLES RANGE");
			}
			
			System.out.println("------------------------------------------------------------------------------------");
		}
		
		if(flag == false)
		{
			if (maxRangeCount < r - start + 1) {
				maxRangeCount = r - start + 1;
				System.out.println("IN false FLAG RANGE ----- CHANGE IN maxRangeCount");
			}
		}

		return maxRangeCount;
	}
	


	public static String replaceTCount(String input, int count) {
		if(input.contains("t"))
		{
			input = input.replaceFirst("t", Integer.toString(++count));
			return replaceTCount(input,count);
		}
		else
		{
			return input;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] badNumberArray = { 8, 6, 20, 12 };
//		int lower = 1;
//		int max = 10;

		// int[] badNumberArray = { 37,7,22,15,49,60 };
		// int lower = 3;
		// int max = 48;
		
//		int[] badNumberArray = { 20, 21, 1, 4, 10, 17, 18, 22 };
//		int lower = 4;
//		int max = 20;
		
		int[] badNumberArray = { 20, 21, 1, 4, 10, 17, 18, 22 };
		int lower = 4;
		int max = 29;

		List<Integer> badNumbers = new ArrayList<>(badNumberArray.length);

		for (int i : badNumberArray) {
			badNumbers.add(Integer.valueOf(i));
		}

		System.out.println(goodSegment(badNumbers, lower, max));

		Scanner a = new Scanner(System.in);
		System.out.println("Enter a string input");
		String input = a.nextLine();
		System.out.println("You entered string " + input);
	    
		String[] parts = input.split(" ");
		
		for(String s : parts)
		{
			String myString = replaceTCount(s,0);
			//String myString = s.replaceFirst("t", Integer.toString(1));
			System.out.print(myString + " ");
		}
	}
}
