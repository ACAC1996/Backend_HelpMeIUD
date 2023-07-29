package co.edu.iudigital.helpme_iud.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="roles")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nombre",nullable = false)
    String nombre;
    @Column
    String descripcion;

    @ManyToMany(mappedBy = "roles")
    List<Usuario> usuarios;

}
