package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Matricula;
import javiermm.miguelmm.polideportivo.repositorios.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Modifying
    public void delete(Matricula m){matriculaRepository.delete(m);}

    public void insertar(Matricula m){matriculaRepository.save(m);}

    public List<Matricula> obtenerTodos(){return matriculaRepository.obtenerTodos();}

    public Matricula findById(long id){return matriculaRepository.findById(id);}

    public List<Matricula> findByCliente(Cliente cliente){return matriculaRepository.findByCliente(cliente);}

    public List<Matricula> findByDeporte(Deporte d){return matriculaRepository.findByDeporte(d);}
}
