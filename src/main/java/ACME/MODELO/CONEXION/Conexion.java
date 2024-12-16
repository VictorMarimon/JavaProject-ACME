package ACME.MODELO.CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String name = "beghb5zf87ku4jmxe7p1";
    private static final String url = "jdbc:mysql://beghb5zf87ku4jmxe7p1-mysql.services.clever-cloud.com/" + name;
    private static final String user = "uhqyuqdrxcqmtf2t";
    private static final String password = "Pw9FJ3esOWH2NZuj55s2";

    private static Connection conexion;
    private static Conexion instancia;

    private Conexion(){}

    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
