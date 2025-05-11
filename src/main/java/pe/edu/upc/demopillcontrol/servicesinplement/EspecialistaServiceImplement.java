package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Especialista;
import pe.edu.upc.demopillcontrol.repositories.IEspecialistaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IEspecialistaService;

import java.util.List;

@Service
public class EspecialistaServiceImplement implements IEspecialistaService {

    @Autowired
    private IEspecialistaRepository eR;

    @Override
    public List<Especialista> list() {
        return eR.findAll();
    }

    @Override
    public Especialista listarId(int idEspecialista) {
        return eR.findById(idEspecialista).orElse(new Especialista());
    }

    @Override
    public void insert(Especialista e) {
        eR.save(e);
    }

    @Override
    public void update(Especialista e) {
        eR.save(e);
    }

    @Override
    public void delete(int idEspecialista) {
        eR.deleteById(idEspecialista);
    }

    @Override
    public List<Especialista> buscarEspecialidad(String especialidadEspecialista) {
        return eR.buscarEspecialidad(especialidadEspecialista);
    }
}
