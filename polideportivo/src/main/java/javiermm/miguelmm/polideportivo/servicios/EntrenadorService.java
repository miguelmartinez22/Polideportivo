package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import javiermm.miguelmm.polideportivo.repositorios.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    EntrenadorRepository entrenadorRepository;

    public void save(Entrenador e){ entrenadorRepository.save(e);}

    public void delete(Entrenador e){entrenadorRepository.delete(e);}

    public List<Entrenador> findAll(){return entrenadorRepository.findAll();}

    public Entrenador findByEquipo(String equipo){return entrenadorRepository.findByEquipo(equipo);}

    public Entrenador findByDni(String dni){return entrenadorRepository.findByDni(dni);}

    public Entrenador findById(long id){return entrenadorRepository.findById(id);}
}
