package ACME.MODELO.DAO.ESTADO_EMPRESA;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Estado_EmpresaDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Estado_Empresa estadoEmpresa = (Estado_Empresa) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM ESTADO_EMPRESA WHERE ESTADO = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estadoEmpresa.getEstado());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar estado empresa por estado " + e.getMessage());
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
        Estado_Empresa estadoEmpresa = (Estado_Empresa) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ID FROM ESTADO_EMPRESA WHERE ESTADO = ?";

        int ID;

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, estadoEmpresa.getEstado());
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

    public List<String> listarEstados() {
        List<String> estados = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT ESTADO FROM ESTADO_EMPRESA;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                estados.add(rs.getString("ESTADO"));
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al listar estados empresas: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return estados;
    }

    public static void main(String[] args) {
        Estado_Empresa emp = new Estado_Empresa();

        Estado_EmpresaDAO d = new Estado_EmpresaDAO();

        emp.setEstado("Cerrada");

        System.out.println(d.buscarID(emp));
    }
}
