import java.io.*;
import java.util.ArrayList;

public class MyFileIO
{
  public void writeToFile(String fileName, Object obj)
      throws FileNotFoundException, IOException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName, true);
    ObjectOutputStream write = new ObjectOutputStream(fileOut);
    write.writeObject(obj);
    write.close();
  }

  public void writeToFile(String fileName, Object[] obj)
      throws FileNotFoundException, IOException
  {
    FileOutputStream fileOut = new FileOutputStream(fileName);
    ObjectOutputStream write = new ObjectOutputStream(fileOut);
    for (int i = 0; i < obj.length; i++)
    {
      write.writeObject(obj[i]);
    }
    write.close();
  }

  public Object readObjectFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream read = new ObjectInputStream(fileIn);
    return (Object) read.readObject();
  }

  public Object[] readArrayFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    FileInputStream fileIn = new FileInputStream(fileName);
    ObjectInputStream read = new ObjectInputStream(fileIn);
    ArrayList<Object> tempArray = new ArrayList<Object>();
    while (true)
    {
      try
      {
        Object object = (Object) read.readObject();
        tempArray.add(object);
      }
      catch (EOFException e)
      {
        System.out.println("End of file.");
        break;
      }
    }
    read.close();
    Object[] temp = new Object[tempArray.size()];
    temp = tempArray.toArray(temp);
    return temp;
  }
}
