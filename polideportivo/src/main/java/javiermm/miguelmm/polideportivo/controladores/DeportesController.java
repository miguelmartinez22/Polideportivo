package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.servicios.DeporteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
public class DeportesController {

    @Autowired
    DeporteService deporteService;

    @GetMapping({"/deportes"})
    public String deportes(Model model) {
        try{
            List<Deporte> deportes = deporteService.findAll();
            model.addAttribute("deportes", deportes);
            return "app/deportes";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "error";
        }

    }
}
