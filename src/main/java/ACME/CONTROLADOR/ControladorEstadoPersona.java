package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ESTADO_PERSONA.Estado_PersonaDAO;

import java.util.List;

public class ControladorEstadoPersona extends Estado_PersonaDAO {
    public List<String> listado(){
        return listarEstados();
    }
}
