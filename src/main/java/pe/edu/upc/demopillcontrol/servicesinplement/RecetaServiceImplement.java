package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Receta;
import pe.edu.upc.demopillcontrol.repositories.IRecetaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IRecetaService;

import java.time.LocalDate;
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
    public Receta findById(int idReceta) {
        return reR.findById(idReceta).orElse(new Receta());
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
    public List<Receta> findRecetasByUsuarioId(int id_usuario) {
        return reR.findRecetasByUsuarioId(id_usuario);
    }

    @Override
    public List<Receta> findByFechaInicioReceta(LocalDate fecha_inicio_receta) {
        return reR.findByFechaInicioReceta(fecha_inicio_receta);
    }

    @Override
    public List<Receta> findRecetaVencidaByUsuarioId(int idUsuario) {
        return reR.findRecetaVencidaByUsuarioId(idUsuario);
    }

    @Override
    public List<Receta> list() {
        return reR.findAll();
    }
}
