package pe.edu.upc.demopillcontrol.dtos;


import pe.edu.upc.demopillcontrol.entities.Usuario;

public class RolUsuarioDTO {
    private int idrol;
    private String tiporol;
    private String descripcion;
    private Usuario user;

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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
