package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ACCESO.AccesoDAO;
import ACME.MODELO.DAO.ESTADO.EstadoDAO;

import java.util.List;

public class ControladorEstadoAcceso extends EstadoDAO {
    public List<String> listado(){
        return listarEstados();
    }
}
