package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;

import java.sql.Date;
import java.util.List;

public interface INotificacionService {
    public List<NotificacionDTO> list();
    public void insert(Notificacion n);
    public Notificacion listarPorId(int idNotificacion);
    public void update(Notificacion n);
    public void delete(int idNotificacion);
    void deleteByDetalleRecetaId(Integer idDetalleReceta);

    public List<Notificacion> getbyEstado(boolean estado);
    public List<NotificacionesPorUsuarioDTO> getNotificacionByNombre(String nombre);
    public List<NotificacionPorFechaDTO> getNotificacionByFecha(Date fechaInicioReceta);
}
