package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.clasesayuda.EmpleadoRequest;
import javiermm.miguelmm.polideportivo.clasesayuda.HorarioRequest;
import javiermm.miguelmm.polideportivo.clasesayuda.Response;
import javiermm.miguelmm.polideportivo.entidades.*;
import javiermm.miguelmm.polideportivo.servicios.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    ClienteService clienteService;

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


    @GetMapping("/getAllDeportes")
    public List<Deporte> getAllDeportes() {
        try {
            return deporteService.findAll();
        }catch (Exception ex) {
            return null;
        }
    }

    @GetMapping("/getAllEntrenadores")
    public List<Entrenador> getAllEntrenadores() {
        try {
            return entrenadorService.findAll();
        }catch (Exception ex){
            return null;
        }
    }

    @GetMapping("/getClienteById/{id}")
    public Optional<Cliente> getClienteById(@PathVariable("id") long id) {
        try {
            return clienteService.findByOptionalId(id);
        }catch (Exception ex){
            return Optional.empty();
        }
    }

    @GetMapping("/getMatriculaById/{id}")
    public Matricula getMatriculaById(@PathVariable("id") long id) {
        try {
            return matriculaService.findById(id);
        }catch (Exception ex){
            return null;
        }
    }

    @PostMapping("/newPista")
    public Response newPista(@RequestBody Pista pista) {
        Response response = new Response();
        try {
            if (pista == null){
                throw new Exception("La pista enviado es nula");
            }

            pistaService.insertar(pista);

            response.success = true;
            response.respuesta = "Pista insertada con éxito";
            response.error = null;

            return response;
        }catch (Exception ex){
            response.success = false;
            response.respuesta = "Error al insertar Pista";
            response.error = ex.getMessage();

            return response;
        }
    }

    @PostMapping("/newMaterial")
    public Response newMaterial(@RequestBody Material material) {
        Response response = new Response();
        try {
            if (material == null){
                throw new Exception("El material enviado es nulo");
            }

            materialService.insertar(material);

            response.success = true;
            response.respuesta = "Material insertado con éxito";
            response.error = null;

            return response;
        }catch (Exception ex){
            response.success = false;
            response.respuesta = "Error al insertar Material";
            response.error = ex.getMessage();

            return response;
        }
    }

    @PostMapping("/horarioDeporte")
    public Response horarioDeporte(@RequestBody HorarioRequest horarioRequest) {
        Response response = new Response();
        long id = horarioRequest.id;;
        String horario = horarioRequest.horario;
        try {
            if (horario == null) {
                throw new Exception("El horario introducido es nulo");
            }
            else  if(horario.equals("9:00-11:00") || horario.equals("12:00-14:00") || horario.equals("17:00-19:00") || horario.equals("19:00-21:00")){
                Deporte deporte = deporteService.findById(id);
                if (deporte == null) {
                    throw new Exception("El id de deporte introducido no es válido o no está en la lista de horarios disponibles");
                }

                deporteService.cambiarHorario(deporte, horario);

                response.success = true;
                response.respuesta = "Horario cambiado con éxito";
                response.error = null;
            } else {
                throw new Exception("El horario introducido no es válido");
            }
            return response;
        }catch (Exception ex){
            response.success = false;
            response.respuesta = "Error al cambiar horario";
            response.error = ex.getMessage();

            return response;
        }
    }

    @PostMapping("/reducirSueldoEmpleado")
    public Response reducirSueldoEmpleado(@RequestBody EmpleadoRequest empleadoRequest) {
        Response response = new Response();
        int sueldo = empleadoRequest.sueldo;
        String dni = empleadoRequest.dni;
        try {
            if (sueldo == 0) {
                throw new Exception("El sueldo introducido es nulo");
            }
            else  if(sueldo < 100){
                Empleado empleado = empleadoService.findByDni(dni);
                if (empleado == null) {
                    throw new Exception("El dni de empleado introducido no es válido");
                }

                empleadoService.reducirSalario(empleado, sueldo);

                response.success = true;
                response.respuesta = "Sueldo reducido con éxito";
                response.error = null;
            } else {
                throw new Exception("El sueldo a reducir es demasiado alto");
            }
            return response;
        }catch (Exception ex){
            response.success = false;
            response.respuesta = "Error al reducir sueldo";
            response.error = ex.getMessage();

            return response;
        }
    }

    @PostMapping("/aumentarSueldoEmpleado")
    public Response aumentarSueldoEmpleado(@RequestBody EmpleadoRequest empleadoRequest) {
        Response response = new Response();
        int sueldo = empleadoRequest.sueldo;
        String dni = empleadoRequest.dni;
        try {
            if (sueldo == 0) {
                throw new Exception("El sueldo introducido es nulo");
            }
            else  if(sueldo < 100){
                Empleado empleado = empleadoService.findByDni(dni);
                if (empleado == null) {
                    throw new Exception("El dni de empleado introducido no es válido");
                }


                empleadoService.aumentarSalario(empleado, sueldo);

                response.success = true;
                response.respuesta = "Sueldo aumentado con éxito";
                response.error = null;
            } else {
                throw new Exception("El sueldo a aumentar es demasiado alto");
            }
            return response;
        }catch (Exception ex){
            response.success = false;
            response.respuesta = "Error al aumentar sueldo";
            response.error = ex.getMessage();

            return response;
        }
    }

}
