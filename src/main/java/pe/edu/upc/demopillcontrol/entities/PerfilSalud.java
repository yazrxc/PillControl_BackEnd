package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name="PerfilSalud")
public class PerfilSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfilSalud;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "gruposanguineo", nullable = false, length = 20)
    private String gruposanguineo;

    @Column(name = "alergias", nullable = false, length = 250)
    private String alergias;

    @Column(name = "condiciones", nullable = false, length = 250)
    private String condiciones;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public PerfilSalud() {}

    public PerfilSalud(int idPerfilSalud, double peso, double altura, String gruposanguineo, String alergias, String condiciones, Usuario usuario) {
        this.idPerfilSalud = idPerfilSalud;
        this.peso = peso;
        this.altura = altura;
        this.gruposanguineo = gruposanguineo;
        this.alergias = alergias;
        this.condiciones = condiciones;
        this.usuario = usuario;
    }

    public int getIdPerfilSalud() {
        return idPerfilSalud;
    }

    public void setIdPerfilSalud(int idPerfilSalud) {
        this.idPerfilSalud = idPerfilSalud;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGruposanguineo() {
        return gruposanguineo;
    }

    public void setGruposanguineo(String gruposanguineo) {
        this.gruposanguineo = gruposanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
