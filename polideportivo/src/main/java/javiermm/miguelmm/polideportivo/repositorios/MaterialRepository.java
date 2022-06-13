package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long>{

    @Query("select m from Material m where m.id = ?1")
    public Material findById(long id);

    @Query("select m from Material m where m.nombre = ?1")
    public Material findByNombre(String nombre);

    @Query("select m from Material m where m.deporte = ?1")
    public List<Material> findByDeporte(Deporte d);
}
