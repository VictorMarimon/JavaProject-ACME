package ACME.MODELO.DAO.ACCESO;

public class Acceso {
    private String motivo;
    private String comentarios;

    public Acceso(){}

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
