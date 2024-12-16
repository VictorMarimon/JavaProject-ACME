package ACME.MODELO.DAO;

import java.util.List;

public interface IDAO {

    List<Object> listar();

    boolean buscar(Object object);

    boolean agregar(Object object);

    boolean modificar(Object object);

}
