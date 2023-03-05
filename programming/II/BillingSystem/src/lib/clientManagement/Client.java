package lib.clientManagement;

import lib.utils.*;
import java.util.Scanner;

public class Client extends Person {
  private String ID;
  private Gender Gender;
  private IDType IdType;

  public Client() {
    super();
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese su cédula: ");
    this.ID = sc.nextLine();

    System.out.print("Ingrese su sexo: Elija H o F. ");
    String gender = sc.next();
    // We check if the given letter is either F or H
    while (!gender.toLowerCase().equals("f") && !gender.toLowerCase().equals("h")) {
      System.out.print("Incorrecto... Ingrese de nuevo: H o F. ");
      gender = sc.next();
    }
    if (gender.toLowerCase().equals("h")) {
      this.Gender = Gender.Male;
    } else {
      this.Gender = Gender.Female;
    }

    System.out.print("Ingrese su tipo de indentificación: Elija N o E. ");
    String idType = sc.next();
    // We check if the given letter is either N or E
    while (!idType.toLowerCase().equals("e") && !idType.toLowerCase().equals("n")) {
      System.out.print("Incorrecto... Ingrese de nuevo: N o E. ");
      idType = sc.next();
    }
    if (idType.toLowerCase().equals("n")) {
      this.IdType = IDType.Natural;
    } else {
      this.IdType = IDType.Extranjero;
    }
  }

  public String getID() {
    return ID;
  }

  public Gender getGender() {
    return Gender;
  }

  public IDType getIdType() {
    return IdType;
  }

  @Override
  public String toString() {
    return this.display() + "Identificación: " + this.getID();
  }
}
