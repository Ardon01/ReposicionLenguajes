package unah.hn.examen2_reposicion.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="posiciones")
public class Posiciones {

    /*@Id
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "codigoequipo", referencedColumnName = "codigoequipo")
    private Equipos equipo;*/

    @Id
    @Column(name = "codigoequipo")
    private int codigoEquipo;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "codigoequipo")
    private Equipos equipo;


    private int empates;

    private int ganados;

    private int perdidos;

    @Column(name="golesfavor")
    private int golesFavor;

    @Column(name="golescontra")
    private int golesContra;

    private int puntos;
}
