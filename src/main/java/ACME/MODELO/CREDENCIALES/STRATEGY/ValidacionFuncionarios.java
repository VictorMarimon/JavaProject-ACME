package ACME.MODELO.CREDENCIALES.STRATEGY;

public class ValidacionFuncionarios implements ValidacionStrategy{
    @Override
    public boolean validar(String usuario, String contraseña) {
        return contraseña.length() > 10;
    }
}
