package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalTime;

public class QueryFarmaciaHorarioDTO {
    //Listar farmacias que tienen un horario registrado anterior a las 9:00 a.m.
    private String nombre;
    private String direccion;
    private LocalTime horario;

    public QueryFarmaciaHorarioDTO() {}
    public QueryFarmaciaHorarioDTO(String nombre, String direccion, LocalTime horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
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

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
