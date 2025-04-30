package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;

import java.util.List;

public interface IMedicamentoFarmaciaService {
    public List<MedicamentoFarmacia> list();
    public void insert(MedicamentoFarmacia mf);
    //public MedicamentoFarmacia listId(int idmedicamentoFarmacia);
    public void update(MedicamentoFarmacia mf);
    public void delete(int idmedicamentoFarmacia);
    //public List<MedicamentoFarmacia> buscarPorCantidad(int cantidadMedicamentoFarmacia);
}
