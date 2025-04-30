package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.DetalleReceta;

import java.util.List;

public interface IDetalleRecetaService {
    public List<DetalleReceta> list();
    public void insert(DetalleReceta dr);
    //public DetalleReceta listId(int idDetalleReceta);
    public void update(DetalleReceta dr);
    public void delete(int idDetalleReceta);
    //public List<DetalleReceta> buscarPorReceta(int idReceta);
}
