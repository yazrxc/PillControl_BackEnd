package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.Especialista;

import java.util.List;

@Repository
public interface IEspecialistaRepository extends JpaRepository<Especialista, Integer> {

    @Query(value = "select e from Especialista e where e.especialidadEspecialista like %:especialidad", nativeQuery = true)
    List<Especialista> buscarEspecialidad(@Param("especialidad") String especialidad);
}
