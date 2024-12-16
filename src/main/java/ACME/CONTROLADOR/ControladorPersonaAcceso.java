package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.PERSONA_ACCESO.Persona_AccesoDAO;
import ACME.MODELO.DAO.VEHICULO.Vehiculo;

public class ControladorPersonaAcceso extends Persona_AccesoDAO {
    public boolean nuevoAcceso(Object object, Persona guarda, Persona persona, Acceso acceso, Vehiculo vehiculo){
        return agregarPersonaAcceso(object, guarda, persona, acceso, vehiculo);
    }
}
