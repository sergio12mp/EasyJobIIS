public class SolicitudHorario {
    private String motivo;
    private boolean aceptado=false;
    public SolicitudHorario(String motivo){
        this.motivo=motivo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SolicitudHorario{" +
                "motivo='" + motivo + '\'' +
                '}';
    }
}
