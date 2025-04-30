package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MedicamentoFarmacia")
public class MedicamentoFarmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmedicamentoFarmacia;

    @Column(name = "cantidadMedicamentoFarmacia", nullable = false)
    private int cantidadMedicamentoFarmacia;
    @Column(name = "tipoVentaMedicamentoFarmacia", nullable = false, length = 20)
    private String tipoVentaMedicamentoFarmacia;
    @Column(name = "precioMedicamentoFarmacia", nullable = false)
    private Double precioMedicamentoFarmacia;
    @Column(name = "laboratorioMedicamentoFarmacia", nullable = false, length = 250)
    private String laboratorioMedicamentoFarmacia;

    @ManyToOne
    @JoinColumn(name = "idMedicamento")
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "idFarmacia")
    private Farmacia farmacia;

    public MedicamentoFarmacia() {
    }

    public MedicamentoFarmacia(int idmedicamentoFarmacia, int cantidadMedicamentoFarmacia, String tipoVentaMedicamentoFarmacia, Double precioMedicamentoFarmacia, String laboratorioMedicamentoFarmacia, Medicamento medicamento, Farmacia farmacia) {
        this.idmedicamentoFarmacia = idmedicamentoFarmacia;
        this.cantidadMedicamentoFarmacia = cantidadMedicamentoFarmacia;
        this.tipoVentaMedicamentoFarmacia = tipoVentaMedicamentoFarmacia;
        this.precioMedicamentoFarmacia = precioMedicamentoFarmacia;
        this.laboratorioMedicamentoFarmacia = laboratorioMedicamentoFarmacia;
        this.medicamento = medicamento;
        this.farmacia = farmacia;
    }

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
