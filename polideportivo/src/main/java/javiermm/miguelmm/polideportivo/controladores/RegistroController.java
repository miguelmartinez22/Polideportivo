package javiermm.miguelmm.polideportivo.controladores;

import javiermm.miguelmm.polideportivo.entidades.Cliente;
import javiermm.miguelmm.polideportivo.servicios.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class RegistroController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/registro")
    public String nuevaEntrada(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "app/registro";
    }

    @RequestMapping(value ="/registro/submit", method = RequestMethod.POST)
    public String nuevaEntradaSubmit(@ModelAttribute Cliente cliente) {
        try {
            //asignar id
            long numCLientes = clienteService.findNumClientes();
            cliente.setId(numCLientes);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = cliente.getTipo();
            Date date = format.parse(fecha);
            cliente.setFechaNacimiento(date);
            cliente.setTipo("Cliente");

            clienteService.insertar(cliente);

            return "redirect:/";
        } catch (Exception ex){
            return "error";
        }
    }
}
