package NathanielDate;
import java.util.Date;

import java.util.regex.*;

public class NathanielDate
{
    private int day;
    private int month;
    private int year;
    private static Date date;

    private int[] maxDays = {31, 28, 31, 30,31,30,31,31,30,31,30,31};

    NathanielDate(int day, int month, int year)
    {
        if (checkValidDate(maxDays, day, month, year))
        {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        date = new Date();
    }

    

    private boolean checkValidDate(int[] maxDays, int day, int month, int year)
    {
        if (month > maxDays.length - 1 || month <= 0)
            return false;
        if (day <= 0)
            return false;
        if(day > maxDays[month-1])
        {
            if (month == 2 && day == 28 && year % 4 == 0)
            {
                return true;
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 return false;
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

        return new NathanielDate(day, monthInt + 1, year);
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

    //makes date n days in future based on current date. Will not take negative numbers
    //date from whatever current date object holds.
    public NathanielDate moveDateOut(int n)
    {
        int curDay = this.day;
        int curMonth = this.month;
        int curYear = this.year;

        for (int i = 0; i < n; i++)
        {
            curDay++;
            if (curDay > maxDays[month-1])
            {
                if (curYear % 4 == 0 && curMonth == 2 && curDay == 29)
                {
                    continue;
                }
                curDay = 1;
                curMonth++;
            }
            if (curMonth > 12)
            {
                curDay = 1;
                curMonth = 1;
                curYear++;
            }
        }

        return new NathanielDate(curDay, curMonth, curYear);
    }

    //day totals based on 0 so that numbers aren't too large but can go back pretty far, and dates before then shouldn't really be manipulated that much anyway
    public int getTotalDays()
    {
        //convert years to days since year 0
        int days = year * 365;

        // add leap days
        days += year / 4;
        
        //convert months to days
        for(int i = 0; i < month - 1; i++)
        {
            days += maxDays[i];
        }
        
        //add day to how many days we have total
        days += day;
        
        return days;
    }

    public static int daysBetweenDates(NathanielDate dateOne, NathanielDate dateTwo)
    {
        int dayTotalOne = dateOne.getTotalDays();
        int dayTotalTwo = dateTwo.getTotalDays();
        
        int diffDays;
        if(dayTotalOne > dayTotalTwo)
        {
            diffDays = dayTotalOne - dayTotalTwo;
        }
        else
        {
            diffDays = dayTotalTwo - dayTotalOne;
        }
        return diffDays;
    }
}