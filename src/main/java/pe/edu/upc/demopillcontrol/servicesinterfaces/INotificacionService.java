package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    public List<Notificacion> list();
    public void insert(Notificacion n);
    //public Notificacion listId(int idNotificacion);
    public void update(Notificacion n);
    public void delete(int idNotificacion);
    //public List<Notificacion> buscarPorDetalleReceta(int idDetalleReceta);
    public List<NotificacionesPorUsuarioDTO> getNotificacionByNombre(String nombre);
}
