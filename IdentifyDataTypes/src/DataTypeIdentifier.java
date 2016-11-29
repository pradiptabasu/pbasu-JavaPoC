import java.util.Scanner;

public class DataTypeIdentifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		do
		{
			do
			{
				System.out.print("Enter your input: ");
				String input = s.next();
				try
				{
					int num1 = Integer.parseInt(input);
					System.out.println("Integer");
					break;
				}
				catch(Exception e)
				{
				}
				try
				{
					float num1 = Float.parseFloat(input);
					System.out.println("Float");
					break;
				}
				catch(Exception e)
				{
				}
				System.out.println("string");
			}while(true);
		}while(true);
	}
}
