package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;

import java.sql.Date;
import java.util.List;

public interface INotificacionRepository extends JpaRepository<Notificacion,Integer> {

    @Query(value ="SELECT *\n" +
            "FROM notificacion\n" +
            "WHERE estado_notificacion = :estado;\n", nativeQuery = true)
    List<Notificacion> getByEstado(@Param("estado") boolean estado);

    @Query(value = "SELECT \n" +
            "    u.nombre,\n" +
            "    n.id_notificacion,\n" +
            "    n.estado_notificacion,\n" +
            "    n.mensaje_notificacion\n" +
            "FROM Usuario u\n" +
            "JOIN Diagnostico d ON u.id_usuario = d.id_usuario\n" +
            "JOIN Receta r ON d.id_diagnostico = r.id_diagnostico AND u.id_usuario = r.id_usuario\n" +
            "JOIN Detalle_Receta dr ON r.id_receta = dr.id_receta\n" +
            "JOIN Notificacion n ON dr.id_detalle_receta = n.id_detalle_receta\n" +
            "WHERE \n" +
            "    u.nombre ILIKE :nombre;", nativeQuery = true)
    public List<NotificacionesPorUsuarioDTO> getNotificacionByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT \n" +
            "    n.id_notificacion,\n" +
            "    n.estado_notificacion,\n" +
            "    n.mensaje_notificacion,\n" +
            "    r.fecha_inicio_receta\n" +
            "FROM notificacion n\n" +
            "JOIN detalle_receta dr ON n.id_detalle_receta = dr.id_detalle_receta\n" +
            "JOIN receta r ON dr.id_receta = r.id_receta\n" +
            "WHERE r.fecha_inicio_receta = :fechaInicio", nativeQuery = true)
    List<Object[]> getNotificacionByFecha(@Param("fechaInicio") Date fechaInicio);

    @Modifying
    @Query("DELETE FROM Notificacion n WHERE n.detallereceta.idDetalleReceta = :idDetalleReceta")
    void deleteByDetalleRecetaId(@Param("idDetalleReceta") Integer idDetalleReceta);
}
