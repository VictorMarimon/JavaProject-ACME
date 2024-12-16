package ACME.CONTROLADOR;

import ACME.MODELO.DAO.DIRECCION.Direccion;
import ACME.MODELO.DAO.EMPRESA.EmpresaDAO;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;

public class ControladorEmpresa extends EmpresaDAO {
    public boolean nuevaEmpresa(Object object, Estado_Empresa estadoEmpresa, Direccion direccion){
        return agregarEmpresa(object, estadoEmpresa, direccion);
    }
}
