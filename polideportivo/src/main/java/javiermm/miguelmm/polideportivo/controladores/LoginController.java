package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.*;
import javiermm.miguelmm.polideportivo.servicios.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    DeporteService deporteService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    MaterialService materialService;

    @Autowired
    PistaService pistaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EntrenadorService entrenadorService;

    @Autowired
    StaffService staffService;


    @GetMapping("/login")
    public String logearse(Model model) {
        model.addAttribute("usuarioErroneo", 0);
        return "app/login";
    }

    @RequestMapping(value ="/login/submit", method = RequestMethod.POST)
    public String logearseSubmit(@RequestParam(value = "usuarioLogeo") String nombre, @RequestParam(value = "contrasenaLogeo") String passwd, Model model) {
        try {
            Usuario usuario1 = new Usuario();

            List<Usuario> usuarios = usuarioService.findAll();
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i);
                if (u.getUsuario().equals(nombre)){
                    usuario1 = u;
                }
            }

            if (usuario1.getUsuario() == null){ // si el usuario no se encuentra en la base de datos, se le conduce al login
                model.addAttribute("usuarioErroneo", "El usuario o la contraseña introducidos son incorrectos");
                return "app/login";
            } else { // si el usuario está en la bd
                if (nombre.equals(usuario1.getUsuario()) && passwd.equals(usuario1.getContrasena())){ // si es correcto

                    if (usuario1.getTipo().equals("Administrador")) { //si el usuario es un administrador se le conduce a su vista
                        /*Crea cartera de administrador*/
                        List<Matricula> matriculas = matriculaService.obtenerTodos();
                        int cartera = 0;
                        for (int i = 0; i < matriculas.size(); i++) {
                            Matricula matricula = matriculas.get(i);
                            if (matricula.getCliente() != null){
                                int precio = matricula.getDeporte().getPrecio();
                                cartera += precio;
                            }
                        }

                        model.addAttribute("cartera", cartera);

                        List<Deporte> deportes = deporteService.findAll();
                        model.addAttribute("deportes", deportes);
                        model.addAttribute("deporte", new Deporte());

                        List<Entrenador> entrenadors = entrenadorService.findAll();
                        model.addAttribute("entrenadors", entrenadors); // lista entrenadores para formulario de deporte

                        List<Pista> pists = pistaService.findAll();
                        model.addAttribute("pists", pists); // lista pistas para formulario de deporte

                        List<Pista> pistas = pistaService.findAll();
                        model.addAttribute("pistas", pistas);
                        model.addAttribute("pista", new Pista());

                        List<Material> materiales = materialService.findAll();
                        model.addAttribute("materiales", materiales);
                        model.addAttribute("material", new Material());

                        List<Empleado> empleados = empleadoService.findAll();
                        model.addAttribute("empleados", empleados);

                        List<Entrenador> entrenadores = entrenadorService.findAll();
                        model.addAttribute("entrenadores", entrenadores);
                        model.addAttribute("entrenador", new Entrenador());

                        List<Staff> staffs = staffService.findAll();
                        model.addAttribute("staffs", staffs);
                        model.addAttribute("staff", new Staff());

                        return "admin/index";
                    } else {
                        List<Deporte> deportes = deporteService.findAll();
                        List<Cliente> clientes = clienteService.findByUsuario(nombre);
                        Cliente cliente = clientes.get(0);
                        List<Matricula> matriculas = matriculaService.findByCliente(cliente);

                        model.addAttribute("matriculas", matriculas);
                        model.addAttribute("deportes", deportes);
                        model.addAttribute("cliente", cliente);
                        model.addAttribute("matricula", new Matricula());

                        return "app/datos";
                    }

                } else { // si el usuario y la contraseña no coinciden, se le conduce al login
                    model.addAttribute("usuarioErroneo", "El usuario o la contraseña introducidos son incorrectos");
                    return "app/login";
                }
            }
        }catch (Exception exception){
            model.addAttribute("usuarioErroneo", "El usuario o la contraseña introducidos son incorrectos");
            return "app/login";
        }
    }

}
