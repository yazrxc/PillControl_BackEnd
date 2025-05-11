package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Receta;

import java.time.LocalDate;
import java.util.List;

public interface IRecetaRepository extends JpaRepository<Receta,Integer> {
    // Ver recetas por usuario
    @Query(value = "SELECT r FROM Receta r WHERE r.id_usuario = :id_usuario", nativeQuery = true)
    List<Receta> findRecetasByUsuarioId(@Param("id_usuario") int id_usuario);

    // Buscar receta por fecha
    @Query(value = "SELECT r FROM Receta r WHERE r.fecha_inicio_receta = :fecha", nativeQuery = true)
    List<Receta> findByFechaInicioReceta(@Param("fecha_inicio_receta") LocalDate fecha_inicio_receta);

    // ver recetas vencidas
    @Query(value = "SELECT id_receta, fecha_emision\n" +
            " FROM receta\n" +
            " WHERE fecha_fin_receta < CURRENT_DATE\n" +
            " AND id_usuario = :idUsuario;", nativeQuery = true)
    public List<Receta> findRecetaVencidaByUsuarioId(@Param("idUsuario") int idUsuario);
}
