package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;

public interface IDetalleRecetaRepository extends JpaRepository<DetalleReceta,Integer> {
}
