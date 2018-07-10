package cl.ufro.prava.backend.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table("funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ciudad_id")
    private Ciudad ciudad;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="biblioteca_id")
    private Biblioteca biblioteca;
    
    @Column(name="run")
    private String RUN;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidoMaterno")
    private String apellidoMaterno;
    
    @Column(name="apellidoPaterno")
    private String apellidoPaterno;
    
    @Column(name="genero")
    private String genero;
    
    @Column(name="fechaDeNacimiento")
    private Timestamp fechaDeNacimiento;
    
    @Column(name="cargo")
    private String cargo;
    
    @Column(name="fechaDeContrato")
    private Timestamp fechaDeContrato;
    
    @Column(name="fechaTerminoContrato")
    private Timestamp fechaTerminoContrato;
    
    @Column(name="numeroCelular")
    private Integer numeroCelular;
    
    @Column(name="numeroTelefono")
    private Integer numeroTelefono;
    
    @Column(name="correoElectronico")
    private String correoElectronico;

    public Funcionario(){}

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

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Timestamp getFechaDeContrato() {
        return fechaDeContrato;
    }

    public void setFechaDeContrato(Timestamp fechaDeContrato) {
        this.fechaDeContrato = fechaDeContrato;
    }

    public Timestamp getFechaTerminoContrato() {
        return fechaTerminoContrato;
    }

    public void setFechaTerminoContrato(Timestamp fechaTerminoContrato) {
        this.fechaTerminoContrato = fechaTerminoContrato;
    }

    public Integer getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(Integer numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Integer getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Integer numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    
}
