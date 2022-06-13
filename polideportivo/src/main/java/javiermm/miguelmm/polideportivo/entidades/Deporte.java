package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Table(name = "deporte")
@Entity
@Data
public class Deporte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private String imagen;

    @Column(name = "num_jugadores", nullable = false)
    private int numJugadores;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pista_id")
    private Pista pista;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

}
