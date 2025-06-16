package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Receta;

import java.time.LocalDate;
import java.util.List;

public interface IRecetaRepository extends JpaRepository<Receta,Integer> {
    // Ver recetas por usuario
    @Query("SELECT r FROM Receta r WHERE r.usuario.idUsuario = :id_usuario")
    List<Receta> findRecetasByUsuarioId(@Param("id_usuario") int id_usuario);

    // Buscar receta por fecha
    @Query("SELECT r FROM Receta r WHERE r.fechaInicioReceta = :fecha")
    List<Receta> findByFechaInicioReceta(@Param("fecha") LocalDate fecha);

    // ver recetas vencidas
    @Query(value = "SELECT *\n" +
            " FROM receta\n" +
            " WHERE fecha_fin_receta < CURRENT_DATE\n" +
            " AND id_usuario = :idUsuario;", nativeQuery = true)
    public List<Receta> findRecetaVencidaByUsuarioId(@Param("idUsuario") int idUsuario);
}
