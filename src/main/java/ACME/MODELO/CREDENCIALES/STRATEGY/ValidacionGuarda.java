package ACME.MODELO.CREDENCIALES.STRATEGY;

public class ValidacionGuarda implements ValidacionStrategy{
    @Override
    public boolean validar(String usuario, String contraseña) {
        return contraseña.length() >= 5;
    }
}
