import java.io.Serializable;

public class Member extends Person implements Serializable
{
  private boolean premiumMembership;

  public Member(String firstName, String lastName, String address, String email,
      String phoneNumber)
  {
    super(firstName, lastName, address, email, phoneNumber);
    premiumMembership = false;
  }

  public void upgradeMembership()
  {
    premiumMembership = true;
  }

  public void downgradeMembership()
  {
    premiumMembership = false;
  }

  public boolean hasPremiumMembership()
  {
    return premiumMembership;
  }

  public String toString()
  {
    return "Member{" + super.toString() + "premiumMembership=" + premiumMembership + '}';
  }

  public Member copy()
  {
    return new Member(super.getFirstName(), super.getLastName(), super.getAddress(), super.getEmail(), super.getPhoneNumber());
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Member))
    {
      return false;
    }
    Member other = (Member) obj;
    return super.equals(other) && premiumMembership == other.premiumMembership;
  }
}
