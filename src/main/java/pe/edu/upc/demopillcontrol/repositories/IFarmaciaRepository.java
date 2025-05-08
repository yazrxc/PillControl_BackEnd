package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaHorarioDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaUbicacionDTO;
import pe.edu.upc.demopillcontrol.dtos.VerificarHorarioFarmaciaDTO;
import pe.edu.upc.demopillcontrol.entities.Farmacia;

import java.time.LocalTime;
import java.util.List;
@Repository
public interface IFarmaciaRepository extends JpaRepository<Farmacia,Integer> {
    // Buscar Farmacia por nombre
    Farmacia findByNombreFarmacia(String nombreFarmacia); // Cambio de 'findByNombre' a 'findByNombreFarmacia'

    // Verificar horario de Farmacia
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.VerificarHorarioFarmaciaDTO(f.nombreFarmacia, f.horarioAperturaFarmacia, f.horarioCierreFarmacia)" +
            "FROM Farmacia f WHERE f.idFarmacia = :idFarmacia ")
    List<VerificarHorarioFarmaciaDTO> obtenerFarmaciaPorId(@Param("idFarmacia") Long idFarmacia);

    // Listar farmacias que abren temprano según dato ingresado
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaHorarioDTO(f.nombreFarmacia, f.direccionFarmacia, f.horarioAperturaFarmacia) " +
            "FROM Farmacia f WHERE f.horarioAperturaFarmacia < :horaApertura")
    List<QueryFarmaciaHorarioDTO> obtenerFarmaciasQueAbrenTemprano(@Param("horaApertura") LocalTime horaApertura);

    // Mostrar la ubicación (latitud/longitud) de todas las farmacias registradas
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaUbicacionDTO(f.nombreFarmacia, f.latitudFarmacia, f.longitudFarmacia) " +
            "FROM Farmacia f")
    List<QueryFarmaciaUbicacionDTO> obtenerUbicacionesDeFarmacias();
}
