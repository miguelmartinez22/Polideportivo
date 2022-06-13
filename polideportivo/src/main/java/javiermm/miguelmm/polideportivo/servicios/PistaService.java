package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Pista;
import javiermm.miguelmm.polideportivo.repositorios.DeporteRepository;
import javiermm.miguelmm.polideportivo.repositorios.PistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PistaService {

    @Autowired
    PistaRepository pistaRepository;

    public Pista insertar(Pista p){return pistaRepository.save(p);}

    public void delete(Pista p){pistaRepository.delete(p);}

    public List<Pista> findAll(){return pistaRepository.findAll();}

    public Pista findById(long id){return pistaRepository.getById(id);}

}
