package ACME.CONTROLADOR;

import ACME.MODELO.DAO.CIUDAD.Ciudad;
import ACME.MODELO.DAO.DIRECCION.DireccionDAO;

public class ControladorDireccion extends DireccionDAO {
    public boolean agregarDireccion(Object object, Ciudad ciudad){
        return agregarDir(object, ciudad);
    }
}
