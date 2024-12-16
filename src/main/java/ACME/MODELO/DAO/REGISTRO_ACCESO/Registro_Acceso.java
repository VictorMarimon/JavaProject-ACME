package ACME.MODELO.DAO.REGISTRO_ACCESO;

public class Registro_Acceso {
    private String hora_entrada;
    private String hora_salida;

    public Registro_Acceso(){}

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
}
