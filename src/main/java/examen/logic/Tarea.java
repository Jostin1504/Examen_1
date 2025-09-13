package examen.logic;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "tarea")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tarea {

    @XmlAttribute
    private String numero;

    @XmlElement
    private String descripcion;

    @XmlElement
    private String fecha;

    @XmlElement
    private String prioridad;

    @XmlElement
    private String estado;

    @XmlElement
    private User responsable;

    public Tarea() {
        this.numero = "";
        this.descripcion = "";
        this.fecha = "";
        this.prioridad = "";
        this.estado = "";
        this.responsable = new User();
    }

    public Tarea(String numero, String descripcion, String fecha, String prioridad, String estado, User responsable) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.estado = estado;
        this.responsable = responsable;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
