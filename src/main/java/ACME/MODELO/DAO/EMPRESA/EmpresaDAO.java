package ACME.MODELO.DAO.EMPRESA;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.DIRECCION.DireccionDAO;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_EmpresaDAO;
import ACME.MODELO.DAO.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpresaDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        Empresa empresa = (Empresa) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM EMPRESA WHERE NIT = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, empresa.getNit());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar empresa por nit " + e.getMessage());
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

    public boolean agregarEmpresa(Object object, Estado_Empresa estadoEmpresa, Direccion direccion){
        Empresa empresa = (Empresa) object;

        Estado_EmpresaDAO eeDAO = new Estado_EmpresaDAO();

        DireccionDAO dDAO = new DireccionDAO();

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "INSERT INTO EMPRESA(NIT, EMPRESA, FECHA_ASOCIACION, TELEFONO, EMAIL, RAZON_SOCIAL, ESTADO_EMPRESA_ID, DIRECCION_ID)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setInt(1, empresa.getNit());
            ps.setString(2, empresa.getEmpresa());
            ps.setString(3, empresa.getFecha_asociacion());
            ps.setString(4, empresa.getTelefono());
            ps.setString(5, empresa.getEmail());
            ps.setString(6, empresa.getRazon_social());

            var estado_empresa_id = eeDAO.buscarID(estadoEmpresa);
            var direccion_id = dDAO.buscarID(direccion);

            if (estado_empresa_id != -1){
                ps.setInt(7, estado_empresa_id);
            }else{
                ps.setInt(7, 1);
            }

            if (direccion_id != -1){
                ps.setInt(8, direccion_id);
            }else{
                ps.setInt(8, 1);
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar empresa " + e.getMessage());
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

        // AGREGAR
        Estado_Empresa ee = new Estado_Empresa();
        Direccion d = new Direccion();
        Empresa e = new Empresa();

        ee.setEstado("Inactiva");

        d.setCalle("1");
        d.setDiagonal("1");
        d.setCarrera("1");
        d.setTransversal("1");
        d.setNumero("1");

        e.setEmpresa("Campus");
        e.setEmail("campus@gmail.com");
        e.setNit(1239);
        e.setTelefono("32194123");
        e.setRazon_social("nada");
        e.setFecha_asociacion("2023-01-10");

        EmpresaDAO eDAO = new EmpresaDAO();

        eDAO.agregarEmpresa(e, ee, d);
    }
}
