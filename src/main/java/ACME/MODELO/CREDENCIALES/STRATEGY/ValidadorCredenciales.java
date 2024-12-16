package ACME.MODELO.CREDENCIALES.STRATEGY;

public class ValidadorCredenciales {
    private ValidacionStrategy strategy;

    public void setStrategy(ValidacionStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validarCredenciales(String usuario, String contraseña) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia de validación.");
        }
        return strategy.validar(usuario, contraseña);
    }

    public static void main(String[] args) {
        ValidadorCredenciales validador = new ValidadorCredenciales();

        // Validar un supervisor
        validador.setStrategy(new ValidacionFuncionarios());
        boolean adminValido = validador.validarCredenciales("adminUser", "Admin123!");
        System.out.println("Admin válido: " + adminValido);

        // Validar un guarda
        validador.setStrategy(new ValidacionGuarda());
        boolean usuarioValido = validador.validarCredenciales("user1", "12345");
        System.out.println("Usuario válido: " + usuarioValido);

        // Validar un guarda normal con contraseña inválida
        boolean usuarioInvalido = validador.validarCredenciales("user1", "123");
        System.out.println("Usuario válido: " + usuarioInvalido);
    }
}
