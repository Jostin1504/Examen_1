package examen.logic;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    @XmlID
    @XmlElement
    private String codigo;

    @XmlElement
    private String descripcion;

    @XmlElement
    private User responsable;

    @XmlElement
    private List<Tarea> tareas;

    // Constructor vacío
    public Proyecto() {
        this.codigo = "";
        this.descripcion = "";
        this.responsable = new User();
        this.tareas = new ArrayList<>();
    }

    // Constructor con parámetros
    public Proyecto(String id, String nombre, User responsable) {
        this.codigo = id;
        this.descripcion = nombre;
        this.responsable = responsable;

    }


    public String getcodigo() { return codigo; }
    public void setNcodigo(String id) { this.codigo = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String nombre) { this.descripcion = nombre; }

    public List<Tarea> getTareas() {return tareas;}
    public void setTareas(List<Tarea> tareas) {this.tareas = tareas;}

    public User getresponsable() { return responsable; }
    public void setresponsable(User ganados) { this.responsable = ganados; }


    @Override
    public String toString() {
        return descripcion;
    }
}
