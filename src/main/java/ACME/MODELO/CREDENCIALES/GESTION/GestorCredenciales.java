package ACME.MODELO.CREDENCIALES.GESTION;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorCredenciales<T extends Credencial>  {
    private final String archivo;
    private final CredencialFactory<T> factory;

    public GestorCredenciales(String archivo, CredencialFactory<T> factory) {
        this.archivo = archivo;
        this.factory = factory;
    }

    // Guardar credencial
    public void guardarCredencial(T credencial) throws CredencialesException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(credencial.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new CredencialesException("Error al guardar la credencial", e);
        }
    }

    // Leer todas las credenciales
    public List<T> leerCredenciales() throws CredencialesException {
        List<T> credenciales = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                T credencial = factory.fromString(linea);
                if (credencial != null) {
                    credenciales.add(credencial);
                }
            }
        } catch (IOException e) {
            throw new CredencialesException("Error al leer las credenciales", e);
        }
        return credenciales;
    }

    // Verificar credenciales
    public boolean verificarCredencial(String usuario, String contraseña) throws CredencialesException {
        List<T> credenciales = leerCredenciales();
        for (T credencial : credenciales) {
            if (credencial.getUsuario().equals(usuario) && credencial.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }
}