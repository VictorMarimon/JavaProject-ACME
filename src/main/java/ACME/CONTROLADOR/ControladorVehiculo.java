package ACME.CONTROLADOR;

import ACME.MODELO.DAO.TIPO_VEHICULO.Tipo_Vehiculo;
import ACME.MODELO.DAO.VEHICULO.VehiculoDAO;

import java.util.List;

public class ControladorVehiculo extends VehiculoDAO {
    public boolean nuevoVehiculo(Object object, Tipo_Vehiculo tipo_vehiculo){
        return agregarVehiculo(object, tipo_vehiculo);
    }

    public boolean confirmar(Object object){
        return buscar(object);
    }
}
