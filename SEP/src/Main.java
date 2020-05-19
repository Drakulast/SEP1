import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    ArrayList<Member> members = new ArrayList<>()

    FitnessCenter viaFit = new FitnessCenter();
    viaFit.addInstructor(new Instructor("Bob", "Sixpack", "Biceps Lane", "bob@sixpack.com", "53758965"));
    viaFit.addClass(new Class("Yoga", 20));
    viaFit.addMember(new Member("John", "Doe", "Kamtjatka", "johndoe@gmail.com", "81569452"));
    viaFit.addMember(new Member("Jane", "Doe", "Kamtjatka", "janedoe@gmail.com", "81325984"));
    viaFit.addScheduledClass(new ScheduledClass(viaFit.getClassItem("Yoga"),
        viaFit.getInstructor("53758965"),new DateTime(19, 5, 2020, 14, 0), new ArrayList<Member>()));

  }
}
