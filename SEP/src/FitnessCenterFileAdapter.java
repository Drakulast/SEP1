import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FitnessCenterFileAdapter
{
   private MyFileIO mfio;
   private String membersFileName;
   private String classesFileName;
   private String instructorsFileName;
   private String scheduledClassesFileName;

   public FitnessCenterFileAdapter(String membersFileName, String classesFileName, String instructorsFileName, String scheduledClassesFileName)
   {
      mfio = new MyFileIO();
      this.membersFileName = membersFileName;
      this.classesFileName = classesFileName;
      this.instructorsFileName = instructorsFileName;
      this.scheduledClassesFileName = scheduledClassesFileName;
   }
 
   // Use the MyFileIO class to retrieve a StudentList object with all Students
   public ArrayList<Member> getAllMembers()
   {
      Member[] members;
      ArrayList<Member> membersArrayList = new ArrayList<Member>();
      try
      {
         members = (Member[]) mfio.readArrayFromFile(membersFileName);

         for (int i = 0; i < members.length; i++)
         {
            membersArrayList.add(members[i]);
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return membersArrayList;
   }



   // Use the MyFileIO class to save all Members in the ArrayList
   public void saveMembers(ArrayList<Member> members)
   {
      try
      {
         Member[] temp = new Member[members.size()];
         temp = members.toArray(temp);
         mfio.writeToFile(membersFileName, temp);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }

}
