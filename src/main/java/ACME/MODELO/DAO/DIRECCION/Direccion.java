package ACME.MODELO.DAO.DIRECCION;

public class Direccion {
    private String calle;
    private String carrera;
    private String transversal;
    private String diagonal;
    private String numero;

    public Direccion() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTransversal() {
        return transversal;
    }

    public void setTransversal(String transversal) {
        this.transversal = transversal;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
