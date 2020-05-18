public class Member extends Person
{
  private boolean premiumMembership;

  public Member(String firstName, String lastName, String address, String email,
      String phoneNumber, boolean premiumMembership)
  {
    super(firstName, lastName, address, email, phoneNumber);
    this.premiumMembership = premiumMembership;
  }

  public void upgradeMembership()
  {
    premiumMembership = true;
  }

  public void downgradeMembership()
  {
    premiumMembership = false;
  }

  public String toString()
  {
    return "Member{" + "premiumMembership=" + premiumMembership + '}';
  }

  public Member copy()
  {
    return new Member(super.getFirstName(), super.getLastName(), super.getAddress(), super.getEmail(), super.getPhoneNumber(), premiumMembership);
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
