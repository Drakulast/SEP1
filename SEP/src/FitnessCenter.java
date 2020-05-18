import java.util.ArrayList;

public class FitnessCenter
{
  private ArrayList<Instructor> instructors;
  private ArrayList<Class> classes;
  private ArrayList<Member> members;
  private ArrayList<ScheduledClass> scheduledClasses;

  public FitnessCenter()
  {
    instructors = new ArrayList<Instructor>();
    classes = new ArrayList<Class>();
    members = new ArrayList<Member>();
    scheduledClasses = new ArrayList<ScheduledClass>();
  }

  public void addClass(Class classItem)
  {
    classes.add(classItem);
  }

  public void removeClass(Class classItem)
  {
    classes.remove(classItem);
  }

  public void removeClass(String className)
  {
    for (Class classItem : classes)
    {
      if (classItem.getName().equals(className))
      {
        classes.remove(classItem);
      }
    }
  }

  public Class getClassItem(String className)
  {
    for (Class classItem : classes)
    {
      if (classItem.getName().equals(className))
      {
        return classItem;
      }
    }
    return null;
  }

  public void addInstructor(Instructor instructor)
  {
    instructors.add(instructor);
  }

  public void removeInstructor(String phoneNumber)
  {
    for (Instructor instructor : instructors)
    {
      if (instructor.getPhoneNumber().equals(phoneNumber))
      {
        instructors.remove(instructor);
      }
    }
  }

  public Instructor getInstructor(String phoneNumber)
  {
    for (Instructor instructor : instructors)
    {
      if (instructor.getPhoneNumber().equals(phoneNumber))
      {
        return instructor;
      }
    }
    return null;
  }

  public void addMember(Member member)
  {
    members.add(member);
  }

  public void removeMember(String phoneNumber)
  {
    for (Member member : members)
    {
      if (member.getPhoneNumber().equals(phoneNumber))
      {
        members.remove(member);
      }
    }
  }

  public Member getMember(String phoneNumber)
  {
    for (Member member : members)
    {
      if (member.getPhoneNumber().equals(phoneNumber))
      {
        return member;
      }
    }
    return null;
  }

  public void addScheduledClass(ScheduledClass scheduledClass)
  {
    scheduledClasses.add(scheduledClass);
  }

  public void removeScheduledClass(ScheduledClass scheduledClass)
  {
    scheduledClasses.remove(scheduledClass);
  }

  public ScheduledClass getScheduledClass(DateTime dateTime, String name)
  {
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      if (scheduledClass.getDateTime().equals(dateTime) && scheduledClass
          .getClassItem().getName().equals(name))
      {
        return scheduledClass;
      }
    }
    return null;
  }

  public String toString()
  {
    return "FitnessCenter{" + "instructors=" + instructors + ", classes="
        + classes + ", members=" + members + ", scheduledClasses="
        + scheduledClasses + '}';
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof ScheduledClass))
    {
      return false;
    }
    FitnessCenter other = (FitnessCenter) obj;
    return members.equals(other.members) && instructors
        .equals(other.instructors) && classes.equals(other.classes)
        && scheduledClasses.equals(other.scheduledClasses);
  }
}
