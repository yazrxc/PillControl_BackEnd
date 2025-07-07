package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaStockEconomicoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryMedicamentoPorTipoVentaDTO;
import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;
import pe.edu.upc.demopillcontrol.repositories.IMedicamentoFarmaciaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IMedicamentoFarmaciaService;

import java.util.List;

@Service
public class MedicamentoFarmaciaServiceImplement implements IMedicamentoFarmaciaService {

    @Autowired
    private IMedicamentoFarmaciaRepository mfR;

    @Override
    public void insert(MedicamentoFarmacia mf) {
        mfR.save(mf);
    }
    @Override
    public void update(MedicamentoFarmacia mf) {
        mfR.save(mf);
    }
    @Override
    public void delete(int idmedicamentoFarmacia) {
        mfR.deleteById(idmedicamentoFarmacia);
    }
    @Override
    public List<MedicamentoFarmacia> list() {
        return mfR.findAll();
    }

    @Override
    public MedicamentoFarmacia listId(int idmedicamentoFarmacia) {
        return mfR.findById(idmedicamentoFarmacia).orElse(new MedicamentoFarmacia());
    }

    @Override
    public List<QueryMedicamentoPorTipoVentaDTO> obtenerCantidadPorTipoVenta() {
        return mfR.obtenerCantidadPorTipoVenta();
    }

    @Override
    public List<QueryFarmaciaMedicamentoDTO> obtenerMedicamentosPorFarmacia() {
        return mfR.obtenerMedicamentosPorFarmacia();
    }

    @Override
    public List<QueryFarmaciaStockEconomicoDTO> obtenerFarmaciasConStockEconomico(Long minCantidad, Double maxPrecio) {
        return mfR.obtenerFarmaciasConStockEconomico(minCantidad, maxPrecio);
    }
}
