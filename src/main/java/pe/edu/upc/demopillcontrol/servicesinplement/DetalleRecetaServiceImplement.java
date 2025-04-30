package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.repositories.IDetalleRecetaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDetalleRecetaService;

import java.util.List;

@Service
public class DetalleRecetaServiceImplement implements IDetalleRecetaService {

    @Autowired
    private IDetalleRecetaRepository drR;

    @Override
    public void insert(DetalleReceta dr) {
        drR.save(dr);
    }
    @Override
    public void update(DetalleReceta dr) {
        drR.save(dr);
    }
    @Override
    public void delete(int idDetalleReceta) {
        drR.deleteById(idDetalleReceta);
    }
    @Override
    public List<DetalleReceta> list() {
        return drR.findAll();
    }
}
