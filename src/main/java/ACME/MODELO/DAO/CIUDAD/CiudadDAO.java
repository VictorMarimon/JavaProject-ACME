package ACME.MODELO.DAO.CIUDAD;
import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CiudadDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return null;
    }

    @Override
    public boolean buscar(Object object) {
        return false;
    }

    @Override
    public boolean agregar(Object object) {
        return false;
    }

    @Override
    public boolean modificar(Object object) {
        return false;
    }

    public int buscarIDCiudad(Object object){

        Ciudad ciudad = (Ciudad) object;

        PreparedStatement ps;
        ResultSet rs;

        var con = conexionInst.getConexion();
        var sql = "SELECT ID FROM CIUDAD WHERE NOMBRE_CIUDAD = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ciudad.getNombre_ciudad());
            rs = ps.executeQuery();

            if (rs.next()){
                int ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar persona por cedula " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        int IdNotFdund = -1;
        return IdNotFdund;
    }

    public List<String> listarCiudades() {
        List<String> ciudades = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT NOMBRE_CIUDAD FROM CIUDAD;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ciudades.add(rs.getString("NOMBRE_CIUDAD"));
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al listar ciudades: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return ciudades;
    }
}
