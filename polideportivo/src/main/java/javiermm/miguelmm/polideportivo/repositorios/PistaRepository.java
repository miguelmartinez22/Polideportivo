package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.entidades.Pista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PistaRepository extends JpaRepository<Pista, Long> {

}
