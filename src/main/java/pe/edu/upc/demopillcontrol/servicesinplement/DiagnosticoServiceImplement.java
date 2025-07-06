package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Diagnostico;
import pe.edu.upc.demopillcontrol.repositories.IDiagnosticoRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDiagnosticoService;

import java.time.LocalDate;
import java.util.List;
@Service
public class DiagnosticoServiceImplement implements IDiagnosticoService {

    @Autowired
    private IDiagnosticoRepository dR;


    @Override
    public void registrar(Diagnostico d) {
        dR.save(d);
    }

    @Override
    public void modificar(Diagnostico d) {
        dR.save(d);
    }

    @Override
    public void eliminar(int idDiagnostico) {
        dR.deleteById(idDiagnostico);
    }

    @Override
    public Diagnostico listarporID(int id) {
        return dR.findById(id).orElse(new Diagnostico());
    }

    @Override
    public List<Diagnostico> listar() {
        return dR.findAll();
    }

    @Override
    public List<Diagnostico> findDiagnosticosByUsuarioId(int id_usuario) {
        return dR.findDiagnosticosByUsuarioId(id_usuario);
    }

    @Override
    public List<Diagnostico> findByFechaEmision(LocalDate fecha) {
        return dR.findByFechaEmision(fecha);
    }
}

