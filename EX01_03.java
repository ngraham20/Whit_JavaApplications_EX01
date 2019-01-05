import java.util.Scanner;

public class EX01_03
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        int result = 0;
        int digitPos = 0;
        boolean isNegative = false;

        System.out.println("Please enter a number. Negative is optional.");

        String inputString = userInput.nextLine();
        userInput.close();
        // loop through all chars in string
        for (int i = 0; i < inputString.length(); ++i)
        {
            char character = inputString.charAt(i);
            // convert the char number to its integer value (for numbers, subtract 57)
            if (character >= 48 && character <= 57)
            {
                // the character is a number
                int num = character - 48;
                System.out.println("Number: " + Integer.toString(num));
                // add digitPos times the number to the result
                result = result * 10 + num;
            }
            else if (character == 45)
            {
                // the character is a negative sign
                // tag the number as negative, to be multiplied at the end
                System.out.println("The number entered is negative.");
                isNegative = true;
            }
            else
            {
                // the number is disjointed. Break and try again.
                System.out.println("ERROR: Please only use numbers or the " +
                "'-' symbol for negative");
                break;
            }
        }
        if (isNegative)
            result *= -1;
        System.out.println(Integer.toString(result));
    }
}