package ACME.MODELO.CREDENCIALES.STRATEGY;

public class ValidacionSupervisores implements ValidacionStrategy{
    @Override
    public boolean validar(String usuario, String contraseña) {
        return contraseña.length() > 10 && contraseña.matches(".*[!@#$%^&*].*");
    }
}
