package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Usuario;
import javiermm.miguelmm.polideportivo.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario insertar(Usuario u){
        return usuarioRepository.save(u);
    }

    public void borrar(Usuario u){usuarioRepository.delete(u);}

    public Usuario findByUsuario(String usuario){return usuarioRepository.findByUsuario(usuario);}

    public List<Usuario> findAll(){return usuarioRepository.findAll();}
}
