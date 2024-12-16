package ACME.MODELO.CREDENCIALES.STRATEGY;

public interface ValidacionStrategy {
    boolean validar(String usuario, String contraseña);
}
