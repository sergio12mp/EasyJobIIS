
import java.util.Arrays;

public class EquipoDeTrabajo {
    private String IDdeEquipo;
    private Empleado[] empleados;
    private int numEmpleados;

    public EquipoDeTrabajo(String id, int tam){
        IDdeEquipo = id;
        empleados = new Empleado[tam];
        numEmpleados = 0;
    }

    public void añadirEmpleado(String nombre, String apellidos, String correoElectronico, String DNI, String telefono, String contrasena){
        if(numEmpleados == empleados.length){
            empleados = Arrays.copyOf(empleados, 2*empleados.length);
        }
        empleados[numEmpleados] = new Empleado(nombre, apellidos, correoElectronico,DNI, telefono, contrasena);
        numEmpleados++;
    }


}
