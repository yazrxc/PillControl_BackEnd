package pe.edu.upc.phill_control.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol_Usuario")
public class Rol_Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "tipo_rol",nullable = false,length = 40)
    private String tipo_rol;

    @Column(name = "descripcion",nullable = false,length = 250)
    private String descripcion;

    public Rol_Usuario() {
    }

    public Rol_Usuario(int idRol, String tipo_rol, String descripcion){
        this.idRol = idRol;
        this.tipo_rol = tipo_rol;
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
