package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.servicios.DeporteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class MainController {

    @Autowired
    DeporteService deporteService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        List<Deporte> deportes = deporteService.findAll();

        model.addAttribute("deportes", deportes);
        return "index";
    }

    @GetMapping({"/quienesSomos"})
    public String quienesSomos() {
        return "app/quienesSomos";
    }

}
