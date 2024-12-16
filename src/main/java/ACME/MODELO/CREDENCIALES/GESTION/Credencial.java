package ACME.MODELO.CREDENCIALES.GESTION;

public interface Credencial {
    String getUsuario();
    String getContraseña();
    String toString();
    static Credencial fromString(String data) {
        return null;
    }
}
