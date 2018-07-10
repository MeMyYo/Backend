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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table("estante")
public class Estante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    
    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="estante_id")
    private List<Libro> libros;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="biblioteca_id")
    private Biblioteca biblioteca;
    
    @Column(name="capacidadAproximada")
    private int capacidadAproximada;

    public Estante(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getCapacidadAproximada() {
        return capacidadAproximada;
    }

    public void setCapacidadAproximada(int capacidadAproximada) {
        this.capacidadAproximada = capacidadAproximada;
    }

    
    
}
