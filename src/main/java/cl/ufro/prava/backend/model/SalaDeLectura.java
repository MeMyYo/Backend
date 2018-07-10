package cl.ufro.prava.backend.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table("saladelectura")
public class SalaDeLectura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "salaDeLectura_id")
    private List<RegistroSalaDeLectura> registroSalaDeLectura;

    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "nombre")
    private String nombre;

    public SalaDeLectura(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<RegistroSalaDeLectura> getRegistroSalaDeLectura() {
        return registroSalaDeLectura;
    }

    public void setRegistroSalaDeLectura(List<RegistroSalaDeLectura> registroSalaDeLectura) {
        this.registroSalaDeLectura = registroSalaDeLectura;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
