package ACME.MODELO.DAO.REPORTE_PERSONA;

public class Reporte_Persona {
    private String descripcion;
    private String fecha;

    public Reporte_Persona(){}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
