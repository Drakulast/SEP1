import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFileIO
{
  public void writeObjectToFile(String fileName, Object object)
      throws FileNotFoundException, IOException
  {
    ObjectOutputStream objectOutputStream = null;

    try
    {
      FileOutputStream fileOutputStream = new FileOutputStream(fileName);
      objectOutputStream = new ObjectOutputStream(fileOutputStream);

      objectOutputStream.writeObject(object);
    }
    finally
    {
      if (objectOutputStream != null)
      {
        try
        {
          objectOutputStream.close();
        }
        catch (IOException e)
        {
          System.out.println("IO error when closing the file: " + fileName);
        }
      }
    }
  }

  // When reading from a file the object type needs to be casted
  public Object readObjectFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    Object object = null;
    ObjectInputStream objectInputStream = null;

    try
    {
      FileInputStream fileInputStream = new FileInputStream(fileName);
      objectInputStream = new ObjectInputStream(fileInputStream);

      try
      {
        object = objectInputStream.readObject();
      }
      catch (EOFException e)
      {
        System.out.println("Done reading");
      }
    }
    finally
    {
      if (objectInputStream != null)
      {
        try
        {
          objectInputStream.close();
        }
        catch (IOException e)
        {
          System.out.println("IO error when closing file: " + fileName);
        }
      }
    }
    return object;
  }
}
