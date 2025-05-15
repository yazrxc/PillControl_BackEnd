package pe.edu.upc.demopillcontrol.dtos;

public class DosisIntervaloSegunMedicamentoDTO {

        private String nombreMedicamento;
        private int dosisDetalleReceta;
        private int intervaloDetalleReceta;

    public DosisIntervaloSegunMedicamentoDTO(String nombreMedicamento, int dosisDetalleReceta, int intervaloDetalleReceta) {
        this.nombreMedicamento = nombreMedicamento;
        this.dosisDetalleReceta = dosisDetalleReceta;
        this.intervaloDetalleReceta = intervaloDetalleReceta;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getDosisDetalleReceta() {
        return dosisDetalleReceta;
    }

    public void setDosisDetalleReceta(int dosisDetalleReceta) {
        this.dosisDetalleReceta = dosisDetalleReceta;
    }

    public int getIntervaloDetalleReceta() {
        return intervaloDetalleReceta;
    }

    public void setIntervaloDetalleReceta(int intervaloDetalleReceta) {
        this.intervaloDetalleReceta = intervaloDetalleReceta;
    }
}
