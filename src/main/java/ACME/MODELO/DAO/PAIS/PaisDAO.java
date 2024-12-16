package ACME.MODELO.DAO.PAIS;

import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {

        List<Pais> paises = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM PAIS;";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                var pais = new Pais();
                pais.setNombre_pais(rs.getString("nombre_pais"));
                paises.add(pais);
            }

        } catch (Exception e) {
            System.out.println("Hubo un error al listar personas " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }
        List<Object> listaObjetos = new ArrayList<>(paises);
        return listaObjetos;
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





}



