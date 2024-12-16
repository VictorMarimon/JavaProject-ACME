package ACME.MODELO.DAO.EMPRESA;

public class Empresa {
    private int nit;
    private String empresa;
    private String fecha_asociacion;
    private String telefono;
    private String email;
    private String razon_social;

    public Empresa(){}

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_asociacion() {
        return fecha_asociacion;
    }

    public void setFecha_asociacion(String fecha_asociacion) {
        this.fecha_asociacion = fecha_asociacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
}
