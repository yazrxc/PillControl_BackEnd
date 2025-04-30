package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.Farmacia;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

public class MedicamentoFarmaciaDTO {

    private int idmedicamentoFarmacia;
    private int cantidadMedicamentoFarmacia;
    private String tipoVentaMedicamentoFarmacia;
    private Double precioMedicamentoFarmacia;
    private String laboratorioMedicamentoFarmacia;
    private Medicamento medicamento;
    private Farmacia farmacia;

    public int getIdmedicamentoFarmacia() {
        return idmedicamentoFarmacia;
    }

    public void setIdmedicamentoFarmacia(int idMedicamentoFarmacia) {
        this.idmedicamentoFarmacia = idMedicamentoFarmacia;
    }

    public int getCantidadMedicamentoFarmacia() {
        return cantidadMedicamentoFarmacia;
    }

    public void setCantidadMedicamentoFarmacia(int cantidadMedicamentoFarmacia) {
        this.cantidadMedicamentoFarmacia = cantidadMedicamentoFarmacia;
    }

    public String getTipoVentaMedicamentoFarmacia() {
        return tipoVentaMedicamentoFarmacia;
    }

    public void setTipoVentaMedicamentoFarmacia(String tipoVentaMedicamentoFarmacia) {
        this.tipoVentaMedicamentoFarmacia = tipoVentaMedicamentoFarmacia;
    }

    public Double getPrecioMedicamentoFarmacia() {
        return precioMedicamentoFarmacia;
    }

    public void setPrecioMedicamentoFarmacia(Double precioMedicamentoFarmacia) {
        this.precioMedicamentoFarmacia = precioMedicamentoFarmacia;
    }

    public String getLaboratorioMedicamentoFarmacia() {
        return laboratorioMedicamentoFarmacia;
    }

    public void setLaboratorioMedicamentoFarmacia(String laboratorioMedicamentoFarmacia) {
        this.laboratorioMedicamentoFarmacia = laboratorioMedicamentoFarmacia;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
}
