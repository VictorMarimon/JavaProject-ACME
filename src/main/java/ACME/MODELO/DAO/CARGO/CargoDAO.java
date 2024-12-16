package ACME.MODELO.DAO.CARGO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CargoDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Cargo cargo = (Cargo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM cargo WHERE NOMBRE_CARGO = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNombre_cargo());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar cargo empleado por cargo " + e.getMessage());
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
        Cargo cargo = (Cargo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM cargo WHERE NOMBRE_CARGO = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cargo.getNombre_cargo());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar id cargo empleado por cargo " + e.getMessage());
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
