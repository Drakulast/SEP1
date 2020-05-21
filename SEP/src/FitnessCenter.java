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
    //Removing the Class object from the classes array
    classes.remove(classItem);

    //Removing the ScheduledClass object from the scheduledClasses array
    int indexToRemove = -1;
    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getClassItem().equals(classItem))
        indexToRemove = i;
    }
    scheduledClasses.remove(indexToRemove);

  }

  public void removeClass(String className)
  {
    //Removing the Class object from the classes array
    int indexToRemove = -1;
    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getName().equals(className))
        indexToRemove = i;
    }
    classes.remove(indexToRemove);

    //Removing the scheduledClass object from the scheduledClasses array
    indexToRemove = -1;
    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getClassItem().getName().equals(className))
      {
        indexToRemove = i;
      }
    }
    scheduledClasses.remove(indexToRemove);
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
    //Removing the Instructor object from the instructors array
    int indexToRemove = -1;
    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.get(i).getPhoneNumber().equals(phoneNumber))
      {
        indexToRemove = i;
      }
    }
    instructors.remove(indexToRemove);

    //Setting the Instructor to null in all the scheduled classes he teaches
    System.out.println(scheduledClasses.size());
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      if (scheduledClass.getInstructor().getPhoneNumber().equals(phoneNumber))
      {
        scheduledClass.setInstructor(null);
        break;
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
    if (getMember(member.getPhoneNumber()) == null)
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
    boolean classAlreadyExists = false;
    for (ScheduledClass scheduledClassItem : scheduledClasses)
    {
      if (scheduledClassItem.equals(scheduledClass))
      {
        classAlreadyExists = true;
      }
    }
    if (!classAlreadyExists)
    {
      scheduledClasses.add(scheduledClass);
    }
  }

  public void removeScheduledClass(ScheduledClass scheduledClass)
  {
    scheduledClasses.remove(scheduledClass);
  }

  public ScheduledClass getScheduledClass(DateTime dateTime, String className)
  {
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      if (scheduledClass.getDateTime().equals(dateTime) && scheduledClass
          .getClassItem().getName().equals(className))
      {
        return scheduledClass;
      }
    }
    return null;
  }

  public ArrayList<Instructor> getInstructors()
  {
    return instructors;
  }

  public ArrayList<Class> getClasses()
  {
    return classes;
  }

  public ArrayList<Member> getMembers()
  {
    return members;
  }

  public ArrayList<ScheduledClass> getScheduledClasses()
  {
    return scheduledClasses;
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
