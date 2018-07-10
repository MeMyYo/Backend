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
@Table("biblioteca")
public class Biblioteca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ciudad_id")
    private Ciudad ciudad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "propietario")
    private String propietario;

    @Column(name = "numeroDeTelefono")
    private Integer numeroDeTelefono;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private List<Estante> estante;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private List<Computador> computadores;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private List<SalaDeLectura> salasDeLectura;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_biblioteca",
        joinColumns = @JoinColumn(name = "biblioteca_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "biblioteca_id")
    private List<Funcionario> funcionarios;

    public Biblioteca() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
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

    public List<Estante> getEstante() {
        return estante;
    }

    public void setEstante(List<Estante> estante) {
        this.estante = estante;
    }

    public List<Computador> getComputadores() {
        return computadores;
    }

    public void setComputadores(List<Computador> computadores) {
        this.computadores = computadores;
    }

    public List<SalaDeLectura> getSalasDeLectura() {
        return salasDeLectura;
    }

    public void setSalasDeLectura(List<SalaDeLectura> salasDeLectura) {
        this.salasDeLectura = salasDeLectura;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    

}
