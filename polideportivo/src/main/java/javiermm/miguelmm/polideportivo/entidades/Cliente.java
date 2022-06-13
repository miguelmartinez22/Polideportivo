package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Table(name = "cliente")
@Entity
@Data
public class Cliente extends Usuario implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido1;

    private String apellido2;

    @Column(nullable = false)
    private String localidad;

    @Column(nullable = false)
    private String domicilio;

    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String telefono;

}