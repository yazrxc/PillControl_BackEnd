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

    @Query(value = "SELECT u.id_Usuario, u.nombre, u.edad_Usuario, d.nombre AS diagnostico, d.gravedad,\n" +
            "       ps.alergias, ps.condiciones, ce.nombre AS contacto, ce.telefono\n" +
            "FROM Contacto_Emergencia ce\n" +
            "RIGHT JOIN Usuario u ON ce.id_Usuario = u.id_Usuario\n" +
            "JOIN Perfil_Salud ps ON ps.id_Usuario = u.id_Usuario\n" +
            "JOIN Diagnostico d ON d.id_Usuario = u.id_Usuario\n" +
            "WHERE d.gravedad = 'Alta'\n" +
            "  AND (ps.condiciones IS NOT NULL AND ps.condiciones <> '')\n" +
            "  AND (ce.id_Contacto_Emergencia IS NULL OR ce.telefono IS NULL OR ce.telefono = '')\n" +
            "ORDER BY u.nombre;",nativeQuery = true)
    List<String[]> listarUsuariosConDiagnosticoGraveSinContacto();


}
