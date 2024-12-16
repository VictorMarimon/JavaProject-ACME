package ACME.CONTROLADOR;

import ACME.MODELO.DAO.PERSONA.Persona;
import ACME.MODELO.DAO.REPORTE_PERSONA.Reporte_PersonaDAO;

public class ControladorReportePersona extends Reporte_PersonaDAO {
    public boolean reportarPersona(Object object, Persona persona, Persona guarda){
        return agregarReportePersona(object, persona, guarda);
    }
}
