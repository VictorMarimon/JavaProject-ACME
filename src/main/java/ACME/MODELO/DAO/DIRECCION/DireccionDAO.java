package ACME.MODELO.DAO.DIRECCION;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.CIUDAD.CiudadDAO;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import ACME.MODELO.DAO.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DireccionDAO implements IDAO {

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

    public boolean agregarDir(Object object, Ciudad ciudad){
        CiudadDAO Ciudad = new CiudadDAO();

        Direccion direccion = (Direccion) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        String sql = "INSERT INTO DIRECCION( CALLE, CARRERA, TRANSVERSAL, DIAGONAL, NUMERO, CIUDAD_ID)\n" +
                "VALUES(?,?,?,?,?,?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getCarrera());
            ps.setString(3, direccion.getTransversal());
            ps.setString(4, direccion.getDiagonal());
            ps.setString(5, direccion.getNumero());

            int ID_CIUDAD = Ciudad.buscarIDCiudad(ciudad);

            if (ID_CIUDAD != -1){
                ps.setInt(6, ID_CIUDAD);
            }else{
                ps.setInt(6, 1);
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar persona " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }

    public int buscarID(Object object){
        Direccion direccion = (Direccion) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM DIRECCION WHERE CALLE = ? AND CARRERA = ? AND TRANSVERSAL = ? AND DIAGONAL = ? AND NUMERO = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getCarrera());
            ps.setString(3, direccion.getTransversal());
            ps.setString(4, direccion.getDiagonal());
            ps.setString(5, direccion.getNumero());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar id estado empresa por estado " + e.getMessage());
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

    public static void main(String[] args) {
        Ciudad c = new Ciudad();
        Direccion d = new Direccion();

        c.setNombre_ciudad("Cali");

        d.setCalle("1");
        d.setCarrera("1");
        d.setDiagonal("1");
        d.setNumero("1");
        d.setTransversal("1");

        DireccionDAO nuevaDir = new DireccionDAO();



        System.out.println(nuevaDir.buscarID(d));
    }

}
