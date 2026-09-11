import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTurnos gestorTurnos = new GestorTurnos();

        int opcion;
        do {
            System.out.println("Bienvenido centro medico tu playa");
            System.out.println("1.- Agregar pacientes");
            System.out.println("2.-  Asignar turno");
            System.out.println("3.- salir");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    gestorTurnos.agregarPacientes();
                    System.out.println(" ");
                    break;
                case 2:
                    gestorTurnos.asignarTurno();
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Ingrese la opción correcta ");
            }
        } while(opcion != 3);

    }
}