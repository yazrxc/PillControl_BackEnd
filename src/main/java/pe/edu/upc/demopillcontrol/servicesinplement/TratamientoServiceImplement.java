package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Tratamiento;
import pe.edu.upc.demopillcontrol.repositories.ITratamientoRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.ITratamientoService;

import java.util.List;

@Service
public class TratamientoServiceImplement implements ITratamientoService {

    @Autowired
    private ITratamientoRepository tR;

    @Override
    public void insert(Tratamiento t) {
        tR.save(t);
    }
    @Override
    public void update(Tratamiento t) {
        tR.save(t);
    }
    @Override
    public void delete(int idTratamiento) {
        tR.deleteById(idTratamiento);
    }

    @Override
    public List<Tratamiento> listarPorEstado(String estadoTratamiento) {
        return tR.listarPorEstado(estadoTratamiento);
    }

    @Override
    public List<Tratamiento> listarPorUsuario(int idUsuario) {
        return List.of();
    }

    @Override
    public List<Tratamiento> list() {
        return tR.findAll();
    }

    @Override
    public Tratamiento listarId(int idTratamiento) {
        return tR.findById(idTratamiento).orElse(new Tratamiento());
    }
}
