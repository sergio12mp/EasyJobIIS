public class Configuracion {
    private String idioma="Castellano";
    private boolean modo_nocturno= false;

    public String getIdioma() {
        return idioma;
    }

    public boolean isModo_nocturno() {
        return modo_nocturno;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setModo_nocturno(boolean modo_nocturno) {
        this.modo_nocturno = modo_nocturno;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Configuracion{" +
                "idioma='" + idioma + '\'' +
                ", modo_nocturno=" + modo_nocturno +
                '}';
    }
}
}
