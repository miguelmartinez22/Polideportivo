package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Material;
import javiermm.miguelmm.polideportivo.repositorios.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public Material insertar(Material m){return materialRepository.save(m);}

    public void delete(Material m){materialRepository.delete(m);}

    public List<Material> findAll(){return materialRepository.findAll();}

    public Material findById(long id){return materialRepository.findById(id);}

    public Material findByNombre(String nombre){return materialRepository.findByNombre(nombre);}

    public List<Material> findByDeporte(Deporte d){return materialRepository.findByDeporte(d);}
}
