package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import javiermm.miguelmm.polideportivo.entidades.Matricula;
import javiermm.miguelmm.polideportivo.entidades.Pista;
import javiermm.miguelmm.polideportivo.repositorios.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeporteService {

    @Autowired
    DeporteRepository deporteRepository;

    public Deporte cambiarHorario(Deporte deporte, String horario){
        deporte.setHorario(horario);
        return  deporteRepository.save(deporte);
    }

    public void delete(Deporte d){deporteRepository.delete(d);}

    public Deporte insertar(Deporte d){return deporteRepository.save(d);}

    public List<Deporte> obtenerTodos(){return deporteRepository.obtenerTodos();}

    public Deporte findById(long id){return deporteRepository.findById(id);}

    public Deporte findByEntrenador(Entrenador entrenador){return deporteRepository.findByEntrenador(entrenador);}

    public Deporte findByNombre(String nombre){return deporteRepository.findByNombre(nombre);}

    public Deporte findByPista(Pista pista){return deporteRepository.findByPista(pista);}

    public int obtenerCantidad(){return deporteRepository.obtenerCantidad();}

    public List<Deporte> findAll(){return deporteRepository.findAll();}
}
