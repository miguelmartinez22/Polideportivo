package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

    @Query("select e from Entrenador e where e.especialidad = ?1")
    public Entrenador findByEspecialidad(String especialidad);

    @Query("select e from Entrenador e where e.equipo = ?1")
    public Entrenador findByEquipo(String equipo);

    @Query("select e from Entrenador e where e.id = ?1")
    public Entrenador findById(long id);
}
