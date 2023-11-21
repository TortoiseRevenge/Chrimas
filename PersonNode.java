
public class PersonNode {
  private String email;
  private String name;
  private PersonNode personToGive;

  public PersonNode(String name, String email, PersonNode next) {
    this.email = email;
    this.name = name;
    this.personToGive = next;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public PersonNode getToGive() {
    return personToGive;
  }

  public void setToGive(PersonNode set) {
    this.personToGive = set;
  }
}
