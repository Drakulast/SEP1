import java.io.Serializable;

public abstract class Person implements Serializable
{
  private String firstName;
  private String lastName;
  private String address;
  private String email;
  private String phoneNumber;

  public Person(String firstName, String lastName, String address, String email,
      String phoneNumber)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFullName()
  {
    return firstName + " " + lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String toString()
  {
    return firstName + " " + lastName + ", Phone number: " + phoneNumber;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Person))
    {
      return false;
    }
    Person other = (Person) obj;
    return firstName.equals(other.firstName) && lastName.equals(other.lastName)
        && address.equals(other.address) && email.equals(other.email)
        && phoneNumber.equals(other.phoneNumber);
  }
}
