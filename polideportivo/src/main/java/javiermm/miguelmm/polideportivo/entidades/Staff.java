package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "staff")
@Entity
@Data
public class Staff extends Empleado{

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String puesto;
}
