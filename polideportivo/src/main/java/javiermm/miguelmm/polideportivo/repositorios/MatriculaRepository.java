package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

    @Query("select m from Matricula m where m.cliente = ?1")
    public List<Matricula> findByCliente(Cliente cliente);

    @Query("select m from Matricula m where m.deporte = ?1")
    public List<Matricula> findByDeporte(Deporte deporte);

    @Query("select m from Matricula m where m.id = ?1")
    public Matricula findById(long id);

    @Query("select m from Matricula m")
    public List<Matricula> obtenerTodos();

    @Query("select m from Matricula m where m.deporte.nombre = ?1 and m.cliente.dni = ?2")
    public Matricula findByDeporteAndClienteDni(String deporte, String dni);

    @Query(value = "delete from Matricula m where m.id = ?1", nativeQuery = true)
    public void deleteById(long id);
}
