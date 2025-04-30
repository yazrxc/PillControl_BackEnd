package pe.edu.upc.demopillcontrol.dtos;


public class RolUsuarioDTO {
    private int idrol;
    private String tiporol;
    private String descripcion;

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getTiporol() {
        return tiporol;
    }

    public void setTiporol(String tiporol) {
        this.tiporol = tiporol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
