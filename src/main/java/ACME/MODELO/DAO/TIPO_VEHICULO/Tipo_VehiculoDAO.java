package ACME.MODELO.DAO.TIPO_VEHICULO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.VEHICULO.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tipo_VehiculoDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Tipo_Vehiculo tipoVehiculo = (Tipo_Vehiculo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM TIPO_VEHICULO WHERE TIPO = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoVehiculo.getTipo());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar tipo vehiculo por tipo " + e.getMessage());
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
        Tipo_Vehiculo tipoVehiculo = (Tipo_Vehiculo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM TIPO_VEHICULO WHERE TIPO = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoVehiculo.getTipo());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar tipo vehiculo por tipo " + e.getMessage());
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

    public List<String> listarVehiculos() {
        List<String> vehiculos = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT TIPO FROM TIPO_VEHICULO;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                vehiculos.add(rs.getString("TIPO"));
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al listar tipos vehiculos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return vehiculos;
    }


    public static void main(String[] args) {
        Tipo_Vehiculo tv = new Tipo_Vehiculo();
        Tipo_VehiculoDAO d = new Tipo_VehiculoDAO();

        tv.setTipo("Camión");
        System.out.println(d.buscarID(tv));
    }
}
