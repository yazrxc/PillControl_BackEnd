package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;

public interface IMedicamentoFarmaciaRepository extends JpaRepository<MedicamentoFarmacia,Integer> {
}
