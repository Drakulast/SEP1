import java.util.ArrayList;

public class ScheduledClass
{
  private ArrayList<Member> members;
  private Instructor instructor;
  private Class classItem;
  private DateTime dateTime;

  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime, ArrayList<Member> members)
  {
    this.members = members;
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
  }

  public ScheduledClass(Class classItem, Instructor instructor, DateTime dateTime)
  {
    this.members = new ArrayList<Member>();
    this.classItem = classItem;
    this.dateTime = dateTime;
    if (instructor.hasClass(classItem.getName()))
    {
      this.instructor = instructor;
    }
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
    this.instructor = instructor;
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

  public void removeMember(Member member)
  {
    members.remove(member);
  }

  public String toString()
  {
    return "ScheduledClass{" + "members=" + members + ", instructor="
        + instructor + ", classItem=" + classItem + ", dateTime=" + dateTime
        + '}';
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
        .equals(other.members);
  }
}
