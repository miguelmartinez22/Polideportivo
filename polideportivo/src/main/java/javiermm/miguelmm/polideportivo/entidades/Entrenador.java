package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "entrenador")
@Entity
@Data
public class Entrenador extends Empleado implements Serializable {

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false)
    private String equipo;
}
