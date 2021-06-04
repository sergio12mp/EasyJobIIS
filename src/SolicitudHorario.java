import java.util.Arrays;

public class SolicitudHorario{
        private int iden;
        private String dni_empleado;
        private String dni_jefe;
        private int[] semana = new int[7];

        public SolicitudHorario() {
            for (int i = 0; i<semana.length; i++){
                semana[i] = 0;
            }
        }
        public SolicitudHorario(int iden,String dni_e,String dni_j,int[] semana){
            this.iden = iden;
            this.dni_empleado = dni_e;
            this.dni_jefe = dni_j;
            this.semana = semana;
        }

        public int[] getSemana(){
            return semana;
        }
        public String getDni_empleado() { return dni_empleado;}
        public String getDni_jefe() { return dni_jefe;}

        public String toString() {
            return  Arrays.toString(semana);
        }
}