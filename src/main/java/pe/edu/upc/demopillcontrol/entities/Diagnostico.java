package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "gravedad", nullable = false, length = 20)
    private String gravedad;

    @Column(name = "fechaEmision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Diagnostico() {
    }

    public Diagnostico(int idDiagnostico, String nombre, String gravedad, LocalDate fechaEmision, String descripcion, Usuario idUsuario) {
        this.idDiagnostico = idDiagnostico;
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
