package ACME.MODELO.DAO.REGISTRO_ACCESO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.ACCESO.AccesoDAO;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.ESTADO.EstadoDAO;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO.TipoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Registro_AccesoDAO implements IDAO {

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

    public boolean agregarRegistroAcceso(Object object, Acceso acceso){
        AccesoDAO aDAO = new AccesoDAO();

        Registro_Acceso registroAcceso = (Registro_Acceso) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        String sql = "INSERT INTO REGISTRO_ACCESO(HORA_ENTRADA, HORA_SALIDA, ACCESO_ID)\n" +
                "VALUES(?, ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, registroAcceso.getHora_entrada());
            ps.setString(2, registroAcceso.getHora_salida());

            int ID_ACCESO = aDAO.buscarID(acceso);

            if (ID_ACCESO != -1){
                ps.setInt(3, ID_ACCESO);
            }else{
                ps.setInt(3, 1);
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

    public static void main(String[] args) {
        Acceso a = new Acceso();
        Registro_Acceso ra = new Registro_Acceso();

        Registro_AccesoDAO raDAO = new Registro_AccesoDAO();

        a.setComentarios("entrada normal");
        a.setMotivo("visita regular");

        ra.setHora_entrada("2023-01-15 09:00:00");
        ra.setHora_salida("2023-01-15 12:00:00");

        raDAO.agregarRegistroAcceso(ra, a);
    }
}
