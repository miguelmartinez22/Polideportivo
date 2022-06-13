package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Empleado;
import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("select e from Empleado e where e.dni = ?1")
    public Empleado findByDni(String dni);

    @Query("select e from Empleado e where e.sueldo >= ?1")
    public List<Empleado> findBySueldo(int sueldo);

}
