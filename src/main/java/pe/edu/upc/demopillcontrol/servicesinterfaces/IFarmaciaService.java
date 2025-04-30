package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Farmacia;

import java.util.List;

public interface IFarmaciaService {
    public List<Farmacia> list();
    public void insert(Farmacia f);
    //public Farmacia listId(int idFarmacia);
    public void update(Farmacia f);
    public void delete(int idFarmacia);
    //public List<Farmacia> buscarPorNomnre(String nombreFarmacia);
}
