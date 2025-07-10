package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.dtos.DetalleRecetaSegunUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.util.List;

public interface IDetalleRecetaRepository extends JpaRepository<DetalleReceta,Integer> {

    @Query(value = "SELECT \n" +
            "    m.nombre AS nombre_medicamento,\n" +
            "    dr.hora_detalle_receta\n" +
            "FROM \n" +
            "    detalle_receta dr\n" +
            "JOIN \n" +
            "    medicamento m ON dr.id_medicamento = m.id_medicamento;\n", nativeQuery = true)
    List<Object[]> getNombreYHoraMedicamento();

    @Query(value = "SELECT \n" +
            "    m.nombre AS nombre_medicamento,\n" +
            "    dr.dosis_detalle_receta,\n" +
            "    dr.intervalo_detalle_receta\n" +
            "FROM \n" +
            "    detalle_receta dr\n" +
            "JOIN \n" +
            "    medicamento m ON dr.id_medicamento = m.id_medicamento;\n", nativeQuery = true)
    List<Object[]> getDosisEIntervalobyMedicamento();

    // Medicamentos por diagnóstico grave
    @Query(value = "SELECT m.nombre AS nombreMedicamento,\n" +
            " m.tipo_medicamento AS tipoMedicamento,\n" +
            " d.nombre AS nombreDiagnostico\n" +
            " FROM detalle_receta dr\n" +
            " JOIN receta r ON dr.id_receta = r.id_receta\n" +
            " JOIN diagnostico d ON r.id_diagnostico = d.id_diagnostico\n" +
            " JOIN medicamento m ON dr.id_medicamento = m.id_medicamento\n" +
            " WHERE d.gravedad = 'Alta'\n" +
            " AND r.id_usuario = :id_usuario", nativeQuery = true)
    public List<String[]> getMedicamentosByGravedadDiagnostico(@Param("id_usuario") int id_usuario);

    //Detalles de las recetas ingresadas según el usuario
    @Query(value = "SELECT \n" +
            "    dr.id_detalle_receta,\n" +
            "    dr.id_receta,\n" +
            "    dr.id_medicamento,\n" +
            "    dr.dosis_detalle_receta,\n" +
            "    dr.hora_detalle_receta,\n" +
            "    dr.intervalo_detalle_receta,\n" +
            "    dr.frecuencia_detalle_receta\n" +
            "FROM usuario u\n" +
            "JOIN diagnostico d ON u.id_usuario = d.id_usuario\n" +
            "JOIN receta r ON d.id_diagnostico = r.id_diagnostico\n" +
            "JOIN detalle_receta dr ON r.id_receta = dr.id_receta\n" +
            "WHERE u.id_usuario = :idUsuario\n" +
            "   OR u.nombre ILIKE :nombre;", nativeQuery = true)
    public List<DetalleRecetaSegunUsuarioDTO> getDetalleRecetaByUsuario(@Param("idUsuario") int idUsuario, @Param("nombre") String nombre);
}
