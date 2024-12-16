package ACME.MODELO.DAO.VEHICULO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_Vehiculo;
import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_VehiculoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Vehiculo vehiculo = (Vehiculo) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM VEHICULO WHERE PLACA = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar vehiculo por placa " + e.getMessage());
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

    public boolean agregarVehiculo(Object object, Tipo_Vehiculo tipo_vehiculo){
        Vehiculo vehiculo = (Vehiculo) object;

        Tipo_VehiculoDAO tpDAO = new Tipo_VehiculoDAO();

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "INSERT INTO VEHICULO(PLACA, MODELO, MARCA, MOTOR, CILINDRAJE, COLOR, TIPO_VEHICULO_ID)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getMarca());
            ps.setString(4, vehiculo.getMotor());
            ps.setString(5, vehiculo.getCilindraje());
            ps.setString(6, vehiculo.getColor());

            var tipo_vehiculo_id = tpDAO.buscarID(tipo_vehiculo);

            if (tipo_vehiculo_id != -1){
                ps.setInt(7, tipo_vehiculo_id);
            }else{
                ps.setInt(7, 1);
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar vehiculo " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Tipo_Vehiculo tv = new Tipo_Vehiculo();
        Vehiculo vh = new Vehiculo();
        VehiculoDAO vd = new VehiculoDAO();

        tv.setTipo("Camión");

        vh.setCilindraje("200");
        vh.setColor("blanco");
        vh.setMarca("susuki");
        vh.setModelo("2020");
        vh.setMotor("z1000a");
        vh.setPlaca("29JK39");

        vd.agregarVehiculo(vh, tv);
    }
}
