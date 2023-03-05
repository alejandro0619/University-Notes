package lib.clientManagement;

import java.util.Scanner;

public class Person {
  private String Name;
  private String LastName;
  private String Address;
  private String Email;
  private String PhoneNumber;

  public Person() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese su nombre: ");
    String name = sc.nextLine();
    System.out.print("Ingrese su apellido: ");
    String lastName = sc.nextLine();
    System.out.print("Ingrese su dirección: ");
    String address = sc.nextLine();
    System.out.print("Ingrese su Email: ");
    String email = sc.nextLine();
    System.out.print("Ingrese su número telefónico: ");
    String phoneNumber = sc.nextLine();

    this.Name = name;
    this.LastName = lastName;
    this.Address = address;
    this.Email = email;
    this.PhoneNumber = phoneNumber;
  }

  public String getName() {
    return Name;
  }

  public String getLastName() {
    return LastName;
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

  public String display() {
    return "\n- - - INFORMACIÓN DEL CLIENTE - - -\n" +
           "Nombre y apellido: " + this.getName() + " " + this.getLastName() + "\n" + 
           "Correo: " + this.getEmail() + "\n" + "Dirección: " + this.getAddress() + "\n" +
           "Número celular: " + this.getPhoneNumber() + "\n";
  }
}
