package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import javiermm.miguelmm.polideportivo.entidades.Matricula;
import javiermm.miguelmm.polideportivo.entidades.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeporteRepository extends JpaRepository<Deporte, Long>{

    @Query("select d from Deporte d where d.id = ?1")
    Deporte findById(long id);

    @Query("select d from Deporte d where d.entrenador = ?1")
    public Deporte findByEntrenador(Entrenador entrenador);

    @Query("select d from Deporte d where d.pista = ?1")
    public Deporte findByPista(Pista pista);

    @Query("select d from Deporte d")
    public List<Deporte> obtenerTodos();

    @Query("select count (d) from Deporte d")
    public int obtenerCantidad();

    @Query("select d from Deporte d where d.nombre = ?1")
    public Deporte findByNombre(String nombre);
}
