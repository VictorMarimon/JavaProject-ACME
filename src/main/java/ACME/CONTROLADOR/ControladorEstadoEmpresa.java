package ACME.CONTROLADOR;

import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_Empresa;
import ACME.MODELO.DAO.ESTADO_EMPRESA.Estado_EmpresaDAO;

import java.util.List;

public class ControladorEstadoEmpresa extends Estado_EmpresaDAO {
    public List<String> listado(){
        return listarEstados();
    }
}
