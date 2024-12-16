package ACME.MODELO.DAO.PAIS;


import java.util.Objects;

public class Pais {
    private String nombre_pais;

    public Pais() {
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre_pais, pais.nombre_pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_pais);
    }
}