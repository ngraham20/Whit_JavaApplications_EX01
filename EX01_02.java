import java.util.Scanner;

public class EX01_02
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		System.out.println("Give a radius for a circle please");
		//PT -- again, why not nextInt or (better) nextDouble? -1
		String radius = userInput.nextLine();
		userInput.close();
		final double pi = 3.14;

		System.out.println("The Area is " + Double.toString( pi*Integer.parseInt(radius)*Integer.parseInt(radius)));

	}
}
