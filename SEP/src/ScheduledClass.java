import java.io.Serializable;
import java.util.ArrayList;

public class ScheduledClass implements Serializable
{
  private ArrayList<Member> members;
  private Instructor instructor;
  private Class classItem;
  private DateTime dateTime;
  private int duration;

  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime, ArrayList<Member> members, int duration)
  {
    this.members = members;
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
    this.duration = duration;
  }

  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime, int duration)
  {
    this.members = new ArrayList<Member>();
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
    this.duration = duration;
  }

  public ArrayList<Member> getMembers()
  {
    return members;
  }

  public void setMembers(ArrayList<Member> members)
  {
    this.members = members;
  }

  public Instructor getInstructor()
  {
    return instructor;
  }

  public void setInstructor(Instructor instructor)
  {
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
  }

  public Class getClassItem()
  {
    return classItem;
  }

  public void setClassItem(Class classItem)
  {
    this.classItem = classItem;
  }

  public DateTime getDateTime()
  {
    return dateTime;
  }

  public void setDateTime(DateTime dateTime)
  {
    this.dateTime = dateTime;
  }

  public void addMember(Member member)
  {
    if (member.hasPremiumMembership())
    {
      members.add(member);
    }
  }

  public void setDuration(int duration)
  {
    this.duration = duration;
  }

  public int getDuration()
  {
    return duration;
  }

  public void removeMember(Member member)
  {
    members.remove(member);
  }

  public String toString()
  {
    String stringToReturn = "";
    stringToReturn += "ScheduledClass: " + classItem + " on " + dateTime;
    if (instructor != null)
    {
      stringToReturn += "\n\tInstructor: " + instructor;
    }
    else
    {
      stringToReturn += "\n\tNo instructor assigned yet.";
    }
    if (members.size() == 0)
    {
      stringToReturn += "\n\tNo members attending the class yet.";
    }
    else
    {
      stringToReturn += "\n\tMembers: ";
      for (int i = 0; i < members.size(); i++)
      {
        stringToReturn += "\n\t\t" + members.get(i);
      }
    }
    return stringToReturn;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ScheduledClass))
    {
      return false;
    }
    ScheduledClass other = (ScheduledClass) obj;
    return classItem.equals(other.classItem) && instructor
        .equals(other.instructor) && dateTime.equals(other.dateTime) && members
        .equals(other.members) && duration == other.duration;
  }
}
