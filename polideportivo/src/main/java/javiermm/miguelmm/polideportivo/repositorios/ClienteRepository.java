package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query("select count(c) from Cliente c")
    public int findNumClientes();

    @Query("select c from Cliente c where c.usuario = ?1")
    public List<Cliente> findByUsuario(String usuario);

    Optional<Cliente> findById(long id);

}
