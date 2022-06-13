package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import javiermm.miguelmm.polideportivo.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public Cliente insertar(Cliente c){
        Cliente nuevoCliente = null;
        try {
            nuevoCliente = clienteRepository.save(c);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return nuevoCliente;
    }

    public void borrar (Cliente c){
        clienteRepository.delete(c);
    }

    public List<Cliente> findAll(){return clienteRepository.findAll();}

    public Optional<Cliente> findByOptionalId(long id){return clienteRepository.findById(id);}

    public List<Cliente> findByUsuario(String usuario){return clienteRepository.findByUsuario(usuario);}

    public int findNumClientes(){return clienteRepository.findNumClientes();}


}
