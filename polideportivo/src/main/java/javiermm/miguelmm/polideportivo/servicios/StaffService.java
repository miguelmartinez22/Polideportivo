package javiermm.miguelmm.polideportivo.servicios;

import javiermm.miguelmm.polideportivo.entidades.Entrenador;
import javiermm.miguelmm.polideportivo.entidades.Staff;
import javiermm.miguelmm.polideportivo.repositorios.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public Staff insertar(Staff s){return staffRepository.save(s);}

    public void delete(Staff s){staffRepository.delete(s);}

    public Staff findByPuesto(String puesto){return staffRepository.findByPuesto(puesto);}

    public List<Staff> findByDepartamento(String departamento){return staffRepository.findByDepartamento(departamento);}

    public List<Staff> findAll() {return staffRepository.findAll();}

    public Staff findByDni(String dni) { return  staffRepository.findByDni(dni);}
}
