package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaHorarioDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaUbicacionDTO;
import pe.edu.upc.demopillcontrol.dtos.VerificarHorarioFarmaciaDTO;
import pe.edu.upc.demopillcontrol.entities.Farmacia;

import java.time.LocalTime;
import java.util.List;

public interface IFarmaciaService {
    public List<Farmacia> list();
    public void insert(Farmacia f);
    //public Farmacia listId(int idFarmacia);
    public void update(Farmacia f);
    public void delete(int idFarmacia);
    //public List<Farmacia> buscarPorNomnre(String nombreFarmacia);




    //Buscar Farmcia por nombre
    public Farmacia obtenerFarmaciaPorNombre(String nombre);

    //Verificar horario de Farmacia
    public List<VerificarHorarioFarmaciaDTO> obtenerFarmaciaPorId(Long idFarmacia);

    //Query
    public  List<QueryFarmaciaHorarioDTO> obtenerFarmaciasQueAbrenTemprano(LocalTime horaApertura);
    public  List<QueryFarmaciaUbicacionDTO> obtenerUbicacionesDeFarmacias();
}
