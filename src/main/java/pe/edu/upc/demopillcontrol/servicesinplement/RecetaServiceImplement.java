package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Receta;
import pe.edu.upc.demopillcontrol.repositories.IRecetaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IRecetaService;

import java.util.List;

@Service
public class RecetaServiceImplement implements IRecetaService {

    @Autowired
    private IRecetaRepository reR;

    @Override
    public void insert(Receta r) {
        reR.save(r);
    }
    @Override
    public void update(Receta r) {
        reR.save(r);
    }
    @Override
    public void delete(int idReceta) {
        reR.deleteById(idReceta);
    }
    @Override
    public List<Receta> list() {
        return reR.findAll();
    }
}
