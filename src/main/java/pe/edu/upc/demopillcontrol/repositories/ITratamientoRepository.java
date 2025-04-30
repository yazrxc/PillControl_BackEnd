package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demopillcontrol.entities.Tratamiento;

public interface ITratamientoRepository extends JpaRepository<Tratamiento,Integer> {
}
