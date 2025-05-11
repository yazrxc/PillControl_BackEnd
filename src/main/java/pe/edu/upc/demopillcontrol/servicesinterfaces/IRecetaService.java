package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Receta;

import java.time.LocalDate;
import java.util.List;

public interface IRecetaService {
    public List<Receta> list();
    public void insert(Receta r);
    public Receta findById(int idReceta);
    public void update(Receta r);
    public void delete(int idReceta);

    List<Receta> findRecetasByUsuarioId(int id_usuario);
    List<Receta> findByFechaInicioReceta(LocalDate fecha_inicio_receta);

    // Q06: Ver recetas vencidas de un usuario
    public List<Receta> findRecetaVencidaByUsuarioId(@Param("idUsuario") int idUsuario);
}
