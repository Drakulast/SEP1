public class DateTime
{
  private int day;
  private int month;
  private int year;
  private int hour;
  private int minute;

  //nice date

  public DateTime(int day, int month, int year, int hour, int minute)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    this.hour = hour;
    this.minute = minute;
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
    return day == other.day && month == other.getMonth()
        && year == other.getYear() && hour == other.hour
        && minute == other.minute;
  }
}
