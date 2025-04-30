package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTratamiento;
    @Column(name ="indicacionesTratamiento" ,nullable = false,length = 250)
    private String indicacionesTratamiento;
    @Column(name ="objetivoTratamiento" ,nullable = false,length = 250)
    private String objetivoTratamiento;
    @Column(name ="estadoTratamiento" ,nullable = false,length = 20)
    private String estadoTratamiento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idDiagnostico")
    private Diagnostico diagnostico;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String indicacionesTratamiento, String objetivoTratamiento, String estadoTratamiento, Usuario usuario, Diagnostico diagnostico) {
        this.idTratamiento = idTratamiento;
        this.indicacionesTratamiento = indicacionesTratamiento;
        this.objetivoTratamiento = objetivoTratamiento;
        this.estadoTratamiento = estadoTratamiento;
        this.usuario = usuario;
        this.diagnostico = diagnostico;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getIndicacionesTratamiento() {
        return indicacionesTratamiento;
    }

    public void setIndicacionesTratamiento(String indicacionesTratamiento) {
        this.indicacionesTratamiento = indicacionesTratamiento;
    }

    public String getObjetivoTratamiento() {
        return objetivoTratamiento;
    }

    public void setObjetivoTratamiento(String objetivoTratamiento) {
        this.objetivoTratamiento = objetivoTratamiento;
    }

    public String getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(String estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
