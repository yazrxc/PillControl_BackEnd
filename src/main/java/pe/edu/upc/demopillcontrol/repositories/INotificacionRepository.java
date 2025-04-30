package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demopillcontrol.entities.Notificacion;

public interface INotificacionRepository extends JpaRepository<Notificacion,Integer> {
}
