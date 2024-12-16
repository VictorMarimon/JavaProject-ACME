package ACME.MODELO.CREDENCIALES.GESTION;

public interface CredencialFactory<T>{
    T fromString(String data);
}
