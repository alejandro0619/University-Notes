package lib.clientManagement;

import java.util.Scanner;

public abstract class Client {
  private String Name;
  private String LastName;

  private String Address;
  private String Email;
  private String PhoneNumber;

  public Client(boolean hasLastName) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese su nombre: ");
    this.Name = sc.nextLine();
    if(hasLastName) {
      System.out.print("Ingrese su apellido: ");
      this.LastName = sc.nextLine();
    } else {
      this.LastName = null;
    }

    System.out.print("Ingrese su dirección: ");
    String address = sc.nextLine();
    System.out.print("Ingrese su Email: ");
    String email = sc.nextLine();
    System.out.print("Ingrese su número telefónico: ");
    String phoneNumber = sc.nextLine();

    this.Address = address;
    this.Email = email;
    this.PhoneNumber = phoneNumber;
  }

  public String getAddress() {
    return Address;
  }

  public String getEmail() {
    return Email;
  }

  public String getPhoneNumber() {
    return PhoneNumber;
  }
  public String getLastName() {
    return LastName;
  }
  public abstract String display();

  public String getName() {
    return Name;
  }
    
}
