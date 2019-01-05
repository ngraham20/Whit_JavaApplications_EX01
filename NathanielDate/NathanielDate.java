package NathanielDate;
import java.util.Date;

import java.util.regex.*;

public class NathanielDate
{
    private int day;
    private int month;
    private int year;
    private static NathanielDate currentDate;
    private static Date date;

    private enum Months
    {
        January,
        February,
        March,
        April,
        May,
        June,
        July,
        August,
        September,
        November,
        December
    }

    private Months months;
    private int[] maxDays = {31, 28, 31, 30,31,30,31,31,30,31,30,31};

    NathanielDate(int day, int month, int year)
    {
        if (checkValidDate(maxDays, day, month, year))
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        this.date = new Date();
    }

    

    private boolean checkValidDate(int[] maxDays, int day, int month, int year)
    {
        if (month > maxDays.length - 1 || month <= 0)
            return false;
        if (day <= 0)
            return false;
        if(day > maxDays[month-1])
        {
            if (month == 1 && day == 28 && year % 4 == 0)
            {
                return true;
            }
            return false;
        }    
        return true;
    }

    public static NathanielDate getTodaysDate()
    {
        String dateString = date.toString();
        int day = -1;
        String month = "";
        int monthInt = -1;
        int year = -1;

        // reg for day
        Pattern pattern = Pattern.compile(" ([0-9][0-9]) ");
        Matcher matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           day = Integer.valueOf(matcher.group(1));
        }

        // reg for month
        pattern = Pattern.compile(" ([A-Z][a-z]+) ");
        matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           month = matcher.group(1);
        }
        // reg for year
        pattern = Pattern.compile(" ([0-9]{4}) ");
        matcher = pattern.matcher(dateString);
        if (matcher.find())
        {
           year = Integer.valueOf(matcher.group(1));
        }

        switch (month)
        {
            case "Jan": monthInt = 0;
            case "Feb": monthInt = 1;
            case "Mar": monthInt = 2;
            case "Apr": monthInt = 3;
            case "May": monthInt = 4;
            case "Jun": monthInt = 5;
            case "Jul": monthInt = 6;
            case "Aug": monthInt = 7;
            case "Sep": monthInt = 8;
            case "Oct": monthInt = 9;
            case "Nov": monthInt = 10;
            case "Dec": monthInt = 11;
        }

        return new NathanielDate(day, monthInt, year);
    }

    public static int timeBetween(NathanielDate a, NathanielDate b)
    {
        return 0;
    }

    public static NathanielDate getCurrentDate()
    {
        return currentDate;
    }
    
    public int getDay()
    {
        return this.day;
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getYear()
    {
        return this.year;
    }

    public void setDate(int day, int month, int year)
    {
        if (checkValidDate(maxDays, day, month, year));
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
}