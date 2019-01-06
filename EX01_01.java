import java.util.Scanner;
import java.util.Random;

public class EX01_01
{
	public static void main(String [] args)
	{
		Scanner userInput = new Scanner(System.in);
		Random rand = new Random();
		int input;
		do{
		System.out.println("Please enter a number between 10 and 100.");
			//PT -- why not nextInt? -1
		String answer = userInput.nextLine();

		userInput.close();
		
		input = Integer.parseInt(answer);
		} while (input < 10 || input > 100);

		for (int i = 0; i < input; i++)
		{
			int randnum = rand.nextInt(2001);
			System.out.print("Number: " + randnum + ", Type: ");
			if (randnum % 2 == 0)
		{
			// number is even
			System.out.println("even");
		}
		else
			System.out.println("odd");
		}
	}
}

