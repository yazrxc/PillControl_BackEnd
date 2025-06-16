package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;

import java.sql.Date;
import java.util.List;

public interface INotificacionService {
    public List<Notificacion> list();
    public void insert(Notificacion n);
    //public Notificacion listId(int idNotificacion);
    public void update(Notificacion n);
    public void delete(int idNotificacion);

    public List<Notificacion> getbyEstado(Boolean estado);
    public List<NotificacionesPorUsuarioDTO> getNotificacionByNombre(String nombre);
    public List<NotificacionPorFechaDTO> getNotificacionByFecha(Date fechaInicioReceta);
}
