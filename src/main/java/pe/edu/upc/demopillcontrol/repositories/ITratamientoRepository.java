package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Tratamiento;

import java.util.List;

public interface ITratamientoRepository extends JpaRepository<Tratamiento,Integer> {
    @Query(value="SELECT t FROM Tratamiento t WHERE t.estadoTratamiento = :estado", nativeQuery = true)
    List<Tratamiento> listarPorEstado(@Param("estado") String estado);

    @Query(value = "SELECT t FROM Tratamiento t WHERE t.usuario.idusuario = :idUsuario", nativeQuery = true)
    List<Tratamiento> listarPorUsuario(@Param("idUsuario") int idUsuario);
}
