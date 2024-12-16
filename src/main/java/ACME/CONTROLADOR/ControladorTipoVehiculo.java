package ACME.CONTROLADOR;

import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_VehiculoDAO;

import java.util.List;

public class ControladorTipoVehiculo extends Tipo_VehiculoDAO {
    public List<String> listadoVehiculos(){
        return listarVehiculos();
    }
}
