package ACME.MODELO.DAO.ESTADO_PERSONA;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.PERSONA.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estado_PersonaDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Estado_Persona estadoPersona = (Estado_Persona) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM estado_persona WHERE ESTADO_PER = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estadoPersona.getEstado_per());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar estado persona por estado " + e.getMessage());
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
        Estado_Persona estadoPersona = (Estado_Persona) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM estado_persona WHERE ESTADO_PER = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estadoPersona.getEstado_per());
            rs = ps.executeQuery();

            if (rs.next()){
                ID = rs.getInt("ID");
                return ID;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar id estado persona por estado " + e.getMessage());
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

    public List<String> listarEstados() {
        List<String> estados = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ESTADO_PER FROM estado_persona;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                estados.add(rs.getString("ESTADO_PER"));
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al listar estados personas: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return estados;
    }
}
