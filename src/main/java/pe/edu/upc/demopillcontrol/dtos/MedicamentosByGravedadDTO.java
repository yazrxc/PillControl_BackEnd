package pe.edu.upc.demopillcontrol.dtos;

public class MedicamentosByGravedadDTO {

    private String nombreMedicamento;
    private String tipoMedicamento;
    private double dosis;
    private int idMedicamento;

    public MedicamentosByGravedadDTO(String nombreMedicamento, String tipoMedicamento, double dosis, int idMedicamento, String nombreDiagnostico) {
        this.nombreMedicamento = nombreMedicamento;
        this.tipoMedicamento = tipoMedicamento;
        this.dosis = dosis;
        this.idMedicamento = idMedicamento;
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    private String nombreDiagnostico;

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }
}
