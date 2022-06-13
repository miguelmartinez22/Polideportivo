package javiermm.miguelmm.polideportivo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "pista")
@Entity
@Data
public class Pista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String localizacion;

    @Column(nullable = false)
    private int superficie;

}
