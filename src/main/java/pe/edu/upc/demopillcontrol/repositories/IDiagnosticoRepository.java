package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.Diagnostico;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    // Ver diagnóstico por usuario
    @Query(value = "select * from Diagnostico where id_usuario = :id_usuario", nativeQuery = true)
    List<Diagnostico> findDiagnosticosByUsuarioId(@Param("id_usuario") int id_usuario);

    // Buscar diagnóstico por fecha
    public List<Diagnostico> findByFechaEmision(LocalDate fecha);
}
