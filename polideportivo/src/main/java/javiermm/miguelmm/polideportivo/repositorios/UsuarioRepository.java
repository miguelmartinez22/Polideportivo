package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("select u from Usuario u where u.usuario = ?1")
    Usuario findByUsuario(String usuario);

}
