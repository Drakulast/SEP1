import java.io.Serializable;
import java.util.ArrayList;

public class Instructor extends Person implements Serializable
{
  private ArrayList<String> classes;

  public Instructor(String firstName, String lastName, String address,
      String email, String phoneNumber, ArrayList<String> classes)
  {
    super(firstName, lastName, address, email, phoneNumber);
    this.classes = classes;
  }
public ArrayList<String> getClasses(){
    return classes;
}
  public void addClass(String className)
  {
    boolean exists = false;
    for (String classItem : classes)
    {
      if (classItem.equals(className))
        exists = true;
    }
    if (exists == false)
    {
      classes.add(className);
    }
  }

  public void removeClass(String className)
  {
    for (String classItem : classes)
    {
      if (classItem.equals(className))
      {
        classes.remove(className);
      }
    }
  }

  public boolean hasClass(String className)
  {
    for (String classItem: classes)
    {
      if (classItem.equals(className))
      {
        return true;
      }
    }
    return false;
  }

  public int getNumberOfClasses()
  {
    return classes.size();
  }

  public String toString()
  {
    String stringToReturn = "";
    stringToReturn += super.toString() + ", can teach: ";
    for (int i = 0; i < classes.size(); i++)
    {
      if (i == classes.size() - 1)
      {
        stringToReturn += classes.get(i) + ".";
      }
      else
      {
        stringToReturn += classes.get(i) + ", ";
      }
    }
    return stringToReturn;
  }

  public Instructor copy()
  {
    return new Instructor(super.getFirstName(), super.getLastName(),
        super.getAddress(), super.getEmail(), super.getPhoneNumber(), classes);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Instructor))
    {
      return false;
    }
    Instructor other = (Instructor) obj;
    return super.equals(other) && classes.equals(other.classes);
  }

}
