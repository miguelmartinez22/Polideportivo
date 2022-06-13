package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.*;
import javiermm.miguelmm.polideportivo.servicios.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class DatosController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    MaterialService materialService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    DeporteService deporteService;

    @Autowired
    PistaService pistaService;

    @Autowired
    EntrenadorService entrenadorService;

    @RequestMapping(value ="/listadoMatriculas/submit", method = RequestMethod.POST)
    public String listadoMatriculasSubmit(@RequestParam(value = "idMatricula") long idMatricula, Model model) {
        try {
            Matricula matricula = matriculaService.findById(idMatricula);
            Cliente c = matricula.getCliente();

            matricula.setCliente(null);
            matriculaService.insertar(matricula);

            model = returnDatos(model, c.getNombre());
            return "app/datos";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/newMatricula/submit", method = RequestMethod.POST)
    public String newMatriculaSubmit(@RequestParam(value = "clienteUsuario") String usuario, @ModelAttribute Matricula matricula, Model model) {
        try {
            Deporte d = deporteService.findById(matricula.getDeporte().getId());
            List<Cliente> c = clienteService.findByUsuario(usuario);
            Date fecha = new Date();

            matricula.setCliente(c.get(0));
            matricula.setDeporte(d);
            matricula.setFecha(fecha);

            matriculaService.insertar(matricula);

            model = returnDatos(model, c.get(0).getNombre());
            return "app/datos";
        } catch (Exception ex){
            return "error";
        }
    }

    public Model returnDatos(Model model, String nombre) {
        List<Deporte> deportes = deporteService.findAll();
        List<Cliente> clientes = clienteService.findByUsuario(nombre);
        Cliente cliente = clientes.get(0);
        List<Matricula> matriculas = matriculaService.findByCliente(cliente);

        model.addAttribute("matriculas", matriculas);
        model.addAttribute("deportes", deportes);
        model.addAttribute("cliente", cliente);
        model.addAttribute("matricula", new Matricula());

        return model;
    }
}
