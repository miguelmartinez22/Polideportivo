package javiermm.miguelmm.polideportivo.repositorios;

import javiermm.miguelmm.polideportivo.entidades.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, String> {

    @Query("select s from Staff s where s.puesto = ?1")
    public Staff findByPuesto(String puesto);

    @Query("select s from Staff s where s.departamento =?1")
    public List<Staff> findByDepartamento(String departamento);

    @Query("select s from Staff s where s.dni =?1")
    public Staff findByDni(String dni);
}
