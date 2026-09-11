import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorTurnos {
    ArrayList<Paciente> pacientes;
    Scanner scanner = new Scanner(System.in);

    public GestorTurnos(){
        pacientes = new ArrayList<>();
    }

    public void agregarPacientes(){
        System.out.println("Ingrese el id del paciente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del paciente");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad del paciente:");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = new Paciente(id, nombre, edad);
        pacientes.add(paciente);
        System.out.println("Se agrego pasiente correctamente");
    }

    public void asignarTurno(){

        if (pacientes.isEmpty()){
            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.println("Ingrese el id del paciente");
        int id = scanner.nextInt();
        scanner.nextLine();

        Paciente pacienteEncontrado = null;

        for (Paciente paciente: pacientes){
            if (paciente.getId() == id){
                pacienteEncontrado = paciente;
            }
        }

        if (pacienteEncontrado == null){
            System.out.println("No se encontró el paciente");
            return;
        }

        try{

            System.out.println("ingrese el año");
            int anio = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el numero del mes");
            int mes = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el dia");
            int dia = scanner.nextInt();
            scanner.nextLine();

            LocalDate fecha = LocalDate.of(anio, mes, dia);

            if(fecha.isBefore(LocalDate.now())){
                throw new Exception( "No se puede asignar un turno con una fecha pasada.");
            }
            System.out.println("Su turno fue asignado correctamente");
            System.out.println("Paciente: " + pacienteEncontrado.getNombre());

            System.out.println("Fecha: "  + fecha);

        } catch (TurnoInvalidoException e){
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e){
            System.out.println("Error: la fecha ingresada no es válida.");
        }
    }
}
