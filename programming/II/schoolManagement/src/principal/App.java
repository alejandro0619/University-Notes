package principal;
import menu.MenuManagement;

/*
 * Datos: 
    *  Nombre, 
    *  Apellido, 
    *  Fecha de nacimiento, 
    *  Sexo, 
    *  Notas.
 * Menu:
    *  1. Agregar X cantidad de estudiantes.
    *  2. Editar estudiantes
    *  3. Listado de estudiantes
        3.1. Mostrará lista de estudiantes.
        3.2. Deberá mostrar la nota americana.
        3.3. Deberá mostrar la nota en letras.
    * 4. Estadística:
    *  4.1. Promedio general del salón.
        4.1.1 Nombre y apellido del estudiante.
        4.1.2. En caso de tener 2 notas o 3 notas iguales, deberán ser mostradas por igual.
    *  4.2. Promedio más bajo.
        4.2.1. Nombre y apellido del estudiante.
        4.2.2. En caso de haber 2 o 3 notas iguales. deberán ser mostradas por igual.
        4.2.3. Deberá mostrar la nota americana.
        4.2.4. Deberá mostrar la nota en letras.
    *  4.3. Persona con mayor edad.
        4.3.1. Nombre y apellido
        4.3.2. Fecha de nacimiento y edad.
    *  4.4. Persona con menor edad.
        4.4.1. Nombre y apellido
        4.4.2. Fecha de nacimiento y edad.
 * Salir.
 */

public class App {
    public static void main(String[] args) {
        // renderizamos el menu.
        new MenuManagement().displayMenu();
        
    }
}
