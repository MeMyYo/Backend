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
@Table("cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ciudad_id")
    private Ciudad ciudad;
    
    @Column(name = "RUN")
    private String RUN;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    
    @Column(name = "genero")
    private String genero;
    
    @Column(name = "fechaDeNacimiento")
    private Timestamp fechaDeNacimiento;
    
    @Column(name = "estadoDeTrabajo")
    private String estadoDeTrabajo;
    
    @Column(name = "areaDeInteres")
    private String areaDeInteres;
    
    @Column(name = "fechaUltimaSolicitud")
    private Timestamp fechaUltimaSolicitud;
    
    @Column(name = "diasDeAtraso")
    private int diasDeAtraso = 0;
    
    @Column(name = "numeroDeCelular")
    private Integer numeroDeCelular;
    
    @Column(name = "numeroDeTelefono")
    private Integer numeroDeTelefono;
    
    @Column(name = "correoElectronico")
    private String correoElectronico;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<SolicitudComputador> solicitudesComputador;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<SolicitudLibro> solicitudesLibro;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<EntregaDeLibro> entregasDeLibro;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<RegistroSalaDeLectura> registrosSalaLectura;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_biblioteca",
        joinColumns = @JoinColumn(name = "cliente_id"),
        inverseJoinColumns = @JoinColumn(name = "biblioteca_id")
    )
    private List<Biblioteca> bibliotecas;
    
    public Cliente(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        this.RUN = RUN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Timestamp getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Timestamp fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstadoDeTrabajo() {
        return estadoDeTrabajo;
    }

    public void setEstadoDeTrabajo(String estadoDeTrabajo) {
        this.estadoDeTrabajo = estadoDeTrabajo;
    }

    public String getAreaDeInteres() {
        return areaDeInteres;
    }

    public void setAreaDeInteres(String areaDeInteres) {
        this.areaDeInteres = areaDeInteres;
    }

    public Timestamp getFechaUltimaSolicitud() {
        return fechaUltimaSolicitud;
    }

    public void setFechaUltimaSolicitud(Timestamp fechaUltimaSolicitud) {
        this.fechaUltimaSolicitud = fechaUltimaSolicitud;
    }

    public int getDiasDeAtraso() {
        return diasDeAtraso;
    }

    public void setDiasDeAtraso(int diasDeAtraso) {
        this.diasDeAtraso = diasDeAtraso;
    }

    public Integer getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setNumeroDeCelular(Integer numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public Integer getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(Integer numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<SolicitudComputador> getSolicitudesComputador() {
        return solicitudesComputador;
    }

    public void setSolicitudesComputador(List<SolicitudComputador> solicitudesComputador) {
        this.solicitudesComputador = solicitudesComputador;
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

    public List<RegistroSalaDeLectura> getRegistrosSalaLectura() {
        return registrosSalaLectura;
    }

    public void setRegistrosSalaLectura(List<RegistroSalaDeLectura> registrosSalaLectura) {
        this.registrosSalaLectura = registrosSalaLectura;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    
}
