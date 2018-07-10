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
import javax.persistence.Table;

@Entity
@Table("solicitudlibro")
public class SolicitudLibro implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="libro_id")
    private Libro libro;
    
    @Column(name="fechaDeSolicitud")
    private Timestamp fechaDeSolicitud;
    
    @Column(name="fechaEntregaLimite")
    private Timestamp fechaEntregaLimite;

    public SolicitudLibro(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Timestamp getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(Timestamp fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public Timestamp getFechaEntregaLimite() {
        return fechaEntregaLimite;
    }

    public void setFechaEntregaLimite(Timestamp fechaEntregaLimite) {
        this.fechaEntregaLimite = fechaEntregaLimite;
    }

}
