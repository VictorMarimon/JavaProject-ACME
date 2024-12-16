package ACME.MODELO.DAO.REPORTE_PERSONA;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.DIRECCION.DireccionDAO;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_EmpresaDAO;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.PERSONA.PersonaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Reporte_PersonaDAO implements IDAO {

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

    public boolean agregarReportePersona(Object object, Persona persona, Persona guarda){
        Reporte_Persona reportePersona = (Reporte_Persona) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "INSERT INTO REPORTE_PERSONA(DESCRIPCION, FECHA, PERSONA_CEDULA, GUARDA_CEDULA)\n" +
                "VALUES(?, NOW(), ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, reportePersona.getDescripcion());
            ps.setInt(2, persona.getCedula());
            ps.setInt(3, guarda.getCedula());

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar reporte de persona " + e.getMessage());
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
