public class Fichar {
    private Date dia;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    public Fichar(Date dia, LocalTime hora_entrada, LocalTime hora_salida){
        this.dia=dia;
        this.hora_entrada=hora_entrada;
        this.hora_salida=hora_salida;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Fichar{" +
                "dia=" + dia +
                ", hora_entrada=" + hora_entrada +
                ", hora_salida=" + hora_salida +
                '}';
    }

    public Date getDia() {
        return dia;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }
}
