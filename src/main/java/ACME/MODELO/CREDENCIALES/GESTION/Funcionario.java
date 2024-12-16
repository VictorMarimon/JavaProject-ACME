package ACME.MODELO.CREDENCIALES.GESTION;

public class Funcionario implements Credencial{

    private String usuario;
    private String contraseña;

    public Funcionario(String usuario, String contraseña) {
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

    public static Funcionario fromString(String data) {
        String[] partes = data.split(",");
        if (partes.length == 2) {
            return new Funcionario(partes[0], partes[1]);
        }
        return null;
    }
}
