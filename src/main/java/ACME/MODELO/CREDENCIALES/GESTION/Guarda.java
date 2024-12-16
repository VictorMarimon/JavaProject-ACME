package ACME.MODELO.CREDENCIALES.GESTION;

public class Guarda implements Credencial{

    private String usuario;
    private String contraseña;

    public Guarda(String usuario, String contraseña) {
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

    public static Guarda fromString(String data) {
        String[] partes = data.split(",");
        if (partes.length == 2) {
            return new Guarda(partes[0], partes[1]);
        }
        return null;
    }
}
