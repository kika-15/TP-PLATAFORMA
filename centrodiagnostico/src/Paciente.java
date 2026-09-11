public class Paciente extends Persona implements Atendible{
    public Paciente(int id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public void atender(){
        System.out.println("El paciente " + getNombre() + " está siendo atendido.");
    }
}
