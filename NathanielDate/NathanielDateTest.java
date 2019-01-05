package NathanielDate;

public class NathanielDateTest
{
    public static void main(String[] args)
    {
        NathanielDate dateSimple = new NathanielDate(1, 1, 1);
        NathanielDate dateSimple2 = new NathanielDate(23, 2, 2);
        NathanielDate date1 = new NathanielDate(23, 1, 1865);
        NathanielDate date2 = new NathanielDate(4, 7, 1776);

        assert date1.getDay() == 23;
        assert date1.getMonth() == 1;
        assert date1.getYear() == 1865;

        assert dateSimple.getTotalDays() == 366;
        assert dateSimple2.getTotalDays() == 784;
        assert NathanielDate.daysBetweenDates(dateSimple, dateSimple2) == 418;

    }
}