package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;
import pe.edu.upc.demopillcontrol.repositories.IPerfilSaludRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IPerfilSaludService;

import java.util.List;

@Service
public class PerfilSaludServiceImplement implements IPerfilSaludService {
    @Autowired
    private IPerfilSaludRepository pR;

    @Override
    public List<PerfilSalud> list() {
        return pR.findAll();
    }

    @Override
    public void insert(PerfilSalud p) {
        pR.save(p);
    }

    @Override
    public void update(PerfilSalud p) {
        pR.save(p);
    }

    @Override
    public void delete(int idPerfilSalud) {
        pR.deleteById(idPerfilSalud);
    }

    @Override
    public PerfilSalud listId(int idPerfilSalud) {
        return pR.findById(idPerfilSalud).orElse(new PerfilSalud());
    }

    @Override
    public List<String[]> buscargruposanguineo(int id_usuario) {
        return pR.buscargruposanguineo(id_usuario);
    }
    @Override
    public List<String[]> buscarcondiciones(int id_usuario){
        return pR.buscarcondiciones(id_usuario);
    }


    @Override
    public List<String[]> listperfilPorMesYAnio( int mes, int anio){
        return pR.listperfilPorMesYAnio(mes,anio);
    }



}
