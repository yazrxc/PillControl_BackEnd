package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaHorarioDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaUbicacionDTO;
import pe.edu.upc.demopillcontrol.dtos.VerificarHorarioFarmaciaDTO;
import pe.edu.upc.demopillcontrol.entities.Farmacia;
import pe.edu.upc.demopillcontrol.repositories.IFarmaciaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IFarmaciaService;

import java.time.LocalTime;
import java.util.List;

@Service
public class FarmaciaServiceImplement implements IFarmaciaService {

    @Autowired
    private IFarmaciaRepository fR;

    @Override
    public void insert(Farmacia f) {
        fR.save(f);
    }
    @Override
    public void update(Farmacia f) {
        fR.save(f);
    }
    @Override
    public void delete(int idFarmacia) {
        fR.deleteById(idFarmacia);
    }
    @Override
    public List<Farmacia> list() {
        return fR.findAll();
    }



    //Buscar Farmcia por nombre
    @Override
    public Farmacia obtenerFarmaciaPorNombre(String nombre) {
        return fR.findByNombre(nombre);
    }

    //Verificar horario de Farmacia
    @Override
    public List<VerificarHorarioFarmaciaDTO>obtenerFarmaciaPorId(Long idFarmacia) {
        return fR.obtenerFarmaciaPorId(idFarmacia);
    }

    @Override
    public List<QueryFarmaciaHorarioDTO> obtenerFarmaciasQueAbrenTemprano(LocalTime horaApertura) {
        return fR.obtenerFarmaciasQueAbrenTemprano(horaApertura);
    }

    @Override
    public List<QueryFarmaciaUbicacionDTO> obtenerUbicacionesDeFarmacias() {
        return fR.obtenerUbicacionesDeFarmacias();
    }
}
