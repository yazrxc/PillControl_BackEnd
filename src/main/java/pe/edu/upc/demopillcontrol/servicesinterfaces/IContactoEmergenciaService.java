package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;

import java.util.List;

public interface IContactoEmergenciaService {
    List<ContactoEmergencia> list();

    void insert(ContactoEmergencia c);

    ContactoEmergencia listId(int idContactoEmergencia);

    void update(ContactoEmergencia c);

    void delete(int idContactoEmergencia);

    List<ContactoEmergencia> buscarPorNombrecontacto(@Param("nombre") String nombre);

    List<ContactoEmergencia> buscarPorCorreo(@Param("correo") String correo);

    List<String[]> listarUsuariosConDiagnosticoGraveSinContacto();
}
