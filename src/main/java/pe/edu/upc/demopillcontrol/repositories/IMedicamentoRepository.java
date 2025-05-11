package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.util.List;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    // listar por nombre
    @Query("select m from Medicamento m where m.nombre like %:nombre")
    public List<Medicamento> listarPorNombre(@Param("nombre") String nombre);

    // listar por presentacion
    @Query("select m from Medicamento m where m.presentacion like %:presentacion")
    public List<Medicamento> listarPorPresentacion(@Param("presentacion") String presentacion);

    // Medicamentos por diagnóstico grave
    @Query(value = "SELECT new com.telanova.dto.MedicamentoDiagnosticoDTO(\" +\n" +
            "           \"m.nombre, m.tipo_medicamento, m.dosis, d.nombre) \" +\n" +
            "           \"FROM DetalleReceta dr \" +\n" +
            "           \"JOIN dr.receta r \" +\n" +
            "           \"JOIN r.diagnostico d \" +\n" +
            "           \"JOIN dr.medicamento m \" +\n" +
            "           \"WHERE r.usuario.idUsuario = :id_Usuario AND d.gravedad = 'Alta'", nativeQuery = true)
    public List<Medicamento> getMedicamentosByGravedadDiagnostico(@Param("id_usuario") int id_usuario);
}
