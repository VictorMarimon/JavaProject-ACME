package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ACCESO.AccesoDAO;
import ACME.MODELO.DAO.ESTADO.Estado;
import ACME.MODELO.DAO.TIPO.Tipo;
import ACME.MODELO.DAO.TIPO_ACCESO.Tipo_Acceso;

public class ControladorAcceso extends AccesoDAO {
    public boolean nuevoAcceso(Object object, Tipo_Acceso tipo, Estado estado){
        return agregarAcceso(object, tipo, estado);
    }
}
