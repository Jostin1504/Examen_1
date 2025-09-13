package examen.logic;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "proyecto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proyecto {

    @XmlAttribute
    private String codigo;

    @XmlElement
    private String descripcion;

    @XmlElement
    private User responsable;

    @XmlElement(name = "tarea")
    private List<Tarea> tareas;

    public Proyecto() {
        this.codigo = "";
        this.descripcion = "";
        this.responsable = new User();
        this.tareas = new ArrayList<>();
    }

    public Proyecto(String codigo, String descripcion, User responsable, List<Tarea> tareas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.tareas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public int getNumTareas() {
        return tareas.size();
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
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
