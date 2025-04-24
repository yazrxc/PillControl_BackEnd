package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Especialista;

import java.util.List;

public interface IEspecialistaService {
    public List<Especialista> list();
    public void insert(Especialista e);
    Especialista listId(int idEspecialista);
    void update(Especialista e);
    void delete(int idEspecialista);
}
