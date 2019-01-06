import java.util.Scanner;

public class EX01_04
{
    static public void main(String[] args)
    {
        // init variables
        Scanner userIn = new Scanner(System.in);

        // prompt
        System.out.println("Please enter your weight (lbs)");
        // user input weight
        double weight = userIn.nextDouble();
        

        // prompt
        System.out.println("Please enter your height (in)");
        // user input height
        double height = userIn.nextDouble();

        userIn.close();
        
        // convert
        double BMI = convert(weight, height);
        // display
        System.out.println("Your BMI = " + Double.toString(BMI));


    }

    static public double convert(double weight, double height)
    {
        //PT -- name these numbers:
        //  final double POUND_TO_KG = 0.453592;
        //  double kg = weight * POUND_TO_KG;
        double kg = weight * 0.453592;
        double m = height * 0.0254;

        return kg/(m*m);
    }

}
