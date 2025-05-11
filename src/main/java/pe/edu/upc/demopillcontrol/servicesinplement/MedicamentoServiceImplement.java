package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.repositories.IMedicamentoRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IMedicamentoService;

import java.util.List;

@Service
public class MedicamentoServiceImplement implements IMedicamentoService {

    @Autowired
    private IMedicamentoRepository mR;

    @Override
    public List<Medicamento> listarMedicamentos() {
        return mR.findAll();
    }

    @Override
    public void insertar(Medicamento m) {
        mR.save(m);
    }

    @Override
    public void eliminar(int id) {
        mR.deleteById(id);
    }

    @Override
    public Medicamento listarporID(int id) {
        return mR.findById(id).orElse(new Medicamento());
    }

    @Override
    public void modificar(Medicamento m) {
        mR.save(m);
    }

    @Override
    public List<Medicamento> listarPorNombre(String nombre) {
        return mR.listarPorNombre(nombre);
    }

    @Override
    public List<Medicamento> listarPorPresentacion(String presentacion) {
        return mR.listarPorPresentacion(presentacion);
    }
}
