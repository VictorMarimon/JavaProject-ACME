package ACME.CONTROLADOR;

import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_Persona;
import ACME.MODELO.DAO.PERSONA.PersonaDAO;
import ACME.MODELO.DAO.TIPO.Tipo;

public class ControladorPersona extends PersonaDAO {

    public boolean nuevaPersona(Object object, Tipo tipo, Estado_Persona estadoPersona, Direccion direccion){
        return agregarPersona(object, tipo, estadoPersona, direccion);
    }

    public boolean modificarEstadoPersona(Object object, Estado_Persona estadoPersona){
        return modificarEstado(object, estadoPersona);
    }

    public Object[][] reportes(){
        return obtenerDatosReportes();
    }
}
