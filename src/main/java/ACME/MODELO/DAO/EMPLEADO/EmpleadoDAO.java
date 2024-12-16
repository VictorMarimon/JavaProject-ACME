package ACME.MODELO.DAO.EMPLEADO;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.CARGO.Cargo;
import ACME.MODELO.DAO.CARGO.CargoDAO;
import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.CIUDAD.CiudadDAO;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.PERSONA.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoDAO implements IDAO {

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

    public boolean agregarEmpleado(Persona persona, Empresa empresa, Cargo cargo){

        CargoDAO cDAO = new CargoDAO();

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        String sql = "INSERT INTO empleado(PERSONA_CEDULA, EMPRESA_NIT, CARGO_ID)\n" +
                "VALUES(?,?,?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setInt(1, persona.getCedula());
            ps.setInt(2, empresa.getNit());

            int ID_CARGO = cDAO.buscarID(cargo);

            if (ID_CARGO != -1){
                ps.setInt(3, ID_CARGO);
            }else{
                ps.setInt(3, 1);
            }

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al agregar empleado " + e.getMessage());
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
