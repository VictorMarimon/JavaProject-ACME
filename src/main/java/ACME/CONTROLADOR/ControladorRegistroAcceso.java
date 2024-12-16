package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ACCESO.Acceso;
import ACME.MODELO.DAO.REGISTRO_ACCESO.Registro_AccesoDAO;

public class ControladorRegistroAcceso extends Registro_AccesoDAO {
    public boolean nuevoAcceso(Object object, Acceso acceso){
        return agregarRegistroAccesoEntrada(object, acceso);
    }
}
