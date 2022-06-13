package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Empleado;
import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import javiermm.miguelmm.polideportivo.repositorios.EmpleadoRepository;
import javiermm.miguelmm.polideportivo.repositorios.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void reducirSalario(Empleado e, double reduccionPorcentual){
        int salarioViejo = e.getSueldo();
        double reduccion = salarioViejo * (reduccionPorcentual / 100);
        double salarioNuevo = salarioViejo - reduccion;
        e.setSueldo((int) salarioNuevo);
        empleadoRepository.save(e);
    }

    public void aumentarSalario(Empleado e, double aumentoPorcentual){
        int salarioViejo = e.getSueldo();
        double aumento = salarioViejo * (aumentoPorcentual / 100);
        double salarioNuevo = salarioViejo + aumento;
        e.setSueldo((int) salarioNuevo);
        empleadoRepository.save(e);
    }

    public Empleado insertar(Empleado e){return empleadoRepository.save(e);}

    public void delete(Empleado e){ empleadoRepository.delete(e);}

    public List<Empleado> findAll(){return empleadoRepository.findAll();}

    public List<Empleado> findBySueldo(int sueldo){return empleadoRepository.findBySueldo(sueldo);}

    public Empleado findByDni(String dni){return empleadoRepository.findByDni(dni);}
}
