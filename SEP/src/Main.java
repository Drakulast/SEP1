import javax.xml.stream.events.DTD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;

public class Main
{
  public static void main(String[] args)
  {
    FitnessCenter viaFit = new FitnessCenter();

    ArrayList<String> classesList1 = new ArrayList<String>();
    classesList1.add("Spinning");
    classesList1.add("Do");
    classesList1.add("Fucking");
    classesList1.add("Work");
    ArrayList<String> classesList2 = new ArrayList<String>();
    classesList2.add("Yoga");
    classesList2.add("Do");
    classesList2.add("Fucking");
    classesList2.add("Work");
    Instructor instructor1 = new Instructor("Bob", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "45856829", classesList1);
    Instructor instructor2 = new Instructor("Ionut", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "353356745", classesList1);
    Instructor instructor3 = new Instructor("Claudiu", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "122585674", classesList2);

    viaFit.addInstructor(instructor1);

    Class class1 = new Class("Spinning", 15);
    Class class2 = new Class("Yoga", 20);
    Class class3 = new Class("Zumba", 10);
    Class class4 = new Class("Stretching", 25);
    viaFit.addClass(class1);
    viaFit.addClass(class2);

    Member member1 = new Member("John", "Doe", "Horsens", "johndoe@gmail.com",
        "45852123");
    Member member2 = new Member("Jane", "Doe", "Horsens", "janedoe@gmail.com",
        "45123456");
    Member member3 = new Member("Cezary", "Doe", "Horsens", "cezary@gmail.com",
        "81458963");
    Member member4 = new Member("Maria", "Doe", "Horsens", "maria@gmail.com",
        "75312345");
    Member member5 = new Member("Claudiu", "Doe", "Horsens",
        "claudiu@gmail.com", "12458796");

    member1.upgradeMembership();
    member3.upgradeMembership();
    viaFit.addMember(member1);
    viaFit.addMember(member2);
    viaFit.addMember(member3);
    viaFit.addMember(member4);
    viaFit.addMember(member5);

    DateTime dateTime1 = new DateTime(19, 5, 2020, 18, 0);
    DateTime dateTime2 = new DateTime(19, 5, 2020, 19, 0);
    DateTime dateTime3 = new DateTime(22, 6, 2020, 12, 0);
    DateTime dateTime4 = new DateTime(25, 6, 2020, 15, 15);

    ScheduledClass scheduledClass1 = new ScheduledClass(class1, instructor1,
        dateTime1, 60);
    ScheduledClass scheduledClass2 = new ScheduledClass(class2, instructor2,
        dateTime2, 45);
    ScheduledClass scheduledClass3 = new ScheduledClass(class3, instructor3,
        dateTime3, 50);
    ScheduledClass scheduledClass4 = new ScheduledClass(class4, instructor1,
        dateTime4, 40);
    viaFit.addScheduledClass(scheduledClass1);
    viaFit.addScheduledClass(scheduledClass2);

    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning")
        .addMember(member1);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning")
        .addMember(member2);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning")
        .addMember(member3);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning")
        .addMember(member4);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning")
        .addMember(member5);

    //viaFit.removeInstructor("45856829");

    ArrayList<ScheduledClass> scheduledClasses = viaFit.getScheduledClasses();
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      System.out.println(scheduledClass);
    }

    DateTime date2 = new DateTime(31, 12, 2020, 22, 24);
    System.out.println(date2);

    // IO and Adapter test -- Maria

    // loading data for members
    ArrayList<Member> myMembers = new ArrayList<Member>();
    myMembers.add(member1);
    myMembers.add(member2);
    myMembers.add(member3);
    myMembers.add(member4);
    myMembers.add(member5);

    MyFileIO myFileIO = new MyFileIO();
    try
    {
      myFileIO.writeObjectToFile("TestMembers.bin", myMembers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }

    System.out.println("Done writing members");

    // loading data for instructors
    MyFileIO myFileIO1 = new MyFileIO();
    ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    instructors.add(instructor1);
    instructors.add(instructor2);
    instructors.add(instructor3);

    try
    {
      myFileIO1.writeObjectToFile("Instructors.bin", instructors);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading a file");
    }

    System.out.println("Done writing instructors");

    // loading data for classes
    MyFileIO myFileIO2 = new MyFileIO();
    ArrayList<Class> classes = new ArrayList<Class>();
    classes.add(class1);
    classes.add(class2);
    classes.add(class3);
    classes.add(class4);

    try
    {
      myFileIO2.writeObjectToFile("Classes.bin", classes);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }

    System.out.println("Done writing classes");

    // loading data for scheduled classes
    MyFileIO myFileIO3 = new MyFileIO();
    ArrayList<ScheduledClass> scheduledClasses1 = new ArrayList<ScheduledClass>();
    scheduledClasses1.add(scheduledClass1);
    scheduledClasses1.add(scheduledClass2);
    scheduledClasses1.add(scheduledClass3);
    scheduledClasses1.add(scheduledClass4);

    try
    {
      myFileIO3.writeObjectToFile("ScheduledClasses.bin", scheduledClasses1);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    catch (IOException e)
    {
      System.out.println("IO error when reading file");
    }

    System.out.println("Done writing schedules classes");

    // retrieve member and ArrayList of members from bin
    FitnessCenterFileAdapter adapter = new FitnessCenterFileAdapter(
        "TestMembers.bin", "Instructors.bin", "Classes.bin",
        "ScheduledClasses.bin");
    System.out.println(adapter.getAllMembers());
    System.out.println(adapter.getMember("45123456").getFirstName());

    // retrieve instructor and ArrayList of instructors from bin
    ArrayList<Instructor> myInstructors = adapter.getAllInstructors();
    System.out.println("Instructors: ");
    for (Instructor instructor : myInstructors)
    {
      System.out.println(instructor.getFirstName());
    }
    System.out.println(
        "\n" + adapter.getInstructor("122585674").hasClass("Spinning"));

    // retrieve class and ArrayList of classes from bin
    System.out.println(adapter.getAllClasses());
    System.out.println(adapter.getClassByName("Zumba"));

    // retrieve scheduled class and ArrayList of scheduled classes from bin
    ArrayList<ScheduledClass> scheduledClasses2 = adapter
        .getAllScheduledClasses();
    for (ScheduledClass scheduledClass : scheduledClasses2)
    {
      System.out.println(scheduledClass);
    }
    System.out
        .println("\n" + adapter.getScheduledClass(dateTime4, "Stretching"));
    //System.out.println(adapter3.getScheduledClassesInTimeInterval(dateTime1, dateTime2));

    String scheduledClassesInTimeInterval = adapter
        .displayScheduledClassesInTimeInterval(new DateTime(18, 5, 2020, 1, 1),
            new DateTime(24, 5, 2020, 23, 4));

    System.out.println(scheduledClassesInTimeInterval);

    //    Application.launch(GUI.class);
    System.out.println();
    System.out.println(adapter.getAllMembers().size());

    // testing adding and saving to bin
    Instructor instructor10 = new Instructor("mariaaaa", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "45856829", classesList1);

    System.out.println(adapter.getAllInstructors());
    adapter.saveInstructors("Instructors.bin", instructor10);
    System.out.println(adapter.getAllInstructors());
    System.out.println();

    Member member10 = new Member("Anastasiaaaa", "mimi", "mimi", "mimi", "23");
    System.out.println(adapter.getAllMembers());
    adapter.saveMembers("TestMembers.bin", member10);
    System.out.println(adapter.getAllMembers());

    Class class10 = new Class("dancing", 159);
    System.out.println(adapter.getAllClasses());
    adapter.saveClasses("Classes.bin", class10);
    System.out.println(adapter.getAllClasses());

    ScheduledClass scheduledClass10 = new ScheduledClass(class1, instructor1,
        dateTime1, 60);
    System.out.println(adapter.getAllScheduledClasses());
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(adapter.getAllScheduledClasses());

    System.out.println();
    System.out.println(adapter.getAllMembers());
    adapter.removeMember("TestMembers.bin", member10);
    System.out.println(adapter.getAllMembers());
    System.out.println();

    System.out.println(adapter.getAllInstructors());
    adapter.removeInstructor("Instructors.bin", instructor10);
    System.out.println(adapter.getAllInstructors());

    System.out.println();
    System.out.println(adapter.getAllScheduledClasses());
    adapter.removeScheduledClass("ScheduledClasses.bin", scheduledClass10);
    System.out.println("\n" + adapter.getAllScheduledClasses());
    // end of testing writing and removing to bin

  }
}
