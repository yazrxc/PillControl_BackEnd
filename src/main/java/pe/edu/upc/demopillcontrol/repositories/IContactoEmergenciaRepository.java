package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;

import java.util.List;

@Repository
public interface IContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia, Integer> {

    @Query("SELECT c FROM ContactoEmergencia c WHERE c.nombre LIKE %:nombre%")
    List<ContactoEmergencia> buscarPorNombrecontacto(@Param("nombre") String nombre);

}
