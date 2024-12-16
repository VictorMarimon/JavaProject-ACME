package ACME.CONTROLADOR;

import ACME.MODELO.DAO.CIUDAD.CiudadDAO;

import java.util.List;

public class ControladorCiudad extends CiudadDAO {
    public List<String> listado(){
        return listarCiudades();
    }
}
