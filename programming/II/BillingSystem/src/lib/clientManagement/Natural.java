package lib.clientManagement;

import lib.utils.*;
import java.util.Scanner;

public class Natural extends Client {
  private String Id;
  private Gender Gender;
  private IdType IdType;

  
  public Natural() {
    super(true);
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese su cédula: ");
    this.Id = sc.nextLine();

    System.out.print("Ingrese su sexo. Elija H o F: ");
    String gender = sc.next();
    // We check if the given letter is either F or H
    while (!gender.toLowerCase().equals("f") && !gender.toLowerCase().equals("h")) {
      System.out.print("Incorrecto... Ingrese de nuevo. H o F: ");
      gender = sc.next();
    }
    if (gender.toLowerCase().equals("h")) {
      this.Gender = Gender.Male;
    } else {
      this.Gender = Gender.Female;
    }

    System.out.print("Ingrese su tipo de indentificación. Elija V o E: ");
    String idType = sc.next();
    // We check if the given letter is either N or E
    while (!idType.toLowerCase().equals("e") && !idType.toLowerCase().equals("v")) {
      System.out.print("Incorrecto... Ingrese de nuevo. V o E: ");
      idType = sc.next();
    }
    if (idType.toLowerCase().equals("v")) {
      this.IdType = IdType.Venezolano;
    } else {
      this.IdType = IdType.Extranjero;
    }
  }

  public String getId() {
    return Id;
  }

  public Gender getGender() {
    return Gender;
  }

  public IdType getIdType() {
    return IdType;
  }

  @Override
  public String toString() {
    return this.display() + "Cédula: " + this.getId() + "\n" + "Tipo de natural: " + this.getIdType();
  }

  @Override
  public String display() {
    return "\n- - - INFORMACIÓN DEL CLIENTE - - -\n" +
           "Nombre y apellido: " + this.getName() + " " + this.getLastName() + "\n" + 
           "Correo: " + this.getEmail() + "\n" + "Dirección: " + this.getAddress() + "\n" +
           "Número celular: " + this.getPhoneNumber() + "\n";
  }
}
