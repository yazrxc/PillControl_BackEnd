package pe.edu.upc.demopillcontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "RolUsuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUsuario", "tiporol"})})
public class RolUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;

    @Column(name = "tiporol",nullable = false,length = 20)
    private String tiporol;

    @Column(name = "descripcion",nullable = false,length = 250)
    private String descripcion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
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
