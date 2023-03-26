package lib.clientManagement;

import java.util.Scanner;
import lib.utils.IdType;

public class Bussiness extends Client {
  private String Id;
  private IdType IdType;

  public Bussiness() {
    super(false);
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese su RIF: ");
    this.Id = sc.nextLine();

    System.out.print("Ingrese su tipo de indentificación: Elija J o G. ");
    String idType = sc.next();
    // We check if the given letter is either N or E
    while (!idType.toLowerCase().equals("j") && !idType.toLowerCase().equals("g")) {
      System.out.print("Incorrecto... Ingrese de nuevo: J o G. ");
      idType = sc.next();
    }
    if (idType.toLowerCase().equals("j")) {
      this.IdType = IdType.Juridico;
    } else {
      this.IdType = IdType.Gubernamental;
    }
  }

  public String getId() {
    return Id;
  }

  public IdType getIdType() {
    return IdType;
  }
  @Override
  public String toString() {
    return this.display() + "RIF: " + this.getId() + "\n" +"Tipo de jurídico: " + this.getIdType();
  }

  @Override
  public String display() {
    return "\n- - - INFORMACIÓN DEL CLIENTE - - -\n" +
           "Razón social:" + this.getName() + "\n" + 
           "Correo: " + this.getEmail() + "\n" + "Dirección: " + this.getAddress() + "\n" +
           "Número celular: " + this.getPhoneNumber() + "\n";
  }
}
