package pe.edu.upc.luiserik.servicesinterfaces;

import pe.edu.upc.luiserik.entities.Farmacia;

import java.util.List;

public interface FarmaciaServiceInterfaces {
    public List<Farmacia> list();

    public void insert(Farmacia farmacia);

    public void update(Farmacia farmacia);

    public void delete(Long idFarmacia);
}
