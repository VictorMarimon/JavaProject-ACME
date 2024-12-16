package ACME.MODELO.DAO.REPORTE_PERSONA_ACC;

import ACME.MODELO.DAO.IDAO;

import java.util.List;

public class Reporte_Persona_AccDAO implements IDAO {
    @Override
    public List<Object> listar() {
        return List.of();
    }

    @Override
    public boolean buscar(Object object) {
        return false;
    }

    @Override
    public boolean agregar(Object object) {
        return false;
    }

    @Override
    public boolean modificar(Object object) {
        return false;
    }
}
