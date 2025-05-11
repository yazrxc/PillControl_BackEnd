package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalTime;

public class VerificarHorarioFarmaciaDTO {
    private String nombre;
    private LocalTime horaApertura;
    private LocalTime horarioCierre;

    public VerificarHorarioFarmaciaDTO() {}
    public VerificarHorarioFarmaciaDTO(String nombre, LocalTime horaApertura, LocalTime horarioCierre) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horarioCierre = horarioCierre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }
}
