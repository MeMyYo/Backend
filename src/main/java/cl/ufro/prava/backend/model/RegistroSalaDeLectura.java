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
@Table("registrosalalectura")
public class RegistroSalaDeLectura implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="salaDeLectura_id")
    private SalaDeLectura salaDeLecturaidSala;

    @Column(name="fechaRegistro")
    private Timestamp fechaRegistro;
    
    @Column(name="tipoRegistro")
    private String tipoRegistro;
    
    public RegistroSalaDeLectura(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getClientes() {
        return cliente;
    }

    public void setClientes(Cliente clientes) {
        this.cliente = clientes;
    }

    public SalaDeLectura getSalasDeLecturaidSala() {
        return salaDeLecturaidSala;
    }

    public void setSalasDeLecturaidSala(SalaDeLectura salasDeLecturaidSala) {
        this.salaDeLecturaidSala = salasDeLecturaidSala;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
    
    
    

}
