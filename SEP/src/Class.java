public class Class
{
  private String name;
  private int maxCapacity;

  public Class(String name, int maxCapacity)
  {
    this.name = name;
    this.maxCapacity = maxCapacity;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setMaxCapacity(int maxCapacity)
  {
    this.maxCapacity = maxCapacity;
  }

  public String toString()
  {
    return "Class{" + "name='" + name + '\'' + ", maxCapacity=" + maxCapacity
        + '}';
  }

  public boolean equals(Object  obj)
  {
    if (!(obj instanceof Class))
    {
      return false;
    }
    Class other = (Class) obj;
    return name.equals(other.name) && maxCapacity == other.maxCapacity;
  }
}
