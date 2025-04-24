package pe.edu.upc.luiserik.serviceImplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.luiserik.entities.Farmacia;
import pe.edu.upc.luiserik.repositories.FarmaciaRepository;
import pe.edu.upc.luiserik.servicesinterfaces.FarmaciaServiceInterfaces;

import java.util.List;
@Service
public class FarmaciaServiceImplements implements FarmaciaServiceInterfaces {
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Override
    @Transactional
    public List<Farmacia> list() {
        return farmaciaRepository.findAll();
    }

    @Override
    @Transactional
    public void insert(Farmacia farmacia) {
         farmaciaRepository.save(farmacia);
    }

    @Override
    @Transactional
    public void update(Farmacia farmacia) {
        if (farmaciaRepository.existsById(farmacia.getIdFarmacia())) {
            farmaciaRepository.save(farmacia);
        } else {
            throw new RuntimeException("Farmacia no encontrada");
        }
    }

    @Override
    public void delete(Long idFarmacia) {
        if (farmaciaRepository.existsById(idFarmacia)) {
            farmaciaRepository.deleteById(idFarmacia);
        } else {
            throw new RuntimeException("Farmacia no encontrada");
        }
    }
}
