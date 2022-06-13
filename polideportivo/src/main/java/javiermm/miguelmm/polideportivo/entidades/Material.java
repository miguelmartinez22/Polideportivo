package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;

@Table(name = "material")
@Entity
@Data
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "deporte_id", referencedColumnName = "id")
    private Deporte deporte;

}
