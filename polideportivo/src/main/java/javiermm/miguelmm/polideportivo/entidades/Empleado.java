package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "empleado")
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado {

    @Id
    private long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido1;

    private String apellido2;

    @Column(nullable = false)
    private int sueldo;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "fecha_incorporacion", nullable = false)
    private Date fechaIncorporacion;
}
