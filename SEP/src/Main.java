import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    FitnessCenter viaFit = new FitnessCenter();

    Instructor instructor1 = new Instructor("Bob", "Sixpack", "Horsens",
        "box.sixpack@viafit.com", "45856745", "Spinning");
    viaFit.addInstructor(instructor1);

    Class class1 = new Class("Spinning", 15);
    Class class2 = new Class("Yoga", 20);
    viaFit.addClass(class1);
    viaFit.addClass(class2);

    viaFit.removeClass("Yoga");

    Member member1 = new Member("John", "Doe", "Horsens", "johndoe@gmail.com", "45852123");
    Member member2 = new Member("Jane", "Doe", "Horsens", "janedoe@gmail.com", "45123456");
    Member member3 = new Member("Cezary", "Doe", "Horsens", "cezary@gmail.com", "81458963");
    Member member4 = new Member("Maria", "Doe", "Horsens", "maria@gmail.com", "75312345");
    Member member5 = new Member("Claudiu", "Doe", "Horsens", "claudiu@gmail.com", "12458796");


    member1.upgradeMembership();
    member3.upgradeMembership();
    viaFit.addMember(member1);
    viaFit.addMember(member2);
    viaFit.addMember(member3);
    viaFit.addMember(member4);
    viaFit.addMember(member5);

    ScheduledClass scheduledClass1 = new ScheduledClass(class1, instructor1, new DateTime(19, 5, 2020, 18, 0));
    ScheduledClass scheduledClass2 = new ScheduledClass(class2, instructor1, new DateTime(19, 5, 2020, 19, 0));
    viaFit.addScheduledClass(scheduledClass1);
    viaFit.addScheduledClass(scheduledClass2);

    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning").addMember(member1);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning").addMember(member2);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning").addMember(member3);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning").addMember(member4);
    viaFit.getScheduledClass(new DateTime(19, 5, 2020, 18, 0), "Spinning").addMember(member5);

    ArrayList<Class> classes = viaFit.getClasses();
    for (Class classItem : classes)
    {
      System.out.println(classItem);
    }

    ArrayList<ScheduledClass> scheduledClasses = viaFit.getScheduledClasses();
    for (ScheduledClass scheduledClass : scheduledClasses)
    {
      System.out.println(scheduledClass);
    }
  }
}
