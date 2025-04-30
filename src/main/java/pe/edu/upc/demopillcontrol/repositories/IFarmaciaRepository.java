package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demopillcontrol.entities.Farmacia;

public interface IFarmaciaRepository extends JpaRepository<Farmacia,Integer> {
}
