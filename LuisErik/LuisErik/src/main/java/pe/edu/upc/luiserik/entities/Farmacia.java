package pe.edu.upc.luiserik.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Farmacia")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFarmacia;

    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;

    @Column(name = "direccion",nullable = false,length = 50)
    private String direccion;

    @Column(name = "telefono",nullable = false,length = 9)
    private String telefono;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "horario",nullable = false)
    private LocalTime horario;

    @Column(name = "longitud",nullable = false)
    private Double longitud;

    @Column(name = "latitud",nullable = false)
    private Double latitud;

    public Farmacia() {}

    public Farmacia(Long idFarmacia, String nombre, String direccion, String telefono, LocalTime horario, Double longitud, Double latitud) {
        this.idFarmacia = idFarmacia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Long getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(Long idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
}
