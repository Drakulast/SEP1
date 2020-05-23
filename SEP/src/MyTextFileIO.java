import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyTextFileIO
{
  public void writeToFile(String fileName, String str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    write.println(str);
    write.close();
    System.out.println("Done writing to file.");
  }

  public void appendToFile(String fileName, String str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    write.println(str);
    write.close();
    System.out.println("Done appending to file.");
  }

  public void writeToFile(String fileName, String[] str)
      throws FileNotFoundException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    PrintWriter write = new PrintWriter(fileOut);
    for (String string : str)
    {
      write.println(string);
    }
    write.close();
    System.out.println("Done writing to file.");
  }

  public void appendToFile(String fileName, String[] str)
      throws FileNotFoundException

  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    PrintWriter write = new PrintWriter(fileOut);
    for (String string : str)
    {
      write.println(string);
    }
    write.close();
    System.out.println("Done appending to file.");
  }

  public String readStringFromFile(String fileName) throws FileNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    read.close();
    System.out.println("Done reading to file.");
    return read.nextLine();
  }

  public String[] readArrayFromFile(String fileName)
      throws FileNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    Scanner read = new Scanner(fileIn);
    ArrayList<String> tempArray = new ArrayList<String>();
    while (read.hasNext())
    {
      tempArray.add(read.nextLine());
    }
    read.close();
    String[] temp = new String[tempArray.size()];
    temp = tempArray.toArray(temp);
    System.out.println("Done reading to file.");
    return temp;
  }
}
