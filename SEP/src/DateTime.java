public class DateTime
{
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minute;

  public DateTime(int day, int month, int year, int hour, int minute)
  {
    boolean isLeapYear = false;
    if (year % 4 == 0)
    {
      if (year % 100 == 0)
      {
        if (year % 400 == 0)
          isLeapYear = true;
        else
          isLeapYear = false;
      }
      else
        isLeapYear = true;
    }
    else
    {
      isLeapYear = false;
    }
    if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60)
    {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
          || month == 10 || month == 12)
      {
        if (day > 0 && day < 32)
        {
          this.day = day;
          this.hour = hour;
          this.minute = minute;
          this.month = month;
          this.year = year;

        }
        else
        {
          System.out.println(
              "The date and time has not been created. Enter correct values");
        }
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11)
      {
        if (day > 0 && day < 31)
        {
          this.day = day;
          this.hour = hour;
          this.minute = minute;
          this.month = month;
          this.year = year;
        }
        else
        {
          System.out.println(
              "The date and time has not been created. Enter correct values");
        }
      }
      else if (month == 2)
      {
        if (isLeapYear)
        {
          if (day > 0 && day < 29)
          {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.month = month;
            this.year = year;
          }
          else
          {
            System.out.println(
                "The date and time has not been created. Enter correct values");
          }
        }
        else
        {
          if (day > 0 && day < 29)
          {
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.month = month;
            this.year = year;
          }
          else
          {
            System.out.println(
                "The date and time has not been created. Enter correct values");
          }

        }
      }
      else
      {
        System.out.println(
            "The date and time has not been created. Enter correct values");
      }
    }
    else {
      System.out.println(
          "The date and time has not been created. Enter correct values");
    }
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public String toString()
  {
    return "DateTime{" + "day=" + day + ", month=" + month + ", year=" + year
        + ", hour=" + hour + ", minute=" + minute + '}';
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof DateTime))
    {
      return false;
    }
    DateTime other = (DateTime) obj;
    return day == other.day && month == other.getMonth() && year == other
        .getYear() && hour == other.hour && minute == other.minute;
  }
}
