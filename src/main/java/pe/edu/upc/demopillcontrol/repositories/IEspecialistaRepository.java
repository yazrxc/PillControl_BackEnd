package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.Especialista;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {
}
