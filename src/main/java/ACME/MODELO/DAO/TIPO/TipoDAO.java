package ACME.MODELO.DAO.TIPO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_Persona;
import ACME.MODELO.DAO.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TipoDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Tipo tipo = (Tipo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM tipo WHERE NOMBRE_TIPO = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getNombre_tipo());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar tipo persona por tipo " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

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

    public int buscarID(Object object){
        Tipo tipo = (Tipo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM tipo WHERE NOMBRE_TIPO = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tipo.getNombre_tipo());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar id tipo persona por tipo " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        ID = -1;

        return ID;
    }
}
