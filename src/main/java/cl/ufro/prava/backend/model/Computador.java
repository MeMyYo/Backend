package cl.ufro.prava.backend.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
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
@Table("computador")
public class Computador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="biblioteca_id")
    private Biblioteca biblioteca;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="computador_id")
    private List<SolicitudComputador> solicitudesComputador;
    
    @Column(name="marca")
    private String marca;
    
    @Column(name="fechaDeAdquisicion")
    private Timestamp fechaDeAdquisicion;
    
    @Column(name="fechaUltimaSolicitud")
    private Timestamp fechaUltimaSolicitud;

    public Computador(){}

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

    public List<SolicitudComputador> getSolicitudesComputador() {
        return solicitudesComputador;
    }

    public void setSolicitudesComputador(List<SolicitudComputador> solicitudesComputador) {
        this.solicitudesComputador = solicitudesComputador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Timestamp getFechaDeAdquisicion() {
        return fechaDeAdquisicion;
    }

    public void setFechaDeAdquisicion(Timestamp fechaDeAdquisicion) {
        this.fechaDeAdquisicion = fechaDeAdquisicion;
    }

    public Timestamp getFechaUltimaSolicitud() {
        return fechaUltimaSolicitud;
    }

    public void setFechaUltimaSolicitud(Timestamp fechaUltimaSolicitud) {
        this.fechaUltimaSolicitud = fechaUltimaSolicitud;
    }

    
    
}
