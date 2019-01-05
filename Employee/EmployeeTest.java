package Employee;

public class EmployeeTest
{
    public static void main(String[] args)
        {
            Employee bossman = new Employee(234, "bossman", "01/21/1980", "Boss");
            Employee workerman = new Employee(123, "John", "04/03/2018", "Employee");

            bossman.setBoss(bossman);
            workerman.setBoss(bossman);

            System.out.println("Commensing three tests. . .");
            assert bossman.getBoss() == bossman : "getBoss() TEST SUCCEEDED";
            assert workerman.getHireDate() == "04/03/2018" : "getHireDate() TEST SUCCEEDED";
            assert workerman.getBoss().getName() == "bossman" : "getBoss().getBoss() TEST SUCCEEDED";
        }
}