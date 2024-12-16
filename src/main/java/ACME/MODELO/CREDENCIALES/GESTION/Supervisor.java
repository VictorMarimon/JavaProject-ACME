package ACME.MODELO.CREDENCIALES.GESTION;

import java.util.List;

public class Supervisor implements Credencial{
    private String usuario;
    private String contraseña;

    public Supervisor(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return usuario + "," + contraseña;
    }

    public static Supervisor fromString(String data) {
        String[] partes = data.split(",");
        if (partes.length == 2) {
            return new Supervisor(partes[0], partes[1]);
        }
        return null;
    }

    public static void main(String[] args) {
        String archivo = "supervisores.txt";
        GestorCredenciales<Supervisor> gestor = new GestorCredenciales<>(archivo, Supervisor::fromString);

        try {
            // Guardar un supervisor
            Supervisor supervisor = new Supervisor("abc", "bca");
            gestor.guardarCredencial(supervisor);

            // Verificar credencial
            boolean valido = gestor.verificarCredencial("abc", "bca");
            System.out.println("Credenciales válidas: " + valido);

            // Leer supervisores
            List<Supervisor> supervisores = gestor.leerCredenciales();
            supervisores.forEach(s -> System.out.println("Supervisor: " + s.getUsuario()));

        } catch (CredencialesException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
