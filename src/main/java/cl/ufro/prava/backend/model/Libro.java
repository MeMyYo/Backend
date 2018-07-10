package cl.ufro.prava.backend.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table("libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="estante_id")
    private Estante estante;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private List<SolicitudLibro> solicitudesLibro;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private List<EntregaDeLibro> entregasDeLibro;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "libros_autores",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;
    
    @Column(name="codigo")
    private String codigo;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="numeroDePaginas")
    private int numeroDePaginas;
    
    @Column(name="disponibilidad")
    private String disponibilidad;
    
    @Column(name="fechaDeAdquisicion")
    private Timestamp fechaDeAdquisicion;
    
    @Column(name="fechaDeEdicion")
    private Timestamp fechaDeEdicion;
    
    @Column(name="edicion")
    private String edicion;
    
    @Column(name="editor")
    private String editor;
    
    @Column(name="vecesSolicitado")
    private int vecesSolicitado;
    
    @Column(name="fechaUltimaSolicitud")
    private Timestamp fechaUltimaSolicitud;
    
    @Column(name="colorTapa")
    private String colorTapa;
    
    @Column(name="estadoDeterioro")
    private String estadoDeterioro;
    
    @Column(name="idioma")
    private String idioma;

    public Libro(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<SolicitudLibro> getSolicitudesLibro() {
        return solicitudesLibro;
    }

    public void setSolicitudesLibro(List<SolicitudLibro> solicitudesLibro) {
        this.solicitudesLibro = solicitudesLibro;
    }

    public List<EntregaDeLibro> getEntregasDeLibro() {
        return entregasDeLibro;
    }

    public void setEntregasDeLibro(List<EntregaDeLibro> entregasDeLibro) {
        this.entregasDeLibro = entregasDeLibro;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Timestamp getFechaDeAdquisicion() {
        return fechaDeAdquisicion;
    }

    public void setFechaDeAdquisicion(Timestamp fechaDeAdquisicion) {
        this.fechaDeAdquisicion = fechaDeAdquisicion;
    }

    public Timestamp getFechaDeEdicion() {
        return fechaDeEdicion;
    }

    public void setFechaDeEdicion(Timestamp fechaDeEdicion) {
        this.fechaDeEdicion = fechaDeEdicion;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getVecesSolicitado() {
        return vecesSolicitado;
    }

    public void setVecesSolicitado(int vecesSolicitado) {
        this.vecesSolicitado = vecesSolicitado;
    }

    public Timestamp getFechaUltimaSolicitud() {
        return fechaUltimaSolicitud;
    }

    public void setFechaUltimaSolicitud(Timestamp fechaUltimaSolicitud) {
        this.fechaUltimaSolicitud = fechaUltimaSolicitud;
    }

    public String getColorTapa() {
        return colorTapa;
    }

    public void setColorTapa(String colorTapa) {
        this.colorTapa = colorTapa;
    }

    public String getEstadoDeterioro() {
        return estadoDeterioro;
    }

    public void setEstadoDeterioro(String estadoDeterioro) {
        this.estadoDeterioro = estadoDeterioro;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    
    
}
