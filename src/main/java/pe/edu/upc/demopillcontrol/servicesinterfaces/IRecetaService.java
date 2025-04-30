package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Receta;

import java.util.List;

public interface IRecetaService {
    public List<Receta> list();
    public void insert(Receta r);
    //public Receta listId(int idReceta);
    public void update(Receta r);
    public void delete(int idReceta);
    //public List<Receta> buscarPorNombre(String nombreUsuario);
}
