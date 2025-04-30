package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "RolUsuario")
public class RolUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;

    @Column(name = "tiporol",nullable = false,length = 20)
    private String tiporol;

    @Column(name = "descripcion",nullable = false,length = 250)
    private String descripcion;

    public RolUsuario() {
    }

    public RolUsuario(int idrol, String tiporol, String descripcion) {
        this.idrol = idrol;
        this.tiporol = tiporol;
        this.descripcion = descripcion;
    }

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
