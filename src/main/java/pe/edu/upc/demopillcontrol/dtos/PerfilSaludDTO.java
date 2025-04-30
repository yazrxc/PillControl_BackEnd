package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.Usuario;

public class PerfilSaludDTO {

    private int idPerfilSalud;
    private double peso;
    private double altura;
    private String gruposanguineo;
    private String alergias;
    private String condiciones;
    private Usuario usuario;

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
