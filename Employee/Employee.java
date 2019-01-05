package Employee;

public class Employee
{
    private int ID;
    private String name;
    private String hireDate;
    private String position;
    private Employee boss;

    public Employee()
    {
        init(0, "John", "01/01/2018", "Default");
    }

    public Employee(int ID, String name, String date, String position)
    {
        init(ID, name, date, position);
    }

    public void init(int ID, String name, String date, String position)
    {
        this.ID = ID;
        this.name = name;
        this.hireDate = date;
        this.position = position;
    }

    public int getID()
    {
        return this.ID;
    }
    public String getName()
    {
        return this.name;
    }
    public String getHireDate()
    {
        return this.hireDate;
    }
    public String getPoisition()
    {
        return this.position;
    }
    public Employee getBoss()
    {
        return this.boss;
    }
    public void setBoss(Employee boss)
    {
        this.boss = boss;
    }
}