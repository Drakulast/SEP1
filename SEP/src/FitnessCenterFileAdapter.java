import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FitnessCenterFileAdapter
{
  private MyFileIO myFileIO;
  private String membersFileName;
  private String instructorsFilename;
  private String classesFilename;
  private String scheduledClassesFilename;


  public FitnessCenterFileAdapter(String membersFileName, String instructorsFilename, String classesFilename, String scheduledClassesFilename)
  {
    myFileIO = new MyFileIO();
    this.membersFileName = membersFileName;
    this.instructorsFilename = instructorsFilename;
    this.classesFilename = classesFilename;
    this.scheduledClassesFilename = scheduledClassesFilename;
  }

  // MyFileIO to retrieve an ArrayList with members
  public ArrayList<Member> getAllMembers()
  {
    ArrayList<Member> members = new ArrayList<Member>();
    try
    {
      members = (ArrayList<Member>) myFileIO.readObjectFromFile(membersFileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading a file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return members;
  }

  // MyFileIO to retrieve a member
  public Member getMember(String phoneNumber)
  {
    ArrayList<Member> members = getAllMembers();
    Member member = null;

    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhoneNumber().equals(phoneNumber))
      {
        member = members.get(i);
        break;
      }
    }
    return member;
  }

  // MyFileIO to retrieve an ArrayList with instructors
  public ArrayList<Instructor> getAllInstructors()
  {
    ArrayList<Instructor> instructors = new ArrayList<Instructor>();

    try
    {
      instructors = (ArrayList<Instructor>) myFileIO
          .readObjectFromFile(instructorsFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return instructors;
  }

  // MyFileIO to retrieve an instructor
  public Instructor getInstructor(String phoneNumber)
  {
    ArrayList<Instructor> instructors = getAllInstructors();
    Instructor instructor = null;

    for (int i = 0; i < instructors.size(); i++)
    {
      if (instructors.get(i).getPhoneNumber().equals(phoneNumber))
      {
        instructor = instructors.get(i);
        break;
      }
    }
    return instructor;
  }

  // MyFileIO to retrieve an ArrayList with classes
  public ArrayList<Class> getAllClasses()
  {
    ArrayList<Class> classes = new ArrayList<Class>();

    try
    {
      classes = (ArrayList<Class>) myFileIO.readObjectFromFile(classesFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }
    return classes;
  }

  // MyFileIO to retrieve a classes
  public Class getClassByName(String name)
  {
    ArrayList<Class> classes = getAllClasses();
    Class classByName = null;

    for (int i = 0; i < classes.size(); i++)
    {
      if (classes.get(i).getName().equals(name))
      {
        classByName = classes.get(i);
      }
    }
    return classByName;
  }

  // MyFileIO to retrieve an ArrayList with scheduled classes
  public ArrayList<ScheduledClass> getAllScheduledClasses()
  {
    ArrayList<ScheduledClass> scheduledClasses = new ArrayList<ScheduledClass>();

    try
    {
      scheduledClasses = (ArrayList<ScheduledClass>) myFileIO
          .readObjectFromFile(scheduledClassesFilename);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
    }

    return scheduledClasses;
  }

  // MyFileIO to retrieve a scheduled class
  public ScheduledClass getScheduledClass(DateTime dateTime, String className)
  {
    ArrayList<ScheduledClass> scheduledClasses = getAllScheduledClasses();
    ScheduledClass scheduledClass = null;

    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getDateTime().equals(dateTime)
          && scheduledClasses.get(i).getClassItem().getName().equals(className))
      {
        scheduledClass = scheduledClasses.get(i);
        break;
      }
    }
    return scheduledClass;
  }

  // MyFileIO to retrieve an ArrayList with scheduled classes within interval of time

  public ArrayList<ScheduledClass> getScheduledClassesInTimeInterval(
      DateTime from, DateTime to)
  {
    ArrayList<ScheduledClass> scheduledClasses = getAllScheduledClasses();
    ArrayList<ScheduledClass> scheduledClassesFromTo = new ArrayList<ScheduledClass>();

    for (int i = 0; i < scheduledClasses.size(); i++)
    {
      if (scheduledClasses.get(i).getDateTime().getDay() >= from.getDay()
          && scheduledClasses.get(i).getDateTime().getDay() <= to.getDay())
      {
        scheduledClassesFromTo.add(scheduledClasses.get(i));
      }
    }
    return scheduledClassesFromTo;
  }

  public String displayScheduledClassesInTimeInterval(
      DateTime from, DateTime to)
  {
    ArrayList<ScheduledClass> scheduledClassesFromTo = getScheduledClassesInTimeInterval(from, to);


    String stringToReturn = "";
    for (int i = 0; i < scheduledClassesFromTo.size(); i++)
    {
      String tempStringToReturn = "";
      tempStringToReturn += "ScheduledClass: " + scheduledClassesFromTo.get(i).getClassItem() + " on " + scheduledClassesFromTo.get(i).getDateTime();
      if (scheduledClassesFromTo.get(i).getInstructor() != null)
      {
        tempStringToReturn += "\n\tInstructor: " + scheduledClassesFromTo.get(i).getInstructor();
      }
      else
      {
        tempStringToReturn += "\n\tNo instructor assignded yet.";
      }
      if (scheduledClassesFromTo.get(i).getMembers().size() == 0)
      {
        tempStringToReturn += "\n\tNo members attending the class yet.";
      }
      else
      {
        tempStringToReturn += "\n\tMembers: ";
        for (int j = 0; j < scheduledClassesFromTo.get(j).getMembers().size(); j++)
        {
          tempStringToReturn += "\n\t\t" + scheduledClassesFromTo.get(i).getMembers().get(j);
        }
      }
      stringToReturn += tempStringToReturn + "\n";
    }

    return stringToReturn;
  }

  //Get the current date
  public static String today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);

    return String.valueOf(currentDay) + "/" + String.valueOf(currentMonth) + "/"
        + String.valueOf(currentYear);
  }
}
