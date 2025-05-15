package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Tratamiento;

import java.util.List;

public interface ITratamientoRepository extends JpaRepository<Tratamiento,Integer> {
    @Query(value="SELECT * FROM tratamiento WHERE estado_Tratamiento = :estado", nativeQuery = true)
    List<Tratamiento> listarPorEstado(@Param("estado") String estado);

    @Query(value = "SELECT * FROM tratamiento WHERE id_usuario = :idUsuario", nativeQuery = true)
    List<Tratamiento> listarPorUsuario(@Param("idUsuario") int idUsuario);
    @Query(value = "SELECT t.* FROM tratamiento t INNER JOIN usuario u ON t.id_Usuario = u.id_Usuario WHERE t.estado_Tratamiento = 'activo' AND u.id_Especialista = :idEspecialista", nativeQuery = true)
    List<Tratamiento> listarActivosPorEspecialista(@Param("idEspecialista") int idEspecialista);
}
