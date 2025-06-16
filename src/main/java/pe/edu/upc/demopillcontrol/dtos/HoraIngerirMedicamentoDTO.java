package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalTime;

public class HoraIngerirMedicamentoDTO {
    private String nombreMedicamento;
    private LocalTime horaDetalleReceta;

    public HoraIngerirMedicamentoDTO(String nombreMedicamento, LocalTime horaDetalleReceta) {
        this.nombreMedicamento = nombreMedicamento;
        this.horaDetalleReceta = horaDetalleReceta;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public LocalTime getHoraDetalleReceta() {
        return horaDetalleReceta;
    }

    public void setHoraDetalleReceta(LocalTime horaDetalleReceta) {
        this.horaDetalleReceta = horaDetalleReceta;
    }
}
