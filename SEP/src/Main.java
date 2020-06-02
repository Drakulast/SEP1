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

    ArrayList<String> classesListClaudiu = new ArrayList<String>();
    classesListClaudiu.add("Spinning");
    classesListClaudiu.add("Yoga");
    classesListClaudiu.add("TRX");
    ArrayList<String> classesListIonut = new ArrayList<String>();
    classesListIonut.add("Yoga");
    classesListIonut.add("Crossfit");
    classesListIonut.add("Stretching");
    ArrayList<String> classesListMaria = new ArrayList<String>();
    classesListMaria.add("Yoga");
    classesListMaria.add("Stretching");
    Instructor Claudiu = new Instructor("Claudiu", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "50108854", classesListClaudiu);
    Instructor Ionut = new Instructor("Ionut", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "353356745", classesListIonut);
    Instructor Maria = new Instructor("Maria", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "122585674", classesListMaria);

    viaFit.addInstructor(Claudiu);
    viaFit.addInstructor(Ionut);
    viaFit.addInstructor(Maria);

    Class Spinning = new Class("Spinning", 15);
    Class Yoga = new Class("Yoga", 20);
    Class Crossfit = new Class("Crossfit", 10);
    Class Stretching = new Class("Stretching", 25);
    Class TRX = new Class("TRX", 30);
    viaFit.addClass(Spinning);
    viaFit.addClass(Yoga);
    viaFit.addClass(Crossfit);
    viaFit.addClass(Stretching);
    viaFit.addClass(TRX);

    Member Cezary = new Member("Cezary", "Doe", "Horsens", "johndoe@gmail.com",
        "45852123");
    Member Jane = new Member("Jane", "Doe", "Horsens", "janedoe@gmail.com",
        "45123456");
    Member AnotherCezary = new Member("AnotherCezary", "Doe", "Horsens", "cezary@gmail.com",
        "81458963");
    Member MariaMember = new Member("Maria", "Doe", "Horsens", "maria@gmail.com",
        "75312345");
    Member ClaudiuJunior = new Member("Claudiu", "Doe", "Horsens",
        "claudiu@gmail.com", "12458796");

    Cezary.upgradeMembership();
    AnotherCezary.upgradeMembership();
    viaFit.addMember(Cezary);
    viaFit.addMember(Jane);
    viaFit.addMember(AnotherCezary);
    viaFit.addMember(MariaMember);
    viaFit.addMember(ClaudiuJunior);

    // loading data for members
    ArrayList<Member> myMembers = new ArrayList<Member>();
    myMembers.add(Cezary);
    myMembers.add(Jane);
    myMembers.add(AnotherCezary);
    myMembers.add(MariaMember);
    myMembers.add(ClaudiuJunior);

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
    instructors.add(Claudiu);
    instructors.add(Ionut);
    instructors.add(Maria);

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
    classes.add(Yoga);
    classes.add(Crossfit);
    classes.add(TRX);
    classes.add(Stretching);
    classes.add(Spinning);

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
  }
}
