package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Especialista;

import java.util.List;

public interface IEspecialistaService {
    public List<Especialista> list();

    public Especialista listarId(int idEspecialista);

    public void insert(Especialista e);

    void update(Especialista e);

    void delete(int idEspecialista);

    public List<Especialista> buscarEspecialidad(String especialidadEspecialista);
}
