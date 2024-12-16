package ACME.CONTROLADOR;

import ACME.MODELO.DAO.CARGO.Cargo;
import ACME.MODELO.DAO.EMPLEADO.EmpleadoDAO;
import ACME.MODELO.DAO.EMPRESA.Empresa;
import ACME.MODELO.DAO.PERSONA.Persona;

public class ControladorEmpleado extends EmpleadoDAO {
    public boolean nuevoEmpleado(Persona persona, Empresa empresa, Cargo cargo){
        return agregarEmpleado(persona, empresa, cargo);
    }
}
