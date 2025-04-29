package pe.edu.upc.luiserik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.luiserik.entities.Farmacia;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia,Long> {
}
