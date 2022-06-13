package javiermm.miguelmm.polideportivo.controladores;


import javiermm.miguelmm.polideportivo.entidades.Deporte;
import javiermm.miguelmm.polideportivo.servicios.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class DetailController {

    @Autowired
    DeporteService deporteService;

    @GetMapping("/deporte/detalles/{id}")
    public String detallesDeporte(@PathVariable("id") long id, Model model) {
        Deporte deporte = deporteService.findById(id);
        if (deporte != null) {
            model.addAttribute("deporte", deporte);
            return "app/detalles";
        }
        return "redirect:/";
    }

}
