package examen.logic;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;

public class Tarea {

    @XmlID
    @XmlElement
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


    // Constructor vacío
    public Tarea() {
        this.numero = "";
        this.descripcion = "";
        this.fecha = "";
        this.prioridad = "";
        this.estado = "";
        this.responsable = new User();
    }

    // Constructor con parámetros
    public Tarea(String id, String nombre, String email, String fecha, String prioridad, String estado, User responsable) {
        this.numero = id;
        this.descripcion = nombre;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fecha = email;
        this.responsable = responsable;
    }


    public String getNumero() { return numero; }
    public void setNumero(String id) { this.numero = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String nombre) { this.descripcion = nombre; }

    public String getFecha() { return fecha; }
    public void setFecha(String ganados) { this.fecha = ganados; }

    public String getprioridad() { return prioridad; }
    public void setprioridad(String ganados) { this.prioridad = ganados; }

    public String getestado() { return estado; }
    public void setestado(String ganados) { this.estado = ganados; }

    public User getresponsable() { return responsable; }
    public void setresponsable(User ganados) { this.responsable = ganados; }


    @Override
    public String toString() {
        return descripcion;
    }
}
