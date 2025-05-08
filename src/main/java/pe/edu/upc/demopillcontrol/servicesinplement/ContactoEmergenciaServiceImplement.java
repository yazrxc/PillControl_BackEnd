package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;

import pe.edu.upc.demopillcontrol.repositories.IContactoEmergenciaRepository;

import pe.edu.upc.demopillcontrol.servicesinterfaces.IContactoEmergenciaService;

import java.util.List;

@Service
public class ContactoEmergenciaServiceImplement implements IContactoEmergenciaService {

    @Autowired
    private IContactoEmergenciaRepository cR;

    @Override
    public List<ContactoEmergencia> list() {
        return cR.findAll();
    }

    @Override
    public void insert(ContactoEmergencia c) {
        cR.save(c);
    }

    @Override
    public ContactoEmergencia listId(int idContactoEmergencia) {
        return cR.findById(idContactoEmergencia).orElse(new ContactoEmergencia());
    }

    @Override
    public void update(ContactoEmergencia c) {
        cR.save(c);
    }

    @Override
    public void delete(int idContactoEmergencia) {
        cR.deleteById(idContactoEmergencia);
    }

    @Override
    public List<ContactoEmergencia> buscarPorNombrecontacto(String nombre) {
        return cR.buscarPorNombrecontacto(nombre);
    }

    @Override
    public List<ContactoEmergencia> buscarPorCorreo(@Param("correo") String correo){
        return  cR.buscarPorCorreo(correo);
    }

    @Override
    public List<String[]> listarUsuariosConDiagnosticoGraveSinContacto(){
        return cR.listarUsuariosConDiagnosticoGraveSinContacto();
    }
}
