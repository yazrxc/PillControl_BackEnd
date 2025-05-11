package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.util.List;

public interface IDetalleRecetaRepository extends JpaRepository<DetalleReceta,Integer> {

    // Medicamentos por diagnóstico grave
    @Query(value = "SELECT m.nombre AS nombre_medicamento,\n" +
            " m.tipo AS tipo_medicamento,\n" +
            " dr.dosis AS dosis,\n" +
            " d.descripcion AS diagnostico\n" +
            " FROM detalle_receta dr\n" +
            " JOIN receta r ON dr.id_receta = r.id_receta\n" +
            " JOIN diagnostico d ON r.id_diagnostico = d.id_diagnostico\n" +
            " JOIN medicamento m ON dr.id_medicamento = m.id_medicamento\n" +
            " WHERE d.gravedad = 'Alta'\n" +
            " AND r.id_usuario = :idUsuario;", nativeQuery = true)
    public List<Medicamento> getMedicamentosByGravedadDiagnostico(@Param("id_usuario") int id_usuario);

}
