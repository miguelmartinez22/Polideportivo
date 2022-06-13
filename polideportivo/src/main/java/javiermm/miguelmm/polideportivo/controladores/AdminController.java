package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.*;
import javiermm.miguelmm.polideportivo.servicios.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Slf4j
@Controller
public class AdminController {

    @Autowired
    DeporteService deporteService;

    @Autowired
    PistaService pistaService;

    @Autowired
    MaterialService materialService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EntrenadorService entrenadorService;

    @Autowired
    StaffService staffService;


    @RequestMapping(value ="/newDeporte/submit", method = RequestMethod.POST)
    public String nuevoDeporteSubmit(@ModelAttribute Deporte deporte, Model model) {
        try {
            Pista p = pistaService.findById(deporte.getPista().getId());
            Entrenador e = entrenadorService.findById(deporte.getEntrenador().getId());
            deporte.setPista(p);
            deporte.setEntrenador(e);
            deporteService.insertar(deporte);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/newPista/submit", method = RequestMethod.POST)
    public String nuevaPistaSubmit(@ModelAttribute Pista pista, Model model) {
        try {
            pistaService.insertar(pista);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/newMaterial/submit", method = RequestMethod.POST)
    public String nuevoMaterialSubmit(@ModelAttribute Material material, Model model) {
        try {
            materialService.insertar(material);

            return "index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/newEntrenador/submit", method = RequestMethod.POST)
    public String nuevoEntrenadorSubmit(@ModelAttribute Entrenador entrenador,  @RequestParam(value = "fechaNacEntr") String fechaNacEntr, Model model) {
        try {
            List<Empleado> empleados = empleadoService.findAll();
            long idAsignar = empleados.size();
            entrenador.setId(idAsignar);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(fechaNacEntr);
            entrenador.setFechaNacimiento(date);

            Date fechaIncorporacion = new Date();
            entrenador.setFechaIncorporacion(fechaIncorporacion);

            entrenadorService.save(entrenador);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/newStaff/submit", method = RequestMethod.POST)
    public String nuevoStaffSubmit(@ModelAttribute Staff staff, @RequestParam(value = "fechaNacStaff") String fechaNacStaff, Model model) {
        try {
            List<Empleado> empleados = empleadoService.findAll();
            long idAsignar = empleados.size();
            staff.setId(idAsignar);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(fechaNacStaff);
            staff.setFechaNacimiento(date);

            Date fechaIncorporacion = new Date();
            staff.setFechaIncorporacion(fechaIncorporacion);

            staffService.insertar(staff);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/listadoDeporte/submit", method = RequestMethod.POST)
    public String listadoDeporteSubmit(@RequestParam(value = "deportId") long id, @RequestParam(value = "deportHorario") String horario, Model model) {
        try {
            Deporte deporte = deporteService.findById(id);
            deporteService.cambiarHorario(deporte, horario);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/listadoDeporteMaterial/submit", method = RequestMethod.POST)
    public String listadoDeporteMaterialSubmit(@RequestParam(value = "deportId") long id, @RequestParam(value = "materDeporte") String nombreMaterial, Model model) {
        try {
            Deporte deporte = deporteService.findById(id);
            Material material = materialService.findByNombre(nombreMaterial);
            material.setDeporte(deporte);
            materialService.insertar(material);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/eliminarDeporte/submit", method = RequestMethod.POST)
    public String eliminarDeporteSubmit(@RequestParam(value = "deportId") long id, Model model) {
        try {
            Deporte deporte = deporteService.findById(id);
            Entrenador e = null;
            if (deporte.getEntrenador() != null){
                e = deporte.getEntrenador();
            }
            Pista p = deporte.getPista();
            List<Material> materials = materialService.findByDeporte(deporte);
            for (int i = 0; i < materials.size(); i++) {
                Material m = materials.get(i);
                m.setDeporte(null);
            }

            List<Matricula> matriculas = matriculaService.findByDeporte(deporte);
            for (int i = 0; i < matriculas.size(); i++) {
                Matricula m = matriculas.get(i);
                m.setDeporte(null);
            }

            deporte.setEntrenador(null);

            deporteService.delete(deporte);
            if (e != null){
                entrenadorService.save(e);
            }
            p.setId(pistaService.findAll().size());
            pistaService.insertar(p);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/listadoEmpleadoReducir/submit", method = RequestMethod.POST)
    public String listadoEmpleadoReducirSubmit(@RequestParam(value = "empleadDni") String dni, @RequestParam(value = "empleadSueldo") int sueldo, Model model) {
        try {
            Empleado empleado = empleadoService.findByDni(dni);
            empleadoService.reducirSalario(empleado, sueldo);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/listadoEmpleadoAumentar/submit", method = RequestMethod.POST)
    public String listadoEmpleadoAumentarSubmit(@RequestParam(value = "empleadDni") String dni, @RequestParam(value = "empleadSueldo") int sueldo, Model model) {
        try {
            Empleado empleado = empleadoService.findByDni(dni);
            empleadoService.aumentarSalario(empleado, sueldo);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/eliminarEmpleado/submit", method = RequestMethod.POST)
    public String eliminarEmpleadoSubmit(@RequestParam(value = "empleadDni") String dni, Model model) {
        try {
            Empleado empleado = empleadoService.findByDni(dni);
            if (entrenadorService.findByDni(dni) != null){
                Entrenador entrenador = entrenadorService.findByDni(dni);
                Deporte deporte = deporteService.findByEntrenador(entrenador);
                if (deporte != null){
                    deporte.setEntrenador(null);
                }
                entrenadorService.delete(entrenador);
            }

            if (staffService.findByDni(dni) != null){
                Staff staff = staffService.findByDni(dni);
                staffService.delete(staff);
            }

            empleadoService.delete(empleado);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/eliminarPista/submit", method = RequestMethod.POST)
    public String eliminarPistaSubmit(@RequestParam(value = "pistId") long id, Model model) {
        try {
            Pista pista = pistaService.findById(id);
            Deporte deporte = deporteService.findByPista(pista);
            if (deporte != null){
                deporte.setPista(null);
            }
            pistaService.delete(pista);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    @RequestMapping(value ="/eliminarMaterial/submit", method = RequestMethod.POST)
    public String eliminarMaterialSubmit(@RequestParam(value = "materiId") long id, Model model) {
        try {
            Material m = materialService.findById(id);
            materialService.delete(m);

            model = returnAdmin(model);
            return "admin/index";
        } catch (Exception ex){
            return "error";
        }
    }

    public Model returnAdmin(Model model) {
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
        return model;
    }
}
