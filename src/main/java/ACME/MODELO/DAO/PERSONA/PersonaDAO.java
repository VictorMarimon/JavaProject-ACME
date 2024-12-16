package ACME.MODELO.DAO.PERSONA;


import ACME.MODELO.CONEXION.Conexion;
import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.DIRECCION.DireccionDAO;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_EmpresaDAO;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_Persona;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_PersonaDAO;
import ACME.MODELO.DAO.IDAO;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO.TipoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements IDAO {

    private Conexion conexionInst = Conexion.getInstance();

    @Override
    public List<Object> listar() {

        List<Persona> personas = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM persona;";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                var persona = new Persona();
                persona.setCedula(rs.getInt("CEDULA"));
                persona.setPrimer_nombre(rs.getString("PRIMER_NOMBRE"));
                personas.add(persona);
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
        List<Object> listaObjetos = new ArrayList<>(personas);
        return listaObjetos;
    }

    @Override
    public boolean buscar(Object object) {

        Persona persona = (Persona) object;

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT * FROM persona WHERE CEDULA = ?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, persona.getCedula());
            rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar persona por cedula " + e.getMessage());
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
    public boolean agregar(Object object) {return false;}

    @Override
    public boolean modificar(Object object) {

        Persona persona = (Persona) object;

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "UPDATE persona\n" +
                "SET SEGUNDO_NOMBRE = ?\n" +
                "WHERE CEDULA = ?;";

        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, persona.getPrimer_nombre());
            ps.setInt(2, persona.getCedula());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar persona " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

        return false;
    }

    public boolean agregarPersona(Object object, Tipo tipo, Estado_Persona estadoPersona, Direccion direccion){
        Persona persona = (Persona) object;

        TipoDAO tDAO = new TipoDAO();
        DireccionDAO dDAO = new DireccionDAO();

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "INSERT INTO persona(CEDULA, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, EMAIL, TELEFONO, FECHA_NACIMIENTO, GENERO, TIPO_ID, ESRADO_PERSONA_ID, DIRECCION_ID)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1, ?);";

        try{
            ps = con.prepareStatement(sql);

            ps.setInt(1, persona.getCedula());
            ps.setString(2, persona.getPrimer_nombre());
            ps.setString(3, persona.getSegundo_nombre());
            ps.setString(4, persona.getPrimer_apellido());
            ps.setString(5, persona.getSegundo_apellido());
            ps.setString(6, persona.getEmail());
            ps.setString(7, persona.getTelefono());
            ps.setString(8, persona.getFecha_nacimiento());
            ps.setString(9, persona.getGenero());

            var tipoP = tDAO.buscarID(tipo);
            var direccion_id = dDAO.buscarID(direccion);

            if (tipoP != -1){
                ps.setInt(10, tipoP);
            }else{
                ps.setInt(10, 1);
            }

            if (direccion_id != -1){
                ps.setInt(11, direccion_id);
            }else{
                ps.setInt(11, 1);
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

    public boolean modificarEstado(Object object, Estado_Persona estado){

        Persona persona = (Persona) object;

        Estado_PersonaDAO epDAO = new Estado_PersonaDAO();

        PreparedStatement ps;

        Connection con = conexionInst.getConexion();

        var sql = "UPDATE persona\n" +
                "SET ESRADO_PERSONA_ID = ?\n" +
                "WHERE CEDULA = ?;";

        try{
            ps = con.prepareStatement(sql);

            var estadoPersonaP = epDAO.buscarID(estado);

            ps.setInt(2, persona.getCedula());

            if (estadoPersonaP != -1){
                ps.setInt(1, estadoPersonaP);
            }else{
                ps.setInt(1, 1);
            }

            ps.execute();
            System.out.println(ps);
            return true;
        } catch (Exception e) {
            System.out.println("Error al modificar estado persona " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }

        return false;

    }

    public Object[][] obtenerDatosReportes(){

        ArrayList<Object[]> listaDatos = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = conexionInst.getConexion();

        var sql = "SELECT persona.PRIMER_NOMBRE, persona.PRIMER_APELLIDO, persona.TELEFONO, persona.EMAIL, persona.GENERO, estado_persona.ESTADO_PER, cargo.NOMBRE_CARGO, empresa.RAZON_SOCIAL, estado_empresa.ESTADO, persona_acceso.FECHA, registro_acceso.HORA_ENTRADA, registro_acceso.HORA_SALIDA, acceso.COMENTARIOS, vehiculo.PLACA FROM empresa\n" +
                "INNER JOIN empleado\n" +
                "ON empresa.NIT = empleado.EMPRESA_NIT\n" +
                "INNER JOIN cargo\n" +
                "ON empleado.CARGO_ID = cargo.ID\n" +
                "INNER JOIN estado_empresa\n" +
                "ON empresa.ESTADO_EMPRESA_ID = estado_empresa.ID\n" +
                "INNER JOIN persona\n" +
                "ON persona.CEDULA = empleado.PERSONA_CEDULA\n" +
                "INNER JOIN estado_persona\n" +
                "ON persona.ESRADO_PERSONA_ID = estado_persona.ID\n" +
                "INNER JOIN persona_acceso\n" +
                "ON persona.CEDULA = persona_acceso.PERSONA_CEDULA\n" +
                "INNER JOIN vehiculo\n" +
                "ON persona_acceso.VEHICULO_ID = vehiculo.PLACA\n" +
                "INNER JOIN acceso\n" +
                "ON persona_acceso.ACCESO_ID = acceso.ID\n" +
                "INNER JOIN registro_acceso\n" +
                "ON acceso.ID = registro_acceso.ACCESO_ID;";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                listaDatos.add(new Object[]{
                        rs.getString("PRIMER_NOMBRE"),
                        rs.getString("PRIMER_APELLIDO"),
                        rs.getString("TELEFONO"),
                        rs.getString("EMAIL"),
                        rs.getString("GENERO"),
                        rs.getString("ESTADO_PER"),
                        rs.getString("NOMBRE_CARGO"),
                        rs.getString("RAZON_SOCIAL"),
                        rs.getString("ESTADO"),
                        rs.getDate("FECHA"),
                        rs.getTime("HORA_ENTRADA"),
                        rs.getTime("HORA_SALIDA"),
                        rs.getString("COMENTARIOS"),
                        rs.getString("PLACA")
                });
            }

        } catch (Exception e) {
            System.out.println("Error al buscar persona por cedula " + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión " + e.getMessage());
            }
        }


        Object[][] data = new Object[listaDatos.size()][14];
        for (int i = 0; i < listaDatos.size(); i++) {
            data[i] = listaDatos.get(i);
        }

        return data;
    }

    public static void main(String[] args) {
        //AGREGAR

        Direccion d = new Direccion();
        Tipo t = new Tipo();
        Estado_Persona ep = new Estado_Persona();
        Persona p = new Persona();
        Ciudad c = new Ciudad();

        PersonaDAO pDAO = new PersonaDAO();
        DireccionDAO dDAO = new DireccionDAO();

        d.setCalle("1");
        d.setCarrera("1");
        d.setDiagonal("1");
        d.setNumero("1");
        d.setTransversal("1");

        t.setNombre_tipo("Invitado");

        ep.setEstado_per("Inactivo");

        p.setCedula(1);
        p.setEmail("daniel@gmail.com");
        p.setGenero("masculino");
        p.setFecha_nacimiento("2023-01-10");
        p.setPrimer_nombre("daniel");
        p.setPrimer_apellido("martinez");
        p.setSegundo_apellido("cristancho");
        p.setSegundo_nombre("cristian");
        p.setTelefono("321412");

        c.setNombre_ciudad("Tunja");

        //dDAO.agregarDir(d, c);

        pDAO.agregarPersona(p, t,ep,d);

        //MODIFICAR

        pDAO.modificarEstado(p, ep);

        //LISTAR
        System.out.println("Listado persona");
        IDAO personaDAO = new PersonaDAO();

        var pers = personaDAO.listar();

        pers.forEach(System.out::println);

        //BUSCAR

        System.out.println();
        System.out.println("Buscar persona por cedula");

        Persona perss = new Persona();

        perss.setCedula(20321);

        var encontrado = personaDAO.buscar(perss);

        System.out.println(encontrado);


        //MODIFICAR

        System.out.println();
        System.out.println("Modificar persona");

        var modPer = new Persona();

        modPer.setCedula(203);
        modPer.setPrimer_nombre("VALVERDE");

        var mod =  new PersonaDAO().modificar(modPer);

        System.out.println(mod);
    }
}
