package ACME.MODELO.DAO.PERSONA_ACCESO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.ACCESO.AccesoDAO;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.ESTADO.EstadoDAO;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.PERSONA.PersonaDAO;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO.TipoDAO;
import ACME.MODELO.DAO.VEHICULO.Vehiculo;
import ACME.MODELO.DAO.VEHICULO.VehiculoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Persona_AccesoDAO implements IDAO {

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

    public boolean agregarPersonaAcceso(Object object, Persona guarda, Persona persona, Acceso acceso, Vehiculo vehiculo){

        AccesoDAO aDAO = new AccesoDAO();

        VehiculoDAO vDAO = new VehiculoDAO();

        Persona_Acceso personaAcceso = (Persona_Acceso) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        String sql = "INSERT INTO PERSONA_ACCESO(GUARDA_CEDULA, ACCESO_ID, PERSONA_CEDULA, FECHA, VEHICULO_ID)\n" +
                "VALUES(?, ?, ?, ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setInt(1, guarda.getCedula());
            ps.setInt(3, persona.getCedula());
            ps.setString(4, personaAcceso.getFecha());

            int ID_ACCESO = aDAO.buscarID(acceso);

            if (ID_ACCESO != -1){
                ps.setInt(2, ID_ACCESO);
            }else{
                ps.setInt(2, 1);
            }


            if (vehiculo.getPlaca() == null){
                ps.setString(5, "");
            }else{
                ps.setString(5, vehiculo.getPlaca());
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar acceso de persona " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        return false;
    }
}
