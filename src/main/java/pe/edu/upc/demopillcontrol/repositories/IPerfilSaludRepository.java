package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;

@Repository
public interface IPerfilSaludRepository extends JpaRepository<PerfilSalud, Integer> {
}
