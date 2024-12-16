package ACME.MODELO.DAO.ACCESO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.ESTADO.EstadoDAO;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO.TipoDAO;
import ACME.MODELO.DAO.TIPO_ACCESO.Tipo_Acceso;
import ACME.MODELO.DAO.TIPO_ACCESO.Tipo_AccesoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccesoDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
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

    public boolean agregarAcceso(Object object, Tipo_Acceso tipo, Estado estado){
        EstadoDAO eDAO = new EstadoDAO();

        Tipo_AccesoDAO tDAO = new Tipo_AccesoDAO();

        Acceso acceso = (Acceso) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        String sql = "INSERT INTO acceso(MOTIVO, COMENTARIOS, TIPO_ACCESO_ID, ESTADO_ID)\n" +
                "VALUES(?, ?, ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, acceso.getMotivo());
            ps.setString(2, acceso.getComentarios());

            int ID_TIPO_ACCESO = tDAO.buscarID(tipo);

            if (ID_TIPO_ACCESO != -1){
                ps.setInt(3, ID_TIPO_ACCESO);
            }else{
                ps.setInt(3, 1);
            }

            int ID_ESTADO = eDAO.buscarID(estado);

            if (ID_ESTADO != -1){
                ps.setInt(4, ID_ESTADO);
            }else{
                ps.setInt(4, 1);
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar acceso " + e.getMessage());
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
        Acceso acceso = (Acceso) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM acceso WHERE MOTIVO = ? AND COMENTARIOS = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, acceso.getMotivo());
            ps.setString(2, acceso.getComentarios());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar id acceso por motivo y comentarios " + e.getMessage());
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
        Tipo_Acceso t = new Tipo_Acceso();
        Estado e = new Estado();
        Acceso a = new Acceso();
        AccesoDAO aDAO = new AccesoDAO();

        t.setTipo("Acceso general");

        e.setEstado("Autorizado");

        a.setComentarios("entrada normal");
        a.setMotivo("visita regular");

        aDAO.agregarAcceso(a,t,e);
    }

}
